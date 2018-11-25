package com.dobi.service.impl;

import javax.annotation.Resource;

import com.dobi.annotation.ExtResource;
import com.dobi.annotation.ExtService;
import com.dobi.service.OrderService;
import com.dobi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;



//将该类注入到spring容器里面
@ExtService
public class UserServiceImpl implements UserService {
	// 从Spring容器中读取bean
	@ExtResource
	private OrderService orderServiceImpl;

	public void add() {
		orderServiceImpl.addOrder();
		System.out.println("我是使用反射机制运行的方法");
	}

}
