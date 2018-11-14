package com.dobi.day1;

/**
 * 多线程的创建
 */
public class ThreadDemo1 {

    public static void main(String[] args) {
        //创建线程
        //1.方式1---直接继承Thread
        Thread1 thread1 = new Thread1();
//        thread1.run();//还是在主线程中执行
        thread1.start();//真正开启线程，在子线程中运行

        //2.方式二---实现Runnable
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

        //3.方式三----匿名内部类
         new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0;i<10;i++){
                    System.out.println("匿名内部类---"+i);
                }
            }
        }).start();


       ///////////////////////////////线程常见的API//////////////////////////////////
        System.out.println("主线程name---"+Thread.currentThread().getName());

    }
}

/**
 * 多线程：方式一
 */
class Thread1 extends  Thread{

    @Override
    public void run() {
        for (int i =0;i<10;i++){
            System.out.println("thread1---"+i);
            System.out.println("getId---"+getId());
            System.out.println("getName---"+getName());

            try {
                //sleep作用：让当前线程的运行状态变为休眠状态，当时间到期，线程由休眠状态变成运行状态
                //sleep不能释放锁，多线程wait释放锁
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyRunnable implements  Runnable{

    @Override
    public void run() {
        for (int i =0;i<10;i++){
            System.out.println("runnable---"+i);
            //在Runnable中不能直接使用getId和getName
//            System.out.println("getId---"+getId());
//            System.out.println("getName---"+getName());

            System.out.println("Runnable--getId---"+Thread.currentThread().getId());
            System.out.println("Runnable--getName---"+Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
