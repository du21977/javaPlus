package com.itheima.web.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ContextMap 和 ActionContext 以及ValueStack的介绍
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class Hello2Action extends ActionSupport {

    public String demo1(){
        System.out.println("Hello2Action的demo1方法执行了。。。。"+this);
        return "success";
    }
}
