package com.dobi;


import com.dobi.service.UserService;
import com.dobi.spring.ClassPathXmlApplicationContext;

/**
 * Spring IOC 手写注解版
 */
public class Test001 {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("com.dobi.service.impl");
		UserService userService = (UserService) app.getBean("userServiceImpl");
		userService.add();
	}

}
