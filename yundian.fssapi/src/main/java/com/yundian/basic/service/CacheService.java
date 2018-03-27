package com.yundian.basic.service;


public interface CacheService {
	/**
	 * 设置缓存值
	 * @param key
	 * @param value
	 * @param liveTime (单位:秒)
	 */
	void set(String key, Object value, long liveTime);
	
	/**
	 * 取缓存值
	 * @param key
	 * @return
	 */
	Object get(String key);
	
	void set(String key, Object hashKey, Object value);
	
	void delete(String key, Object hashKey);

	void delete(String key);
	
	Object get(String key, Object hashKey);
}
