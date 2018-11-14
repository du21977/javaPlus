package com.dobi.day2;

/**
 * 抢火车票出现线程同步问题
 *
 * 当多个线程同时操作同一共享变量时，就可能出现数据冲突
 * 怎么解决线程安全？
 * 1.使用synchronized同步代码块,同步方法，同步方法用的this锁，就是那个类所对应的对象的this；同步代码块可以是this可以自己new Object
 *      静态同步方法使用类.class锁
 * 2.使用java1.5并发包 lock
 * 这种只适合单个的jvm，如果是集群，就不合适了，得用分布式锁zp--zookeeper
 *
 */
public class Demo1 {

    public static void main(String[] args) {
        TicketThread ticketThread = new TicketThread();
        Thread thread1 = new Thread(ticketThread);
        Thread thread2 = new Thread(ticketThread);
        thread1.start();
        thread2.start();
    }




}


 class TicketThread implements Runnable{

    private  int count =100;

    private Object object = new Object();
     @Override
     public void run() {
//         synchronized (object){  //放在这里就变单线程啦
         while (count>0){
             synchronized (object){
                 System.out.println("getName"+Thread.currentThread().getName()+"出售第"+(100-count+1)+"张票");
                 count--;
             }

             try {
                 Thread.sleep(50);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }


         }

     }
 }
