package com.yundian.file.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 配置文件读取工具类
 * 
 * @author wuhongzhi
 * 
 */
public class GetProperties {

	// Map<path, Properties>
	private static Map<String, Properties> propertiesCache = new HashMap<String, Properties>();

	/**
	 * 根据key来获取默认配置文件中相应的value
	 * 
	 * @param key
	 *            键名
	 * @return
	 */
	public static String readValue(String key) {
		return readValue("/statics.properties", key);
	}

	/**
	 * 从指定配置文件里读取具体的key值
	 * 
	 * @param path
	 *            配置文件地址(如：/statics.properties)
	 * @param key
	 *            键名
	 * @return
	 */
	public static String readValue(String path, String key) {
		if (!propertiesCache.containsKey(path)) {
			InputStream ips = null;
			try {
				ips = GetProperties.class.getResourceAsStream(path);
				Properties props = new Properties();
				props.load(ips);
				propertiesCache.put(path, props);
				return propertiesCache.get(path).getProperty(key);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			} finally {
				try {
					if (ips != null) {
						ips.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return propertiesCache.get(path).getProperty(key);
	}
}
