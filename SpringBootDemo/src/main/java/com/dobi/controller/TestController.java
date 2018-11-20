package com.dobi.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//这个相当于@Controller 和 @ResponseBody（返回json格式）
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "hello";
    }

}
