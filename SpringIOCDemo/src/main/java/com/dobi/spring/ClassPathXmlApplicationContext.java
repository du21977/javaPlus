package com.dobi.spring;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.dobi.annotation.ExtResource;
import com.dobi.annotation.ExtService;
import com.dobi.utils.ClassUtil;
import org.apache.commons.lang.StringUtils;



/**
 * 手写Spring专题 注解版本注入bean
 * 
 *
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ClassPathXmlApplicationContext {
	// 扫包范围
	private String packageName;
	//把bean加入到hashmap中，beanid为String类型，对象为Object
	ConcurrentHashMap<String, Object> initBean = null;

	public ClassPathXmlApplicationContext(String packageName) {
		this.packageName = packageName;
	}

	// 使用beanID查找对象
	public Object getBean(String beanId) throws Exception {
		// 1.使用反射机制获取该包下所有的类已经存在bean的注解类
		List<Class> listClassesAnnotation = findClassExisService();
		if (listClassesAnnotation == null || listClassesAnnotation.isEmpty()) {
			throw new Exception("没有需要初始化的bean");
		}
		// 2.使用Java反射机制初始化对象--
		// -将有对象注解的类放到hashmap中，是以类名第一个字母小写为key，类对应的对象为value
		initBean = initBean(listClassesAnnotation);
		if (initBean == null || initBean.isEmpty()) {
			throw new Exception("初始化bean为空!");
		}
		// 3.使用beanID查找查找对应bean对象，通过hashmap的key得到对象
		Object object = initBean.get(beanId);
		// 4.使用反射读取类的属性,赋值信息------依赖注入
		attriAssign(object);
		return object;
	}

	/**
	 * // 使用反射读取类的属性,赋值信息
	 * 依赖注入-----反射技术
	 * @param object
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */

	public void attriAssign(Object object) throws IllegalArgumentException, IllegalAccessException {
		// 1.获取类的属性是否存在 获取bean注解
		Class<? extends Object> classInfo = object.getClass();
		Field[] declaredFields = classInfo.getDeclaredFields();  //获取所有属性，包括私有属性
		for (Field field : declaredFields) {
			ExtResource extResource = field.getAnnotation(ExtResource.class);//获取注解
			if(extResource!=null){
				// 属性名称
				String name = field.getName();
				System.out.println("属性名"+name);
				// 2.使用属性名称查找bean容器赋值
				Object bean = initBean.get(name);  //去hashmap容器中拿对象
				if (bean != null) {
					// 私有访问允许访问
					field.setAccessible(true);
					// 给属性赋值
					field.set(object, bean);
					continue;
				}
			}

		}

	}

	// 使用反射机制获取该包下所有的类已经存在bean的注解类
	public List<Class> findClassExisService() throws Exception {
		// 1.使用反射机制获取该包下所有的类
		if (StringUtils.isEmpty(packageName)) {
			throw new Exception("扫包地址不能为空!");
		}
		// 2.使用反射技术获取当前包下所有的类
		List<Class<?>> classesByPackageName = ClassUtil.getClasses(packageName);
		// 3.存放类上有bean注入注解
		List<Class> exisClassesAnnotation = new ArrayList<Class>();
		// 4.判断该类上属否存在注解
		for (Class classInfo : classesByPackageName) {
			ExtService extService = (ExtService) classInfo.getDeclaredAnnotation(ExtService.class);
			if (extService != null) {
				exisClassesAnnotation.add(classInfo);
				continue;
			}
		}
		return exisClassesAnnotation;
	}

	// 初始化bean对象----将有对象注解的类放到hashmap中，是以类名第一个字母小写为key，类对应的对象为value
	public ConcurrentHashMap<String, Object> initBean(List<Class> listClassesAnnotation)
			throws InstantiationException, IllegalAccessException {
		ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap<String, Object>();
		for (Class classInfo : listClassesAnnotation) {
			// 初始化对象
			Object newInstance = classInfo.newInstance();
			// 获取父类名称---首字母小写，默认beanid就是这样嘛
			String beanId = toLowerCaseFirstOne(classInfo.getSimpleName());
			concurrentHashMap.put(beanId, newInstance);
		}
		return concurrentHashMap;
	}

	// 首字母转小写
	public static String toLowerCaseFirstOne(String s) {
		if (Character.isLowerCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
	}

}
