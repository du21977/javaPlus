package com.dobi.mapper;

import com.dobi.entity.User;
import com.dobi.orm.annotation.ExtInsert;
import com.dobi.orm.annotation.ExtParam;
import com.dobi.orm.annotation.ExtSelect;

import java.util.List;



public interface UserMapper {

	@ExtInsert("insert into user(userName,userAge) values(#{userName},#{userAge})")
	public int insertUser(@ExtParam("userName") String userName, @ExtParam("userAge") Integer userAge);

	@ExtSelect("select * from User where userName=#{userName} and userAge=#{userAge} ")
	User selectUser(@ExtParam("userName") String name, @ExtParam("userAge") Integer userAge);

}
