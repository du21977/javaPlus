package com.dobi.day3;

/**
 * 线程间通信---wait,notify,notifyAll--配合synchronized使用
 */
public class Demo1 {

    public static void main(String[] args) {

        Resource resource = new Resource();

        ProducerThread producerThread1 = new ProducerThread(resource);
        ProducerThread producerThread2 = new ProducerThread(resource);
        ProducerThread producerThread3 = new ProducerThread(resource);
        ConsumerThread consumerThread1 = new ConsumerThread(resource);
        ConsumerThread consumerThread2 = new ConsumerThread(resource);
        ConsumerThread consumerThread3 = new ConsumerThread(resource);

        producerThread1.start();
        producerThread2.start();

        consumerThread1.start();
    }


}


class ProducerThread extends Thread{

    private Resource res;

    public ProducerThread(Resource res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            res.add();//生产
        }
    }
}

class ConsumerThread extends Thread{
    private Resource res;

    public ConsumerThread(Resource res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            res.remove();//消费
        }
    }
}

class Resource{
    //当前资源数量
    private int num =0;
    //资源池中最大的数量
    private int size=10;

    /**
     * 消费者消费资源
     */
    public synchronized void remove(){
        if(num>0){
            num--;
            System.out.println("消费者"+Thread.currentThread().getName()+"消耗一个资源,还剩"+num+"个资源");
            notifyAll();//通知生产者生产资源
        }else {//没有资源怎么办
            try {
                wait();
                System.out.println("消费者"+Thread.currentThread().getName()+"进入等待状态");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void add(){
        if(num<10){
            num++;
            System.out.println("生产者"+Thread.currentThread().getName()+"生产了一个资源,还剩"+num+"个资源");
            notifyAll();//通知消费者
        }else {
            try {
                wait();
                System.out.println("生产者"+Thread.currentThread().getName()+"进入等待状态");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
