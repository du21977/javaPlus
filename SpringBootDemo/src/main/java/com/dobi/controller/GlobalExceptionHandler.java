package com.dobi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常拦截
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody //拦截返回是json返回结果
    public Map<String ,Object> exceptionHandler(){

        Map<String ,Object> result = new HashMap<String, Object>();
        result.put("code","500");
        result.put("msg","系统错误");
        return result;
    }

}
