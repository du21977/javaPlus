
package com.dobi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {


	@Value("${server.port}")
	private String port;

	@RequestMapping("/index")
	public String index() {
		return "server---value:" + port;
	}

	@RequestMapping("/setSession")
	public String setSession(HttpServletRequest request, String key, String value) {
		HttpSession session = request.getSession();
		session.setAttribute(key, value);
		return "server---port:" + port + ",success";
	}

	@RequestMapping("/getSession")
	public String getSession(HttpServletRequest request, String key) {
		HttpSession session = null;
		try {
			session = request.getSession(false); //传false表示没有不自己创建session
		} catch (Exception e) {
			// TODO: handle exception
		}
		String value = null;
		if (session != null) {
			value = (String) session.getAttribute(key);
		}

		return "server---port:" + port + "  value:" + value;
	}
}
