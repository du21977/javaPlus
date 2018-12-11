package com.dobi.order.service;

import com.dobi.member.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class OrderService {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("consumer.xml");
		applicationContext.start();
		System.out.println("订单服务启动成功..");
		UserService userService = (UserService) applicationContext.getBean("userService");
		System.out.println("订单服务调用会员服务开始...");
		String result = userService.getUser(1l);
		System.out.println("订单服务调用会员服务结束...result:"+result);
	}

}
