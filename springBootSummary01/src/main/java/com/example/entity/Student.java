package com.example.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration//声明该类为配置类
@ConfigurationProperties(prefix = "student")//指定配置文件中以前缀student对其属性赋值
public class Student {
//	@Value("${me.name}")//获取配置文件中me: name: 的值
//	@Value("aaa")	//直接赋值
	private String name;

//	@Value("${student.age}") //获取配置文件中stduent: age: 的值
	private int age;

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

	public Student() {
		super();
	}

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
