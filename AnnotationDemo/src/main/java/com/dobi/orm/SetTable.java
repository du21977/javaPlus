
package com.dobi.orm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @classDesc: 功能描述:(自定义表映射注解 )
 *
 */
@Target(value = { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface SetTable {

	/**
	 * 
	 * @methodDesc: 功能描述:(对应数据库表名称)
	 *
	 */
	String value();

}
