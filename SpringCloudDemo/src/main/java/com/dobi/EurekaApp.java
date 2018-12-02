package com.dobi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka注册中心---服务管理
 * 浏览器输入下面地址，可以看到Eureka界面
 * http://127.0.0.1:8888/
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApp {

	public static void main(String[] args) {
		SpringApplication.run(EurekaApp.class, args);
	}

}
