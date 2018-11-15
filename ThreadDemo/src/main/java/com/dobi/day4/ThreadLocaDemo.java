
package com.dobi.day4;

/**
 * ThreadLocal的使用
 */
public class ThreadLocaDemo extends Thread {

	// public static int count = 0;
	 public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
		protected Integer initialValue() {
			return 0;
		};
	};

	public static void main(String[] args) {
		Thread[] thread = new Thread[5];
		for (int i = 0; i < thread.length; i++) {
			thread[i] = new Thread(new Runnable() {
				public void run() {
//					count += 5;
					Integer count = threadLocal.get();
					count += 5;
					System.out.println(Thread.currentThread().getName() + "---" + count);
				}
			}, "线程" + i);
			thread[i].start();
		}
	}
}
