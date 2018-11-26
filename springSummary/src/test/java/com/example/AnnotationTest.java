package com.example;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.beans.AllBean;
import com.example.service.HelloWorldService;

public class AnnotationTest {
	private AnnotationConfigApplicationContext anno;

	@Before//执行操作前
	public void init() {
		//自动扫描com.example 包下的所有文件和包
		anno = new AnnotationConfigApplicationContext();
		anno.scan("com.example");
		anno.refresh();
		//关闭IOC容器
		anno.registerShutdownHook();

//		int i = anno.getBeanDefinitionCount();
//		System.out.println("bean的个数:" + i);
//		String[] names = anno.getBeanDefinitionNames();
//		for (String string : names) {
//			System.out.print(string + "-->");
//			Object bean = anno.getBean(string);
//			System.out.println(bean.getClass());
//		}
	}
	//获取自动扫描下bean id为helloWorldService类，由于自动扫描添加注解没有指定bean的id，因此默认为bean的类名的首字母小写
	@Test
	public void test() {
		anno.getBean("helloWorldService", HelloWorldService.class).sayHello();
	}
	//获取自动扫描下bean id为allBean的类，由于自动扫描添加注解没有指定bean的id，因此默认为bean的类名的首字母小写
	@Test
	public void testAllBean() {
		String str=anno.getBean("allBean",AllBean.class).toString();
		System.out.println(str);
	}
}
