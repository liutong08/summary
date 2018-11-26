package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import de.codecentric.boot.admin.config.EnableAdminServer;



/**
 * properties解释
 * 
 * 将服务器端口号设置为8033
 * 访问localhost:8033就可以实现监控
 *
 */
@Configuration//配置类
@EnableAutoConfiguration//将符合条件的配置进行自动配置
@EnableAdminServer//开启监控
public class SpringBootSummary03Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSummary03Application.class, args);
	}
}
