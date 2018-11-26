package com.example.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component//注入bean
//@Component("bb")//以id=bb注入bean
public class BBean {
	@Value("bbbbb")//设置其下的第一个属性的值为bbbbb，也就是name="bbbbb"
	private String name;
//	以注解形式进行bean注入，不需要再写setter方法和构造器
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BBean(String name) {
		super();
		this.name = name;
	}

	public BBean() {
		super();
	}

	@Override
	public String toString() {
		return "BBean [name=" + name + "]";
	}
	
}
