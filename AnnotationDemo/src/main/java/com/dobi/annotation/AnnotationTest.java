package com.dobi.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)  //表示只能用在方法上
@Retention(RetentionPolicy.RUNTIME)  //表示在运行期
public @interface AnnotationTest {
    //注解括号中的参数
    String value() default "";
    int id() default 0;

}
