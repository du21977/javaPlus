
package com.dobi.orm;

import java.lang.annotation.Target;



public class UserEntity extends Object {

	private String name;

	@OneAnnotation(beanId = 1, className = "UserEntity", arrays = { "111", "12222" })
	public String toString1() {
		return null;
	}

}
