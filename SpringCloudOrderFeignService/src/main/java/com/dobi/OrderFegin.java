package com.dobi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Feign Client调用服务
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OrderFegin {

	 public static void main(String[] args) {
		 SpringApplication.run(OrderFegin.class, args);
	}
	
}
