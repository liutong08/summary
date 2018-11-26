package com.example.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//容器配置的第二种：注解方式
@Component//注入bean
//@Component("ab")//以id=ab注入bean
public class ABean {
	@Value("aaaaa")//设置其下的第一个属性的值为aaaaa，也就是name="aaaaa"
	private String name;
//	以注解形式进行bean注入，不需要再写setter方法和构造器
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ABean() {
		super();
	}

	public ABean(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "ABean [name=" + name + "]";
	}
	
}
