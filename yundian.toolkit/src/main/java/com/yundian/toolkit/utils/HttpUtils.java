package com.yundian.toolkit.utils;

import javax.servlet.ServletRequest;

import org.apache.commons.lang.StringUtils;

public class HttpUtils {
	public static Integer getInteger(ServletRequest request, String paraName){
		String value = request.getParameter(paraName);
		if(StringUtils.isBlank(value))return null;
		
		try {
			return Integer.valueOf(value);
		} catch (NumberFormatException e) {
			return null;
		}
	}
}
