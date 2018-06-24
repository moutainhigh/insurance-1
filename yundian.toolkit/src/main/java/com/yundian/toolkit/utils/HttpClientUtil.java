package com.yundian.toolkit.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


@SuppressWarnings("deprecation")
public class HttpClientUtil {

	private static final int CONN_TIME_OUT = 30000;
	private static final int READ_TIME_OUT = 30000;

	public static String sendGet(String url, Map<String, String> param) throws Exception {
		StringBuffer buffer = new StringBuffer(url);
		if (url.endsWith("/")) {
			buffer.deleteCharAt(buffer.length() - 1);
		}
		buffer.append("?");
		buffer.append(getParams(param));
		StringBuffer result = new StringBuffer();
		BufferedReader in = null;
		try {
			URL realUrl = new URL(buffer.toString());
			// 打开和URL之间的连接
			HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");

			// 设置超时时间
			connection.setConnectTimeout(CONN_TIME_OUT);
			connection.setReadTimeout(READ_TIME_OUT);

			// 建立实际的连接
			connection.connect();
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
		} catch (Exception e) {
			throw e;
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result.toString();
	}

	public static String doGet(String url, Map<String, Object> params, boolean isHttps) {
		HttpResponse response = null;
		String apiUrl = url;
		StringBuffer param = new StringBuffer();
		int i = 0;
		for (String key : params.keySet()) {
			if (i == 0) {
				param.append("?");
			} else {
				param.append("&");
			}
			param.append(key).append("=").append(params.get(key));
			i++;
		}
		apiUrl += param;
		String result = null;
		CloseableHttpClient httpclient;
		if (isHttps) {
			httpclient = createSSLClientDefault();
		} else {
			httpclient = HttpClients.createDefault();
		}
		try {
			HttpGet httpGet = new HttpGet(apiUrl);
			response = httpclient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				result = EntityUtils.toString(entity, "UTF-8");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (response != null) {
				try {
					EntityUtils.consume(response.getEntity());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}


	public static String sendPost(String url, Map<String, String> param) throws Exception {

		StringBuffer buffer = getParams(param);
		PrintWriter out = null;
		BufferedReader in = null;
		StringBuffer result = new StringBuffer();
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

			// 设置超时时间
			conn.setConnectTimeout(CONN_TIME_OUT);
			conn.setReadTimeout(READ_TIME_OUT);

			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.connect();
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(buffer);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
		} catch (Exception e) {
			throw e;
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result.toString();
	}


	private static StringBuffer getParams(Map<String, String> param) throws UnsupportedEncodingException {
		StringBuffer buffer = new StringBuffer();
		if (param != null && !param.isEmpty()) {
			for (Map.Entry<String, String> entry : param.entrySet()) {
				buffer.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue(), "UTF-8"))
						.append("&");
			}
			buffer.deleteCharAt(buffer.length() - 1);
		}
		return buffer;
	}

	private static CloseableHttpClient createSSLClientDefault() {
		try {
			SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
				// 信任所有
				@Override
				public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					return true;
				}
			}).build();
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
			return HttpClients.custom().setSSLSocketFactory(sslsf).build();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		}
		return HttpClients.createDefault();
	}

	public static String sendSSLPost(String url, String params, String contentType) throws Exception {
		CloseableHttpClient httpClient = createSSLClientDefault();
		HttpPost httpPost = new HttpPost(url);
		CloseableHttpResponse response = null;
		String httpStr = null;
		try {
			StringEntity jsonParams = new StringEntity(params, "utf-8");
			httpPost.addHeader("content-type", contentType);
			httpPost.setEntity(jsonParams);
			RequestConfig defaultRequestConfig = RequestConfig.custom()
					.setSocketTimeout(CONN_TIME_OUT)
					.setConnectTimeout(CONN_TIME_OUT)
					.setConnectionRequestTimeout(CONN_TIME_OUT).build();
			httpPost.setConfig(defaultRequestConfig);
			response = httpClient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK) {
				httpStr = EntityUtils.toString(response.getEntity(), "utf-8");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (response != null) {
				try {
					EntityUtils.consume(response.getEntity());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return httpStr;
	}

	public static String sendSSLPost2(String url, Map<String, String> params) throws Exception {
		String defaultCharst="utf-8";
		CloseableHttpClient httpClient = createSSLClientDefault();
		HttpPost httpPost = new HttpPost(url);
		CloseableHttpResponse response = null;
		String httpStr = null;
		try {
			List<NameValuePair> paramsList = new ArrayList<NameValuePair>();
			for (String key : params.keySet()) {
				paramsList.add(new BasicNameValuePair(key, String.valueOf(params.get(key))));
			}
			httpPost.setEntity(new UrlEncodedFormEntity(paramsList, defaultCharst));

			RequestConfig defaultRequestConfig = RequestConfig.custom()
					.setSocketTimeout(CONN_TIME_OUT)
					.setConnectTimeout(CONN_TIME_OUT)
					.setConnectionRequestTimeout(CONN_TIME_OUT).build();
			httpPost.setConfig(defaultRequestConfig);
			response = httpClient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK) {
				httpStr = EntityUtils.toString(response.getEntity(), defaultCharst);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (response != null) {
				try {
					EntityUtils.consume(response.getEntity());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return httpStr;
	}

	public static String sendClientGet(String url, Map<String, String> params) throws Exception {
		String result = "";
		try {
			if (params != null) {
				if (url.contains("?")) {
					url += "&" + getParams(params).toString();
				} else {
					url += "?" + getParams(params).toString();
				}
			}
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(url);
			CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

			//判断网络连接状态码是否正常(0--200都数正常)
			if (httpResponse.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				System.out.println("GET Response Status: " + httpResponse.getStatusLine().getStatusCode());
				System.out.println("httpClient request result:" + result);
			}
			HttpEntity resEntity = httpResponse.getEntity();
			if (resEntity != null) {
				result = EntityUtils.toString(resEntity, "utf-8");
			}
			httpClient.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	public static String sendClientPost(String url, Map<String, String> params) throws Exception {
		String result = null;
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(url);
			if (params != null && !params.isEmpty()) {
				// 设置参数
				List<NameValuePair> list = new ArrayList<NameValuePair>();
				Iterator<Entry<String, String>> iterator = params.entrySet().iterator();
				while (iterator.hasNext()) {
					Entry<String, String> elem = (Entry<String, String>) iterator.next();
					list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
				}
				if (list.size() > 0) {
					UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "utf-8");
					httpPost.setEntity(entity);
				}
			}
			RequestConfig defaultRequestConfig = RequestConfig.custom()
					.setSocketTimeout(CONN_TIME_OUT)
					.setConnectTimeout(CONN_TIME_OUT)
					.setConnectionRequestTimeout(CONN_TIME_OUT).build();
			httpPost.setConfig(defaultRequestConfig);
			CloseableHttpResponse response = httpClient.execute(httpPost);
			if (response != null) {
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
					result = EntityUtils.toString(resEntity, "utf-8");
				}
			}
			//判断网络连接状态码是否正常(0--200都数正常)
			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				System.out.println("GET Response Status: " + response.getStatusLine().getStatusCode());
				System.out.println("httpClient request result:" + result);
			}
			httpClient.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}
}
