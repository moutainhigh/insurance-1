package com.yundian.toolkit.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapUtil {

	public static String Join(Map<String, String> map,String separator)
	{
		 
		StringBuffer buffer = new StringBuffer();
		for (String key : map.keySet()) {
			buffer.append(key+"="+map.get(key));
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

	/**
	 * 将一个 Map 对象转化为一个 JavaBean
	 * @param type 要转化的类型
	 * @param map 包含属性值的 map
	 * @return 转化出来的 JavaBean 对象
	 * @throws IntrospectionException 如果分析类属性失败
	 * @throws IllegalAccessException 如果实例化 JavaBean 失败
	 * @throws InstantiationException 如果实例化 JavaBean 失败
	 * @throws InvocationTargetException 如果调用属性的 setter 方法失败
	 */
	@SuppressWarnings("rawtypes")
	public static <T> T convertMap(Class<T> type, Map map)
			throws IntrospectionException, IllegalAccessException,
			InstantiationException, InvocationTargetException {
		// 获取类属性
		BeanInfo beanInfo = Introspector.getBeanInfo(type);
		// 创建 JavaBean 对象
		T obj = type.newInstance();

		// 给 JavaBean 对象的属性赋值
		PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
		for (int i = 0; i< propertyDescriptors.length; i++) {
			PropertyDescriptor descriptor = propertyDescriptors[i];
			String propertyName = descriptor.getName();

			if (map.containsKey(propertyName)) {
				// 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
				Object value = map.get(propertyName);

				Object[] args = new Object[1];
				args[0] = value;

				descriptor.getWriteMethod().invoke(obj, args);
			}
		}
		return obj;
	}

}
