package com.example;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.Student;

/* properties解释
 * 
 * 设置访问服务器的地址和端口号
 * spring.boot.admin.url=http://localhost:8033
 * 将安全关闭，用于访问
 * management.security.enabled=false
 * 
 * spring设置监听，使用8088端口号进行访问，地址为localhost:8088/aaa/info..
 * management.port=8088
 * management.context-path=/aaa
 * 
 * 结束端点，强制结束
 * endpoints.actuator.enabled=true
 * endpoints.shutdown.enabled=true
 */

@SpringBootApplication
@RestController
public class SpringBootSummary02Application {

	// 获取slf4j
	private static Logger logger = LoggerFactory.getLogger(SpringBootSummary02Application.class);

	@PostConstruct // 在初始化时执行，只执行一次
	public void logSomething() {
		// 根据指定的显示级别，打印信息
		logger.debug("debug");
		logger.info("info");
		logger.warn("warn");
		logger.error("error");
		logger.trace("trace");
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSummary02Application.class, args);
	}

	@Bean // 健康检查
	public HealthIndicator myHealth() {
		return () -> {// 若产生404错误，则健康检查为down的状态
			return Health.down().withDetail("error", 404).build();
		};
	}
}
