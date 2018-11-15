package com.dobi.day3;


/**
 * 守护线程
 * 守护线程
 守护线程是为其他线程服务的线程
 其他所有非守护线程结束了，守护线程结束，虚拟机退出,gc其实也是守护线程
 */
public class Demo3 {

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0;i<200;i++){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("我是子线程"+i);
                }
            }
        });
        thread.setDaemon(true);//设置为守护线程，主线程挂了后，守护线程就挂了
        thread.start();
        for (int i =0;i<20;i++){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我是主线程"+i);
        }
        System.out.println("主线程走完啦");
    }

}


