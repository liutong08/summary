package com.example;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.example.service.HelloWorldService;

public class HelloTest {
	private ApplicationContext context;

//获取自动扫描下 id为helloWorldService的类，指定为HelloWorldService类
//（因为spring容器默认不知道调用的bean是什么类型的，需要人工指定），并调用他的sayHello方法
	@Test
	public void hello() {
		context = new FileSystemXmlApplicationContext("classpath:auto.xml");
		context.getBean("helloWorldService", HelloWorldService.class).sayHello();
	}
}
