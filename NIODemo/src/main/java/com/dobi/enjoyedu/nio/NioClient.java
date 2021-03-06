package com.dobi.enjoyedu.nio;

import java.util.Scanner;


import static com.dobi.enjoyedu.Ch01Const.DEFAULT_PORT;
import static com.dobi.enjoyedu.Ch01Const.DEFAULT_SERVER_IP;

/**
 * @author Mark老师   享学课堂 https://enjoy.ke.qq.com
 * 类说明：nio通信客户端
 */
public class NioClient {

    private static NioClientHandle nioClientHandle;

    public static void start(){
        if(nioClientHandle !=null)
            nioClientHandle.stop();
        nioClientHandle = new NioClientHandle(DEFAULT_SERVER_IP,DEFAULT_PORT);
        new Thread(nioClientHandle,"Client").start();
    }
    //向服务器发送消息
    public static boolean sendMsg(String msg) throws Exception{
        nioClientHandle.sendMsg(msg);
        return true;
    }
    public static void main(String[] args) throws Exception {
        //开启线程
        start();
        Scanner scanner = new Scanner(System.in);
        while(NioClient.sendMsg(scanner.next()));

    }

}
