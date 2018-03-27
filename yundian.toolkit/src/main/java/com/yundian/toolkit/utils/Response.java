package com.yundian.toolkit.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;


public class Response {
	public static void ResponseHtml(HttpServletResponse httpResponse,
			String json) {
		httpResponse.addHeader("content-type", "text/html;charset=utf-8");
		PrintWriter pw = null;
		try {
			pw = httpResponse.getWriter();
			pw.write(json);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void ReponseValid(HttpServletResponse httpResponse,
			boolean status) {
		JSONObject json = new JSONObject();
		json.put("info", status == true ? "验证通过" : "验证失败");
		json.put("status", status == true ? "y" : "n");
		ResponseHtml(httpResponse, json.toJSONString());
	}
}
