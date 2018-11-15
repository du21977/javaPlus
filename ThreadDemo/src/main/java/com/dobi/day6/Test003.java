
package com.dobi.day6;

import java.util.concurrent.CyclicBarrier;

/**
 *CyclicBarrier --等所有线程执行完毕后，才执行遗留代码
 */
class Writer extends Thread {
	CyclicBarrier cyclicBarrier;
	public Writer(CyclicBarrier cyclicBarrier){
		this.cyclicBarrier=cyclicBarrier;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "开始写入数据...");
		try {
			// 耗时
			Thread.sleep(30);
			
			// ִ并行执行成功
			System.out.println(Thread.currentThread().getName() + "写入数据成功...");
			cyclicBarrier.await(); //等所有的线程执行完毕后，才执行下面代码
			System.out.println(Thread.currentThread().getName() + "所有数据执行完毕...");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}

public class Test003 {

	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier=	new CyclicBarrier(5);
		for (int i = 0; i < 5; i++) {
			new Writer(cyclicBarrier).start();
		}
	}

}
