package com.dobi.service.impl;


import com.dobi.annotation.ExtService;
import com.dobi.service.OrderService;

@ExtService
public class OrderServiceImpl implements OrderService {


	public void addOrder() {
		System.out.println("addOrder");
	}

}
