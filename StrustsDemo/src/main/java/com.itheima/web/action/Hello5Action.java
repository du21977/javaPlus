package com.itheima.web.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 国际化
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class Hello5Action extends ActionSupport {

    /**
     * 输出读到的内容
     *
     * @return
     */
    public String demo5(){
        String value = super.getText("key");
        System.out.println(value);
        return "success";
    }
}
