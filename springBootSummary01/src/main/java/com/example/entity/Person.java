package com.example.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data//使用lombok的注解，自动装配setter，getter，tostring方法
//@NoArgsConstructor//无参构造
//@AllArgsConstructor//有参构造
//@Component
@Configuration
@ConfigurationProperties(prefix="per")//在配置文件中通过per.属性即可对person类的属性进行赋值操作
//使用@ConfigurationProperties，必须导入依赖spring-boot-configuration-processor
public class Person {
	private String name;
	private int age;
}
