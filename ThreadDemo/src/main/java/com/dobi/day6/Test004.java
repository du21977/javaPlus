
package com.dobi.day6;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Semaphore计数的信号量
 *
 * 10个人抢3个茅坑，挺形象的
 */
class Parent extends  Thread {
	Semaphore wc;
	String name;

	public Parent(Semaphore wc, String name) {
		this.wc = wc;
		this.name = name;
	}

	@Override
	public void run() {
		// 获取到资源权限，资源数要减一，当资源为0的时候，就一直等
		int availablePermits = wc.availablePermits();
		if (availablePermits > 0) {
			System.out.println(name + "终于等到茅坑了");
		} else {
			System.out.println(name + "茅坑呀，你们快点啊，我快啦裤子了.....");
		}
		try {
			//获取到资源
			wc.acquire();
			System.out.println(name+"终于可以上厕所了ˬ!!!");
			
			Thread.sleep(new Random().nextInt(1000)); // ģ���ϲ���ʱ�䡣
			System.out.println(name+"上完厕所了!");
			
		} catch (InterruptedException e) {

		}finally {
			//释放茅坑
			wc.release();
		}

	}
}

public class Test004 {

	public static void main(String[] args) throws InterruptedException {
//		// 最多支持多少个资源
//		Semaphore semaphore = new Semaphore(5);
//		// 获取到资源权限，资源数要减一
//		semaphore.availablePermits();
//		// 释放资源
//		semaphore.release();
		Semaphore semaphore = new Semaphore(3);
		for (int i = 1; i <=10; i++) {
			  new Parent(semaphore,"第"+i+"个"+",").start();
		}
	}

}
