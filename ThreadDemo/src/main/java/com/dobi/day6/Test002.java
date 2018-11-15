
package com.dobi.day6;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch的使用
 */
public class Test002 {

	public static void main(String[] args) throws InterruptedException {
	   CountDownLatch countDownLatch = new CountDownLatch(6);
		new Thread(new Runnable() {
			public void run() {
				System.out.println("子线程开始执行任务......");
				try {
					//子线程真正处理
					Thread.sleep(10);
				} catch (Exception e) {
					// TODO: handle exception
				}
				countDownLatch.countDown();//每次减一
				System.out.println("子线程开始执行任务............");
			}
		}).start();;
		new Thread(new Runnable() {
			public void run() {
				System.out.println("子线程开始执行任务............");
				try {
					////子线程真正处理
					Thread.sleep(10);
				} catch (Exception e) {
					// TODO: handle exception
				}
				countDownLatch.countDown();//每次减一
				System.out.println("子线程开始执行任务............");
			}
		}).start();;
		countDownLatch.await();//如果不为0，就一直等待，如果为0，下面代码开始执行
		System.out.println("主线程开始执行任务......");
		for (int i = 0; i < 10; i++) {
			System.out.println("main i:"+i);
		}
	}

}
