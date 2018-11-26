package com.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service//自动注入
public class HelloWorldService {
	@Value("aaa")//等同于xml中bean对应property的value，自动注入可以不再写setter和构造方法
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
 
	public HelloWorldService() {
		super();
	}

	public HelloWorldService(String name) {
		super();
		this.name = name;
	}

	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("hello " + this.name);
	}
}
