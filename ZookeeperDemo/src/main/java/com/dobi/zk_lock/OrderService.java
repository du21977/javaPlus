package com.dobi.zk_lock;

import java.util.concurrent.locks.ReentrantLock;

//使用多线程模拟生成订单号
public class OrderService implements Runnable {
	private OrderNumGenerator orderNumGenerator = new OrderNumGenerator();
	// 使用lock锁--lock锁是手动挡，必须自己释放锁
	// private java.util.concurrent.locks.Lock lock = new ReentrantLock();
	//调用我们自己写的zookeeper分布式锁，每个线程，都new一个锁，相当于每个服务器都去创建一个zookeeper连接，用完自己关闭连接，不会对别的服务器产生影响
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
//		OrderService orderService = new OrderService();  //如果用zookeeper锁得用，不能用同一个连接，得全部new，相对当于多个服务器去连接zookeeper
		for (int i = 0; i < 100; i++) {
			new Thread( new OrderService()).start();
		}

	}
}
