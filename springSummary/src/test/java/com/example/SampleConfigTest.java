package com.example;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.exam.config.SampleConfig;
import com.example.beans.AllBean;

public class SampleConfigTest {

	private AnnotationConfigApplicationContext annotation;

	@Before
	public void conf() {
		annotation = new AnnotationConfigApplicationContext(SampleConfig.class);
		//加载java的配置类
//		int i = annotation.getBeanDefinitionCount();
//		System.out.println("bean的个数:" + i);
//		String[] names = annotation.getBeanDefinitionNames();
//		for (String string : names) {
//			System.out.print(string + "-->");
//			Object bean = annotation.getBean(string);
//			System.out.println(bean.getClass());
//		}
	}
	
	@Test
	public void test() {
		String str=annotation.getBean("all",AllBean.class).toString();
		System.out.println(str);
	} 
}
