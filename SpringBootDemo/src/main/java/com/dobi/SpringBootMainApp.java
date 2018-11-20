package com.dobi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //第一种启动方式
//@EnableAutoConfiguration  //第二种启动方式
public class SpringBootMainApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMainApp.class,args);
    }
}
