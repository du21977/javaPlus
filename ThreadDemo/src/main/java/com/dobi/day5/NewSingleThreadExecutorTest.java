
package com.dobi.day5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewSingleThreadExecutorTest {

	public static void main(String[] args) {
		ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			int index = i;
			newSingleThreadExecutor.execute(new Runnable() {
				public void run() {
					System.out.println(Thread.currentThread().getName() + "---" + index);
				}
			});
		}
	}

}
