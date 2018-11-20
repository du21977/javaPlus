package com.dobi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * FreeMarker模板
 */
@Controller
public class TemplatesController {

    @RequestMapping("/index")
    public  String index(ModelMap map){
        map.addAttribute("name","duchengwen");
        map.put("sex",1);//0 男 1 女 其他
        List<String> userList=new ArrayList<String>();
        userList.add("张三");
        userList.add("王五");
        userList.add("王麻子");
        map.addAttribute("userList", userList);
        return  "index"; //这个会跳页面，因为没有@ResponseBody
    }
}
