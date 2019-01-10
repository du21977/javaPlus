package com.enjoy.cap10.aop;

import org.springframework.stereotype.Component;


public class Calculator {
	//业务逻辑方法
	public int div(int i, int j)  {
		System.out.println("--------");
		return i/j;
	}
	
}
