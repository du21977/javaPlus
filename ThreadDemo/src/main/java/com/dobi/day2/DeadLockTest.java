package com.dobi.day2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

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
 * 死锁解决方式1--用thread1.join()该线程thread1先执行，其他线程等待，该线程执行完后，其他线程才能执行
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
 * 死锁解决方式2--用ReentrantLock
 */
class DeadLockTestResolve2 {

    public static void main(String[] args) {

        DeadLock deadLock = new DeadLock();
        ReentrantLock reentrantLock = new ReentrantLock();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.flag =1 ;

                try {
                    if(reentrantLock.tryLock(5000, TimeUnit.MILLISECONDS)){
                        System.out.println("thread1 get lock ");
                    }else{
                        System.out.println("thread1 dont get lock ");
                        return;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    deadLock.go();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("thread1释放了锁");
                    reentrantLock.unlock();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.flag =2 ;
                try {
                    if(reentrantLock.tryLock(5000, TimeUnit.MILLISECONDS)){
                        System.out.println("thread2 get lock ");
                    }else{
                        System.out.println("thread2 dont get lock ");
                        return;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    deadLock.go();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("thread2释放了锁");
                    reentrantLock.unlock();
                }
            }
        });

        thread1.start();
        thread2.start();

    }

}

/**
 * 死锁
 */
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
                    System.out.println("if--obj2进来了");
                }
            }


        }else if(flag==2){

            synchronized(obj2){
                System.out.println("else--obj2被占了");
                Thread.sleep(2000);
                synchronized (obj1){
                    System.out.println("else--obj1进来了");
                }
            }

        }



    }



}
