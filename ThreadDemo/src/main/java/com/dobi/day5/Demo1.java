package com.dobi.day5;

import java.util.concurrent.Executors;

/**
 * 线程池
 */
public class Demo1 {

//    java1.5并发包，出现了线程池Executor,他提供了四种线程池
        public static void main(String[] args) {
            //创建一个可缓存的线程池，可灵活回收空闲线程，如果没有线程，则创建线程
            //基本都是用这个
            Executors.newCachedThreadPool();
            //创建一个固定大小的线程池，超出线程范围，会在队列中等待
            Executors.newFixedThreadPool(5);
            //创建一个固定大小的线程池，支持定时周期性处理任务
            Executors.newScheduledThreadPool(5);
            //创建一个单线程线程池，所有任务排队执行
            Executors.newSingleThreadExecutor();

        }

}
