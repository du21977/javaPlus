package com.dobi.day4;

/**
 * 线程的可见性-----volatile关键字
 */
public class Demo1 {

    public static void main(String[] args) throws InterruptedException {
        ThreadVolatileDemo threadVolatileDemo = new ThreadVolatileDemo();

        threadVolatileDemo.start();
        Thread.sleep(400);
        threadVolatileDemo.flag=false;

    }


}


class ThreadVolatileDemo extends Thread{

    public volatile boolean flag = true;

    @Override
    public void run() {
        System.out.println("子线程开始执行啦");
        while (flag){

        }
        System.out.println("子线程结束啦");
    }

}
