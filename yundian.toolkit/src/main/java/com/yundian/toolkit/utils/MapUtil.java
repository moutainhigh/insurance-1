package com.yundian.toolkit.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapUtil {

	public static String Join(Map<String, String> map,String separator)
	{
		 
		StringBuffer buffer = new StringBuffer();
		for (String key : map.keySet()) {
			buffer.append(key+"="+map.get(key).toString());
			buffer.append(separator);
		}
		if(buffer.length()>0)
		{
			return buffer.substring(0,buffer.length()-1);
		}
		return "";
	}

	public static <T> List<T> mergeObj(Class<T> tClass,T... objects)
	{
		List<T> list = new ArrayList<>();
		for(T obj:objects) {
			if(obj!=null){
				list.add(obj);
			}
		}
		return list;
	}

}
