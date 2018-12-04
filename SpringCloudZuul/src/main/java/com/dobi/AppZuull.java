package com.dobi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 网关接口
 */
@EnableZuulProxy  //开启网关
@EnableEurekaClient
@SpringBootApplication
public class AppZuull {

	 public static void main(String[] args) {
		SpringApplication.run(AppZuull.class, args);
	}
	
}
