package com.dobi;

import com.dobi.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 这是基于SpringAOP手写的事务
 */

public class Test001 {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
		userService.add();
	}

}
