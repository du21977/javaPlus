
package com.dobi.entity;

/**
 * 
 * @classDesc: 功能描述:(用户实体类)
 *
 */
public class UserEntity {
	private String userId;
	private String userName;
//	public UserEntity(){
//		System.out.println("使用反射技术 ，执行无参数public构造 函数");
//	}

	private UserEntity(){
		System.out.println("使用反射技术 ，执行无参数private构造 函数");
	}
	public UserEntity(String userId) {
	  System.out.println("使用反射技术 执行 有参公有构造函数 userId:"+userId);
	}

	public String getUserId() {

		return userId;
	}

	public void setUserId(String userId) {

		this.userId = userId;
	}

	public String getUserName() {

		return userName;
	}

	public void setUserName(String userName) {

		this.userName = userName;
	}

}
