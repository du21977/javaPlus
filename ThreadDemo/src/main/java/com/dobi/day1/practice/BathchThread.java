package com.dobi.day1.practice;

import java.util.ArrayList;
import java.util.List;

/*
*   多线程分批处理数据
*   使用场景：给20万用户发短信
 */
public class BathchThread {

    public static void main(String[] args) {
        //1.初始化用户
        List<User> userList = initUser();
        //2.定义每个线程最多跑多少数据
        int userCount =2;

        //3，计算每个线程数，并计算每个线程跑哪些数据
        List<List<User>> splitListList = ListUtils.splitList(userList,userCount);
        for (int i=0;i<splitListList.size();i++){
            //System.out.println(splitListList.get(i));
            //4.让子线程进行分批异步处理数据
            UserThread userThread = new UserThread(splitListList.get(i));
            userThread.start();
        }

    }


    /**
     * 初始化用户信息
     * @return
     */
    public static List<User> initUser(){
        List<User> users = new ArrayList<>();
        for (int i=0; i<11;i++){
            users.add(new User("userId"+i,"userName"+i));
        }
        return users;
    }

}

class UserThread extends Thread{
    List<User> listUser;

    public UserThread(List<User> listUser) {
        this.listUser = listUser;
    }

    @Override
    public void run() {
        System.out.println("getName"+getName()+listUser);
    }
}
