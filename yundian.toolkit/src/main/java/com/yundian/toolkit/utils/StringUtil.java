package com.yundian.toolkit.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	/**
	 * 生成序列号，前缀+年月日十分秒+随机数
	 * 
	 * @param prefix前缀
	 * @param digit随机数位数
	 * @return
	 */
	public static String getNo(String prefix, int digit) {
		return prefix + DateUtils.format(new Date(), "yyyyMMddHHmmss") + RandomUtil.generateRandomNumber(digit);
	}

	/**
	 * 字符串空处理，去除首尾空格 如果str为null，返回"",否则返回str
	 * 
	 * @param str
	 * @return
	 */
	public static String isNull(String str) {
		if (str == null) {
			return "";
		}
		return str.trim();
	}

	/**
	 * 将对象转为字符串
	 * 
	 * @param o
	 * @return
	 */
	public static String isNull(Object o) {
		if (o == null) {
			return "";
		}
		String str = "";
		if (o instanceof String) {
			str = (String) o;
		} else {
			str = o.toString();
		}
		return str.trim();
	}

	public static boolean isBlank(Object o) {
		return StringUtil.isNull(o).equals("");
	}

	/**
	 * 检验是否非空字符串
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(String str) {
		return !StringUtil.isNull(str).equals("");
	}

	public static boolean checkEmail(String email) {
		// String regex = "^[a-zA-Z][a-zA-Z0-9._-]*\\@\\w+(\\.)*\\w+\\.\\w+$";
		String regex = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(email);
		return matcher.matches();
	}

	public static boolean checkMobile(String mobile) {
		String regex = "^[1]([3][0-9]{1}|59|58|88|89)[0-9]{8}$";
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(mobile);
		return matcher.matches();
	}

	public static String formatHTMLIn(String html) {
		if (html != null) {
			html = html.replaceAll("&", "&amp;");
			html = html.replaceAll("<", "&lt;");
			html = html.replaceAll(">", "&gt;");
			html = html.replaceAll("\"", "&quot;");
		}
		return html;
	}

	public static String formatHTMLOut(String html) {
		if (html != null) {
			html = html.replaceAll("&amp;", "&");
			html = html.replaceAll("&lt;", "<");
			html = html.replaceAll("&gt;", ">");
			html = html.replaceAll("&quot;", "\"");
		}
		return html;
	}

	public static String subString(String s, int length) {
		if (isBlank(s))
			return "";
		if (s.getBytes().length <= length)
			return s;
		char ch[] = null;
		if (s.length() >= length)
			ch = s.substring(0, length).toCharArray();
		else
			ch = s.toCharArray();
		int readLen = 0;
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < ch.length; i++) {
			String c = String.valueOf(ch[i]);
			readLen += c.getBytes().length;
			if (readLen > length)
				return sb.toString();
			sb.append(c);
		}
		return sb.toString();
	}

	public static boolean checkLength(String str, int minLength, int maxLength) {
		if (str != null) {
			int len = str.length();
			if (minLength == 0)
				return len <= maxLength;
			else if (maxLength == 0)
				return len >= minLength;
			else
				return (len >= minLength && len <= maxLength);
		}
		return false;
	}

	public static String decodeStringByUTF8(String str) {
		if (isBlank(str))
			return "";
		try {
			return URLDecoder.decode(str, "utf-8");
		} catch (UnsupportedEncodingException e) {
		}
		return "";
	}

	public static String encodeStringByUTF8(String str) {
		if (isBlank(str))
			return "";
		try {
			return URLEncoder.encode(str, "utf-8");
		} catch (UnsupportedEncodingException e) {
		}
		return "";
	}

	public static String getFormatDateStr(Date d) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		return format.format(d);
	}

	/**
	 * 将日期转换成指定的字符串格式形如：2012-05-14T16:00:00
	 * 
	 * @param d
	 *            日期
	 * @return
	 */
	public static String getSPFormatDateStr(Date d) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(d).replace(' ', 'T');
	}

	public static String getFormatDateStr(Date d, String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(d);
	}

	public static String getOnlyString() {
		return String.valueOf(System.currentTimeMillis());
	}

	public static boolean isBlank(String str) {
		return (str == null || str.trim().equals(""));
	}

	public static boolean isInteger(String str) {
		if (isBlank(str))
			return false;
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isLong(String str) {
		if (isBlank(str))
			return false;
		try {
			Long.parseLong(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isLongs(String str[]) {
		try {
			for (int i = 0; i < str.length; i++)
				Long.parseLong(str[i]);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isIntegers(String str[]) {
		try {
			for (int i = 0; i < str.length; i++)
				Integer.parseInt(str[i]);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static String Md5(String plainText) {
		StringBuffer buf = new StringBuffer("");
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i = 0;
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buf.toString();
	}

	public static long[] stringsToLongs(String str[]) {
		long lon[] = new long[str.length];
		for (int i = 0; i < lon.length; i++)
			lon[i] = Long.parseLong(str[i]);
		return lon;
	}

	public static int[] stringsToIntegers(String str[]) {
		int array[] = new int[str.length];
		for (int i = 0; i < array.length; i++)
			array[i] = Integer.parseInt(str[i]);
		return array;
	}

	public static boolean[] stringsToBooleans(String str[]) {
		boolean array[] = new boolean[str.length];
		for (int i = 0; i < array.length; i++)
			array[i] = Boolean.parseBoolean(str[i]);
		return array;
	}

	public static boolean isTimestamp(String str) {
		try {
			java.sql.Date.valueOf(str);
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	public static Timestamp getTimestampByString(String str) {
		Date d = java.sql.Date.valueOf(str);
		return new Timestamp(d.getTime());
	}

	public static Timestamp addTimestampDay(Timestamp t, int day) {
		Calendar calendar = Calendar.getInstance(Locale.getDefault());
		calendar.setTime(t);
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + day);
		return new Timestamp(calendar.getTimeInMillis());
	}

	public static String getOrderNo(String str) {
		String temp = str.replace("-", "").replace(":", "").replace(" ", "").trim();
		if (temp.indexOf(".") > 0) {
			return temp.split("[.]")[0];
		} else {
			return temp;
		}

	}

	public static String UrlReplace(String url, String replace, String str) {
		String old = replace + "=[^&]*";

		url = url.replaceAll(old, str);
		return url;

	}

	@SuppressWarnings("rawtypes")
	public static String AddURLParams(String url, Map<String, String> paras) {

		String result = url;
		if (paras != null) {
			if (url.indexOf("?") == -1) {
				result += "?";
			} else {
				result += "&";
			}

			Iterator iterator = paras.keySet().iterator();
			try {
				while (iterator.hasNext()) {
					String keyname;

					keyname = URLEncoder.encode((iterator.next().toString()), "UTF-8");

					String value = URLEncoder.encode(paras.get(keyname), "UTF-8");
					if (result.indexOf("?" + keyname + "=") > -1)
						result = UrlReplace(url, "[?]" + keyname, "?" + keyname + "=" + value);
					else if (result.indexOf("&" + keyname + "=") > -1)
						result = UrlReplace(url, "&" + keyname, "&" + keyname + "=" + value);
					else
						result += keyname + "=" + value + "&";
				}
			} catch (UnsupportedEncodingException e) {
				// System.out.println("[WebUtility]");

			}
		}
		if (result.endsWith("&"))
			result = result.substring(0, result.length() - 1);
		return result;
	}

	/**
	 * 137****8275
	 * 
	 * @param phone
	 * @return
	 */
	public static String hideFourPhone(String phone) {
		if (phone == null)
			return phone;
		if (phone.length() > 7) {
			phone = phone.substring(0, 3) + "****" + phone.substring(7, phone.length());
		}
		return phone;
	}
	/**
	 * 首字母大写
	 * @param name
	 * @return
	 */
	public static String captureName(String name) {
        char[] cs=name.toCharArray();
        cs[0]-=32;
        return String.valueOf(cs);
		        
	}
}
