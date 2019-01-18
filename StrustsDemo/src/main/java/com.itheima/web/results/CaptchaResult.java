package com.itheima.web.results;

import cn.dsna.util.images.ValidateCode;
import com.opensymphony.xwork2.ActionInvocation;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsResultSupport;

import javax.servlet.http.HttpServletResponse;

/**
 * 自定义结果类型
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class CaptchaResult extends StrutsResultSupport {

    private int width;
    private int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * 用于实现生成验证码
     * @param s
     * @param actionInvocation
     * @throws Exception
     */
    @Override
    protected void doExecute(String s, ActionInvocation actionInvocation) throws Exception {
        //1.创建验证码对象
        ValidateCode vc = new ValidateCode(width,height,4,10);//宽度，高度，验证码个数，干扰线条数
        //2.获取response对象
        HttpServletResponse response = ServletActionContext.getResponse();
        //3.输出验证码
        vc.write(response.getOutputStream());
    }
}
