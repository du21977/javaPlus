
package com.dobi.day5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewCachedThreadTest {

	public static void main(String[] args) {
		// 创建可缓存线程池
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		// 执行execute 表示创建了线程。 类似 start
		for (int i = 0; i < 30; i++) {
			int index = i;
			newCachedThreadPool.execute(new Runnable() {

				@Override
				public void run() {

					System.out.println(Thread.currentThread().getName() + "----" + index);

				}
			});
			// if (index == 9) {
			// // 关闭线程池
			// newCachedThreadPool.shutdown();
			// }

		}
	}

}
