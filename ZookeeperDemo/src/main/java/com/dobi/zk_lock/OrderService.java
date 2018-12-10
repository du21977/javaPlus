package com.dobi.zk_lock;

import java.util.concurrent.locks.ReentrantLock;

//使用多线程模拟生成订单号
public class OrderService implements Runnable {
	private OrderNumGenerator orderNumGenerator = new OrderNumGenerator();
	// 使用lock锁--lock锁是手动挡，必须自己释放锁
	// private java.util.concurrent.locks.Lock lock = new ReentrantLock();
	private Lock lock = new ZookeeperDistrbuteLock();

	public void run() {
		//这里多线程不是同一把锁
//		synchronized (this){
			getNumber();
//		}

	}

	public void getNumber() {
		try {
			lock.getLock();
			String number = orderNumGenerator.getNumber();
			System.out.println(Thread.currentThread().getName() + ",生成订单ID:" + number);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unLock();
		}
	}

	public static void main(String[] args) {
		System.out.println("####生成唯一订单号###");
//		OrderService orderService = new OrderService();
		for (int i = 0; i < 100; i++) {
			new Thread( new OrderService()).start();
		}

	}
}
