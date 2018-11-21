
package com.dobi.confg;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @classDesc: 功能描述:(创建一个队列)
 *
 */
@Configuration
public class QueueConfig {
	@Value("${queue}")
	private String queueName;

	@Bean
	public Queue queue() {
		return new ActiveMQQueue(queueName);
	}

}
