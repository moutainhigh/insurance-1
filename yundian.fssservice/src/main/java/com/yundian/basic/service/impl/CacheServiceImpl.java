package com.yundian.basic.service.impl;

import com.yundian.basic.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class CacheServiceImpl implements CacheService {
	@Autowired
    protected RedisTemplate<String, Object> redisTemplate;
	
	public void set(String key, Object value, long liveTime) {
		redisTemplate.opsForValue().set(key, value, liveTime, TimeUnit.SECONDS);
    }
	
	public Object get(String key) {
		return redisTemplate.opsForValue().get(key);
    }
	
	public void set(String key, Object hashKey, Object value){
		redisTemplate.opsForHash().put(key, hashKey, value);
	}
	
	public void delete(String key, Object hashKey){
		redisTemplate.opsForHash().delete(key, hashKey);
	}
	
	public void delete(String key){
		redisTemplate.delete(key);
	}

	public Object get(String key, Object hashKey){
		return redisTemplate.opsForHash().get(key, hashKey);
	}
}
