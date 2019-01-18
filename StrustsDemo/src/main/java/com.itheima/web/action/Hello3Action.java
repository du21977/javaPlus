package com.itheima.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 值栈ValueStack的细节
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class Hello3Action extends ActionSupport  {

    private String name = "泰斯特";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 值栈的使用
     * @return
     */
    public String demo2(){
        //1.获取ActionContext
        ActionContext ac = ActionContext.getContext();
        //2.获取ValueStack
        ValueStack vs = ac.getValueStack();
        //3.使用push方法压栈
//        vs.push("test");
        return "success";
    }
}
