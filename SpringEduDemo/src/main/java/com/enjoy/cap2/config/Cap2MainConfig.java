package com.enjoy.cap2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.enjoy.cap1.Person;
import com.enjoy.cap2.controller.OrderController;

@Configuration
//@Controller  @Service  @Respostry  @Component
//type=FilterType.ANNOTATION--CUSTOM
@ComponentScan(value="com.enjoy.cap2", includeFilters={
		//@Filter(type=FilterType.ANNOTATION, classes={Controller.class})
		@Filter(type=FilterType.CUSTOM, classes={JamesTypeFilter.class}) //自定义过滤器
}, useDefaultFilters=false)


public class Cap2MainConfig {
	//给容器中注册一个bean, 类型为返回值的类型, 
	@Bean
	public Person person02(){
		return new Person("james",20);
	}
}
