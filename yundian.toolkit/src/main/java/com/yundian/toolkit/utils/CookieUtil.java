package com.yundian.toolkit.utils;

import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

	/**
	 * 路径
	 */
	private static final String cookiePath = "/";
	
	/**
	 * 过期时间
	 */
	private static final int timeout = 7 * 24 * 3600;
	
	
	/**
	 * 设置cookie
	 * @param cookieName cookie名字
	 * @param cookieValue cookie值
	 * @param expiry 过期时间（单位秒）
	 * @param response
	 */
	public static void setDefaultExpiryCookie(String cookieName, String cookieValue,HttpServletRequest request, HttpServletResponse response) {
		try {
			Cookie cookie = new Cookie(cookieName, URLEncoder.encode(cookieValue, "utf-8"));
			StringBuffer url = request.getRequestURL();
			String domain = null;
			if(url.toString().startsWith("http://")){
				domain = url.toString().substring(7);
			}
			if(domain.indexOf("/") > 0){
				domain = domain.substring(0, domain.indexOf("/"));
			}
			if(domain.contains(":")){
				domain = domain.substring(0, domain.indexOf(":"));
			}
			cookie.setDomain(domain);

			cookie.setPath(cookiePath);
			response.addCookie(cookie);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 设置cookie
	 * @param cookieName cookie名字
	 * @param cookieValue cookie值
	 * @param response
	 */
	public static void setCookie(String cookieName, String cookieValue, HttpServletRequest request, HttpServletResponse response) {
		try {
			Cookie cookie = new Cookie(cookieName, URLEncoder.encode(cookieValue, "utf-8"));
			StringBuffer url = request.getRequestURL();
			String domain = null;
			if(url.toString().startsWith("http://")){
				domain = url.toString().substring(7);
			}
			if(domain.indexOf("/") > 0){
				domain = domain.substring(0, domain.indexOf("/"));
			}
			if(domain.contains(":")){
				domain = domain.substring(0, domain.indexOf(":"));
			}
			cookie.setDomain(domain);
			cookie.setMaxAge(timeout);
			cookie.setPath(cookiePath);
			response.addCookie(cookie);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 设置cookie
	 * @param cookieName cookie名字
	 * @param cookieValue cookie值
	 * @param expiry 过期时间（单位秒）
	 * @param response
	 */
	public static void setCookie(String cookieName, String cookieValue, int expiry,HttpServletRequest request, HttpServletResponse response) {
		try {
			Cookie cookie = new Cookie(cookieName, URLEncoder.encode(cookieValue, "utf-8"));
			StringBuffer url = request.getRequestURL();
			String domain = null;
			if(url.toString().startsWith("http://")){
				domain = url.toString().substring(7);
			}
			if(domain.indexOf("/") > 0){
				domain = domain.substring(0, domain.indexOf("/"));
			}
			if(domain.contains(":")){
				domain = domain.substring(0, domain.indexOf(":"));
			}
			cookie.setDomain(domain);
			cookie.setMaxAge(expiry);
			cookie.setPath(cookiePath);
			response.addCookie(cookie);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 设置cookie
	 * @param cookieName cookie名字
	 * @param cookieValue cookie值
	 * @param expiry 过期时间（单位秒）
	 * @param path 路径
	 * @param response
	 */
	public static void setCookie(String cookieName, String cookieValue, int expiry, String path, HttpServletRequest request, HttpServletResponse response) {
		try{
			Cookie cookie = new Cookie(cookieName, URLEncoder.encode(cookieValue, "utf-8"));
			StringBuffer url = request.getRequestURL();
			String domain = null;
			if(url.toString().startsWith("http://")){
				domain = url.toString().substring(7);
			}
			if(domain.indexOf("/") > 0){
				domain = domain.substring(0, domain.indexOf("/"));
			}
			if(domain.contains(":")){
				domain = domain.substring(0, domain.indexOf(":"));
			}
			cookie.setDomain(domain);
			cookie.setMaxAge(expiry);
			cookie.setPath(path);
			response.addCookie(cookie);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 设置cookie
	 * @param cookieName cookie名字
	 * @param cookieValue cookie值
	 * @param expiry 过期时间（单位秒）
	 * @param path 路径
	 * @param domain 域名
	 * @param response
	 */
	public static void setCookie(String cookieName, String cookieValue, int expiry, String path, String domain, HttpServletResponse response) {
		try {
			Cookie cookie = new Cookie(cookieName, URLEncoder.encode(cookieValue, "utf-8"));
			cookie.setDomain(domain);
			cookie.setMaxAge(expiry);
			cookie.setPath(path);
			response.addCookie(cookie);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取cookie
	 * @param cookieName cookie名字
	 * @param request
	 * @return
	 */
	public static String getCookie(String cookieName, HttpServletRequest request) {
		try {
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					Cookie c = cookies[i];
					if (c.getName().equalsIgnoreCase(cookieName)) {
						return URLDecoder.decode(c.getValue(), "utf-8");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 删除cookie
	 * @param cookieName cookie名字
	 * @param response
	 */
	public static void delCookie(String cookieName, HttpServletRequest request, HttpServletResponse response) {
		Cookie cookie = new Cookie(cookieName, null);
		StringBuffer url = request.getRequestURL();
		String domain = null;
		if(url.toString().startsWith("http://")){
			domain = url.toString().substring(7);
		}
		if(domain.indexOf("/") > 0){
			domain = domain.substring(0, domain.indexOf("/"));
		}
		if(domain.contains(":")){
			domain = domain.substring(0, domain.indexOf(":"));
		}
		cookie.setDomain(domain);
		cookie.setMaxAge(-1);
		cookie.setPath(cookiePath);
		response.addCookie(cookie);
	}
}
