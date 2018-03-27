package com.yundian.toolkit.utils;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class SerializeToJSON {

	
	/**
	 * url参数转成json
	 * @param serializeStr
	 * @return
	 */
	public static String toJson(String serializeStr)
	{
		String[] arrayParam = serializeStr.split("&");
		Map<String,String> map= new HashMap<String,String>();
		for(String param:arrayParam)
		{
			String[] temp = param.split("=");
			if(temp.length>1)
				map.put(temp[0], temp[1]);
		}
		return JSON.toJSONString(map);
	}
	
	
	public static void main(String[] args)
	{
		String ss =toJson("housingFund=&creditReportRemark=意见说明&creditId=67&creditStatus=CREDIT_PASS");
		System.out.println(ss);
	}
}
