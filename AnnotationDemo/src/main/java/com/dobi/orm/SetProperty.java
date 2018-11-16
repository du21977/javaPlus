
package com.dobi.orm;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 
 * @classDesc: 功能描述:(定义字段属性)
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface SetProperty {

	/**
	 * 
	 * @methodDesc: 功能描述:(字段名称)
	 *
	 */
	String name();

	/**
	 * 
	 * @methodDesc: 功能描述:(长度)
	 *
	 */
	int leng();

}
