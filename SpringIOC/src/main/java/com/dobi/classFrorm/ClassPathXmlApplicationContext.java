
package com.dobi.classFrorm;

import java.lang.reflect.Field;
import java.util.List;

import com.dobi.entity.UserEntity;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


/**
 * 手写Spring IOC----xml版本
 * 1.解析xml文件，找到相应的类全路径
  *2.通过反射创建实例，并给属性赋值
 */

public class ClassPathXmlApplicationContext {
	private String xmlPath;

	public ClassPathXmlApplicationContext(String xmlPath) {
		this.xmlPath = xmlPath;
	}

	public Object getBean(String beanId) throws DocumentException, ClassNotFoundException, NoSuchFieldException,
			SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		// spring 加载过程 或者spring ioc实现原理
		// 1.读取xml配置文件
		// 获取xml解析器
		SAXReader saxReader = new SAXReader();
		// this.getClass().getClassLoader().getResourceAsStream("xmlPath")
		// 获取当前项目路径
		Document read = saxReader.read(this.getClass().getClassLoader().getResourceAsStream(xmlPath));
		// 获取跟节点对象
		Element rootElement = read.getRootElement();
		List<Element> elements = rootElement.elements();
		Object obj = null;
		for (Element sonEle : elements) {
			// 2.获取到每个bean配置 获取class地址
			String sonBeanId = sonEle.attributeValue("id");
			if (!beanId.equals(sonBeanId)) {
				continue;
			}
			String beanClassPath = sonEle.attributeValue("class");
			// 3.拿到class地址 进行反射实例化对象 ，使用反射api 为私有属性赋值
			Class<?> forName = Class.forName(beanClassPath);
			obj = forName.newInstance();
			// 拿到成员属性
			List<Element> sonSoneleme = sonEle.elements();
			for (Element element : sonSoneleme) {
				String name = element.attributeValue("name");
				String value = element.attributeValue("value");
				// 使用反射api 为私有属性赋值
				Field declaredField = forName.getDeclaredField(name);
				//运行往私有成员赋值
				declaredField.setAccessible(true);
				declaredField.set(obj, value);
			}

		}
		// 3.拿到class地址 进行反射实例化对象 ，使用反射api 为私有属性赋值
		return obj;
	}

	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, InstantiationException, DocumentException {
		ClassPathXmlApplicationContext appLication = new ClassPathXmlApplicationContext("user.xml");
		Object bean = appLication.getBean("user1");//拿到beanID
		UserEntity user = (UserEntity) bean;
		System.out.println(user.getUserId() + "----" + user.getUserName());
	}

}
