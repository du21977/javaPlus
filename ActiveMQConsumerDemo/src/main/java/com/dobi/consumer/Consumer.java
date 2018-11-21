
package com.dobi.consumer;

import com.dobi.entity.UserEntity;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;


@Component
public class Consumer {

	@JmsListener(destination = "${queue}")
	public void receive(String msg) {
		System.out.println(msg);
		JSONObject jsonObject = new JSONObject();
		UserEntity userEntity = jsonObject.parseObject(msg, UserEntity.class);
		System.out.println(userEntity.getName() + "---" + userEntity.getId());
	}

}
