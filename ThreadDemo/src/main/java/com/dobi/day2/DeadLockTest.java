package com.dobi.day2;

/**
 * 多线程死锁
 */
public class DeadLockTest {

    public static void main(String[] args) {

        DeadLock deadLock = new DeadLock();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.flag =1 ;
                try {
                    deadLock.go();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.flag =2 ;
                try {
                    deadLock.go();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

    }

}

/**
 * 死锁解决方式1--用thread.join()等待一个线程先执行完
 */
 class DeadLockTestResolve1 {

    public static void main(String[] args) {

        DeadLock deadLock = new DeadLock();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.flag =1 ;
                try {
                    deadLock.go();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.flag =2 ;
                try {
                    thread1.join();//先让线程1执行完
                    deadLock.go();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}

/**
 * 死锁解决方式2--用
 */
class DeadLockTestResolve2 {

    public static void main(String[] args) {

        DeadLock deadLock = new DeadLock();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.flag =1 ;
                try {
                    deadLock.go();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.flag =2 ;
                try {
                    thread1.join();//先让线程1执行完
                    deadLock.go();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

    }

}

class DeadLock{

    public   int flag;
    private Object obj1 = new Object();
    private Object obj2 = new Object();

    public void go() throws InterruptedException {

        if(flag ==1){
            synchronized(obj1){
                System.out.println("if--obj1被占了");
                Thread.sleep(3000);
                synchronized (obj2){
                    System.out.println("if--obj2被占了");
                }
            }


        }else if(flag==2){

            synchronized(obj2){
                System.out.println("else--obj2被占了");
                Thread.sleep(2000);
                synchronized (obj1){
                    System.out.println("else--obj1被占了");
                }
            }

        }



    }



}
