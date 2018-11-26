package com.example;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.example.beans.AllBean;
import com.example.beans.LifeBean;
import com.example.service.HelloWorldService;

public class BeanTest {
	private AbstractApplicationContext context;

	@Test
	public void test() {
		context = new FileSystemXmlApplicationContext("classpath:beans.xml");
		// 获取beans.xml文件中所有bean的个数
		int i = context.getBeanDefinitionCount();
		System.out.println("bean的个数:" + i);
		// 获取beans.xml文件中所有bean的名字,一个数组
		String[] names = context.getBeanDefinitionNames();
		// 强制销毁，关闭IOC容器
		context.registerShutdownHook();
		// 对所有的bean的名字进行遍历
		for (String string : names) {
			System.out.print(string + "-->");
			Object bean = context.getBean(string);
			// 获取该名bean的类
			System.out.println(bean.getClass());
		}
		// 获取以helloWorldService为id的bean，声明为HelloWorldService类并调用sayHello方法
		context.getBean("helloWorldService", HelloWorldService.class).sayHello();
	}

	@Test
	public void life() {
		context = new FileSystemXmlApplicationContext("classpath:beans.xml");
//		LifeBean lifeBean = context.getBean("life", LifeBean.class);
	}

//获取配置文件中的bean id为allbean4
	@Test
	public void allBean() {
		context = new FileSystemXmlApplicationContext("classpath:beans.xml");
		AllBean all = context.getBean("allbean4", AllBean.class);
		System.out.println(all.toString());

	}

}
