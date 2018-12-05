
package com.dobi.redis;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate redisTemplate;

	public void setStr(String key, String value) {
		setStr(key, value, null);
	}

	public void setStr(String key, String value, Long time) {
		stringRedisTemplate.opsForValue().set(key, value);
		if (time != null)
			stringRedisTemplate.expire(key, time, TimeUnit.SECONDS);
	}

	public Object getKey(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	public void delKey(String key) {
		stringRedisTemplate.delete(key);
	}
}
