
package com.dobi.orm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @classDesc: 功能描述:(自定义注解)
 *
 */
@Target(value = { ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface OneAnnotation {

	int beanId() default 0;

	String className() default "";

	String[]arrays();
}
