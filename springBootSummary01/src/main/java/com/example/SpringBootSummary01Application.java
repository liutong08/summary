package com.example;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.ServletRequestHandledEvent;

@SpringBootApplication
@RestController // 只返回string字符串
public class SpringBootSummary01Application {

	public static void main(String[] args) {
//		SpringApplication app = new SpringApplication(SampleApplication.class);
		// 设置标识无效
//		app.setBannerMode(Mode.OFF);
//		app.run(args);
		System.out.println("before------");
		SpringApplication.run(SpringBootSummary01Application.class, args);
		System.out.println("after------");
	}
	
	//测试CommandLineRunner的顺序是：1、指定order的，2、未指定顺序的，3、静态方法
	@Bean // 静态方法
	public static CommandLineRunner testA() {
		CommandLineRunner runner = new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("i am testA");
			}
		};
		return runner;
	}

	@RequestMapping("/hello")
	public String hello() {
		return "hello world";
	}

//	@Bean	//commandLineRunner可加载多个数据，使用order指定顺序
//	public CommandLineRunner commandLineRunner(ApplicationContext ac) {
//		return args -> {
//			System.out.println("list bean:" + ac.getBeanDefinitionCount());
//			String[] names = ac.getBeanDefinitionNames();
//			Arrays.sort(names);
//			for (String string : names) {
//				System.out.println(string);
//			}
//		};
//	}

//	@Bean	//ApplicationRunner实现springboot应用启动后做一些初始化操作
//	public ApplicationRunner appRunner() {
//		return args -> {
//			System.out.println();
//			System.out.println("ApplicationRunner");
//			for (String opt : args.getOptionNames()) {
//				System.out.println(opt);
//				System.out.println("->");
//				System.out.println(args.getOptionValues(opt).stream().collect(Collectors.joining()));
//			}
//		};
//	}
//
//	@Bean//监听器，监听指定行为的动作，并做出反应
//	public ApplicationListener<ApplicationEvent> helloListener() {
//		final String HELLO_URL = "/he";
//
//		return (ApplicationEvent event) -> {
//			if (event instanceof ServletRequestHandledEvent) {
//				ServletRequestHandledEvent e = (ServletRequestHandledEvent) event;
//				if (e.getRequestUrl().equals(HELLO_URL))
//					System.out.println("visit hello");
//			}
//		};
//	}
}
