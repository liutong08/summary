package com.example.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration//该类为配置类
@PropertySource(value="classpath:test.properties")//声明该类指定使用test.properties中的配置
@ConfigurationProperties(prefix="com.example")//指定配置文件中以前缀com.example对其属性赋值
public class User {
	private String userName;
	private String userPwd;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public User(String userName, String userPwd) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userPwd=" + userPwd + "]";
	}
	
}
