package com.itheima.web.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * OGNL表达式在使用时的注意事项
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class Hello4Action extends ActionSupport  {

    private String name = "动作类中的name";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 往请求域和值栈中各存一个属性名称为name的字符串
     * 字符串的取值不一样
     * 使用EL表达式和OGNL表达式获取请求域和值栈中的name,取到的结果是正确的
     * 改变：
     *  把请求域的name取消。而是存入会话域中
     * @return
     */
    public String demo4(){
        //1.使用ServletActionContext先获取到request对象
        HttpServletRequest request = ServletActionContext.getRequest();
        //2.存入请求域
//        request.setAttribute("name","请求域中的name");
        //2.改变：不再存入请求域，而是存入会话域
        request.getSession().setAttribute("name","会话域中的name");

        System.out.println(request);
        System.out.println(request.getSession());
        System.out.println(request.getSession().getServletContext());
        return "success";
    }
}
