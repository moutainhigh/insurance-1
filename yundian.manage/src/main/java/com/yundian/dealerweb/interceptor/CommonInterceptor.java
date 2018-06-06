package com.yundian.dealerweb.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yundian.dealerweb.util.AdminWebConstants;
import com.yundian.dealerweb.util.WebUtility;
import com.yundian.result.DataTablesPaginatedResult;
import com.yundian.result.Result;
import com.yundian.toolkit.utils.WebUtil;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;

public class CommonInterceptor extends HandlerInterceptorAdapter {

	@SuppressWarnings("unchecked")
	private JSONObject getTimeoutDataTablesPaginatedResult(String message){
		DataTablesPaginatedResult<Object> dataTablesPaginatedResult=new DataTablesPaginatedResult<Object>(); 
		dataTablesPaginatedResult.setData(Collections.EMPTY_LIST);
		JSONObject jsonObject= (JSONObject) JSON.toJSON(dataTablesPaginatedResult);
		jsonObject.put(WebUtil.JSON_RESULT_MESSAGE, message);
		jsonObject.put(WebUtil.JSON_RESULT_STATUS_CODE, WebUtil.ERROR);
		return jsonObject;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		String contextPath = request.getContextPath();
		String requestUri = request.getRequestURI();

		Object userInfo = request.getSession().getAttribute(
				AdminWebConstants.SYS.WEB_ADMIN_USER_SESSION);
		// 判断是否是异步请求
		String header = request.getHeader("X-Requested-With");
		response.setContentType("text/html;charset=utf-8");
		// 判断session是否过期
		if (userInfo!=null) {
			return true;
		}
		// 异步请求
		if (null != header && header.equalsIgnoreCase("fetch")) {
			if(requestUri.endsWith("htm")||requestUri.endsWith("html")){
				response.getWriter().write(JSON.toJSONString(Result.fail("登录超时，请重新登录系统",null).toString()));
			}else{
				//ajax 列表超时处理
				JSONObject jsonObj = new JSONObject();

				jsonObj.put("timeout", "-1");
				jsonObj.put("timeoutHref", contextPath + "/"
						+ WebUtility.LOGIN_LOCATION);

				response.getWriter().write(JSON.toJSONString(Result.fail403("登录超时，请重新登录系统",jsonObj)));
			}
		} else {
			// 同步请求过期数据需要重新登录
			response.getWriter()
					.write("<script language=\"javascript\">alert('登录超时，请重新登录！');"
							+ "top.location.href='"
							+ contextPath
							+ "/"
							+ WebUtility.LOGIN_LOCATION + "';</script>");
			//response.getWriter().close();

		}
		return false;

	}

}
