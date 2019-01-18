package com.itheima.web.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 第一个动作类
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class HelloAction extends ActionSupport {

    public String sayHello(){
        System.out.println("HelloAction的sayHello方法执行了。。。。"+this);
        return "success";
    }
}
