package com.dobi.member.service.impl;


import com.dobi.member.service.UserService;

public class UserServiceImpl   implements UserService {

	public String getUser(Long id) {
		System.out.println("会员服务 接受订单服务####getUser() id:"+id);
          if(id==1){
        	  return "余胜军";
          }
          if(id==2){
        	  return "刘强东";
          }
		return "未找到...";
	}

}
