
package com.dobi.day6;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;

public class Test005 {

	public static void main(String[] args) throws InterruptedException {
		// 同步不阻塞队列
		ConcurrentLinkedDeque concurrentLinkedDeque = new ConcurrentLinkedDeque();
		concurrentLinkedDeque.offer("aaa");
		concurrentLinkedDeque.offer("bbb");
//		System.out.println(concurrentLinkedDeque.size());
//		System.out.println(concurrentLinkedDeque.poll());
//		System.out.println(concurrentLinkedDeque.peek());
//		System.out.println(concurrentLinkedDeque.size());
		//阻塞队列，有大小限制
		ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);
		arrayBlockingQueue.add("zzz");
		arrayBlockingQueue.add("yyy");
		arrayBlockingQueue.add("xxx");
		//���������Ķ���
		boolean offer = arrayBlockingQueue.offer("mmm", 2, TimeUnit.SECONDS);
		System.out.println(arrayBlockingQueue.size()+"---"+offer);
		System.out.println(arrayBlockingQueue.poll());
		System.out.println(arrayBlockingQueue.poll());
		System.out.println(arrayBlockingQueue.poll());
		System.out.println(arrayBlockingQueue.poll());
	}

}
