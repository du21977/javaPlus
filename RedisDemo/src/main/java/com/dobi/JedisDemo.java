
package com.dobi;

import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class JedisDemo {

	public static void main(String[] args) {
		 setString();
//		setList();
//		setSet();
	}

	static public void setString() {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		jedis.auth("root");
		jedis.ping();
		jedis.setex("10", 10, "张三");
		//设置过期时间
		jedis.expire("10",100);
		String value = jedis.get("10");
		System.out.println(value);
	}

	static public void setMap() {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		jedis.auth("root");
		jedis.ping();
		Map<String, String> map = new HashMap<String, String>();
		map.put("张三", "19");
		map.put("李四", "21");
		jedis.hmset("hmset", map);
	}

	static public void setList() {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		jedis.auth("root");
		jedis.lpush("list", "张三");
		jedis.lpush("list", "李四");
		jedis.lpush("list", "王麻衣子");
	}

	static public void setSet() {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		jedis.auth("root");
		jedis.sadd("userSet", "张三");
		jedis.sadd("userSet", "李四");
		jedis.sadd("userSet", "王麻子");
	}

}
