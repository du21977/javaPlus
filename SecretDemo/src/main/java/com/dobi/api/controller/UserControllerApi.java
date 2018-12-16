/**
 * 功能说明:
 * 功能作者:
 * 创建日期:
 * 版权归属:每特教育|蚂蚁课堂所有 www.itmayiedu.com
 */
package com.dobi.api.controller;

import com.dobi.base.BaseApiService;
import com.dobi.base.ResponseBase;
import com.dobi.des.DES;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;


/**
 * 功能说明: <br>
 *
 */
@RequestMapping("/userApi")
@RestController
public class UserControllerApi extends BaseApiService {
	private static final String PASSWORD = "95880288";

	@RequestMapping("/register")
	public ResponseBase register(@RequestBody JSONObject data) {
		String userName = data.getString("userName");
		String passWrod = data.getString("passWrod");
		if (userName.equals("123456") && passWrod.equals("123456")) {
			return setResultSuccess("登陆成功!");
		}
		return setResultError("登陆失败!");
	}

	// 加密方式
	@RequestMapping("/encryptLogin")
	public ResponseBase encryptRegister(String userName, String passWord) throws Exception {
		String decUserName = new String(DES.decrypt(userName.getBytes(), PASSWORD));
		String decpassWord = new String(DES.decrypt(passWord.getBytes(), PASSWORD));
		if (decUserName.equals("123456") && decpassWord.equals("123456")) {
			return setResultSuccess("登陆成功!");
		}
		return setResultError("登陆失败!");
	}

	// 返回加密信息
	@RequestMapping("/encryptUserInfo")
	public ResponseBase encryptUserInfo(String userName, String passWord) throws Exception {
		JSONObject data = new JSONObject();
		data.put("encryptUserName", DES.encrypt(userName.getBytes(), PASSWORD));
		data.put("encryptPassWord", DES.encrypt(passWord.getBytes(), PASSWORD));
		return setResultSuccessData(data);
	}
}
