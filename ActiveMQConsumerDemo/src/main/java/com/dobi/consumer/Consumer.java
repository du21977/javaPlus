
package com.dobi.consumer;

import com.dobi.entity.UserEntity;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;


@Component
public class Consumer {

	@JmsListener(destination = "${queue}")
	public void receive(String msg, Session session, TextMessage textMessage) throws JMSException {
		try {
			System.out.println(msg);
			JSONObject jsonObject = new JSONObject();
			UserEntity userEntity = jsonObject.parseObject(msg, UserEntity.class);
			System.out.println(userEntity.getName() + "---" + userEntity.getId());
			textMessage.getText();
			String messageId = textMessage.getJMSMessageID();
			//网络延时的情况下，第二次消费过来，使用全局ID该消息被签收
			if(messageId == "1"){//查数据库该消息id的标识，
				textMessage.acknowledge(); //手动签收
			}

		}catch (Exception e){
			//日志记录进来到数据库，根据msgID来解决消息的幂等性
//			session.recover();//手动重试机制

		}

	}

}
