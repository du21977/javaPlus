
package com.dobi.controller;



import com.dobi.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class IndexController {
	@Autowired
	private RedisService redisService;

	@RequestMapping("/setRedis")
	public String setRedis(String key, String value) {
		redisService.setStr(key, value,20l);
		return "success";
	}
	
	@RequestMapping("/delStringKey")
	public String reStrRedis(String key){
		redisService.delKey(key);
		return "success";
	}

}
