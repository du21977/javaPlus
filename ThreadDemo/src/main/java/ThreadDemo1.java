

public class ThreadDemo1 {

    public static void main(String[] args) {
        //创建线程
        //1.方式1---直接继承Thread
        Thread1 thread1 = new Thread1();
//        thread1.run();//还是在主线程中执行
        thread1.start();//真正开启线程，在子线程中运行

    }

}


class Thread1 extends  Thread{

    @Override
    public void run() {
        for (int i =0;i<10;i++){
            System.out.println("thread1"+i);
        }
    }
}
