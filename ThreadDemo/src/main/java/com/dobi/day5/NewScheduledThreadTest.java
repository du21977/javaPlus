
package com.dobi.day5;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NewScheduledThreadTest {

	public static void main(String[] args) {
		//线程池 大小
		ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(5);
		//schedule执行定时任务先吃
		newScheduledThreadPool.schedule( new Runnable() {
			public void run() {
				System.out.println("我是三秒钟之后执行......");
			}
		},  3, TimeUnit.SECONDS);
	
	}

}
