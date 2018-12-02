package com.dobi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 注册服务，该工程调用会员服务工程SpringCloudMemberService
 */
@EnableEurekaClient
@SpringBootApplication
public class OrderApp {

	public static void main(String[] args) {
		SpringApplication.run(OrderApp.class, args);
	}

	@Bean  //注入到bean容器
	@LoadBalanced  //支持负载均衡
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
