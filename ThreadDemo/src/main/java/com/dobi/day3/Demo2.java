package com.dobi.day3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * lock锁的基本使用
 */
public class Demo2 {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void test(){

        try {
            lock.lock();
            int a = 1;
            if(a==1){
                condition.await();
//                condition.signalAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            lock.unlock();
        }


    }

    /**
     * 标志位中断
     * @param args
     */
    public static void main(String[] args) {

        boolean run =true;
        int i =0;

        while (run){
           i++;
            System.out.println(i);
           if(i==20){
               run =false;
           }
        }

    }



}
