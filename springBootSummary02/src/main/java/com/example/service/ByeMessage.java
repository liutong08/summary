package com.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
//实现类
@Configuration
@Profile({"bye"})//若当前配置环境为bye，则注入该配置类，并获取bye配置中对于属性的赋值
public class ByeMessage implements MessageService {
	
	@Value("${name:bye}")
	//如果配置中有对name赋值，则使用赋值，若没有赋值，则使用冒号（:）后面的值作为默认值
	private String name;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "bye " + this.name;
	}

}
