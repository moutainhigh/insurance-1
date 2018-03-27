package com.yundian.basic.tools;

import com.alibaba.fastjson.JSON;
import com.yundian.result.ResultProvider;

public class ResultExtendsProvider {

	public static  String getsSuccessResult()
	{
		return JSON.toJSONString(ResultProvider.getsSuccessResult());
	}
	public static  String getsSuccessResult(String message)
	{
		return  JSON.toJSONString(ResultProvider.getsSuccessResult(message));
	}
	public static String  getsFailedResult(String message)
	{
		return  JSON.toJSONString(ResultProvider.getsFailedResult(message));
	}
 
}
