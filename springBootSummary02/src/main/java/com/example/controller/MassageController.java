package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.Student;
import com.example.service.MessageService;

@RestController
public class MassageController {

	private static Logger logger = LoggerFactory.getLogger(MassageController.class);
	@Autowired // 注入接口，但会根据条件注入其的实现类
	private MessageService messageService;
	@Autowired
	private Student stu;

	@RequestMapping("/mes")
	public String message() {
		return messageService.getMessage();
	}

	@RequestMapping("/stu")
	public String student() {
		logger.debug(stu.toString() + "debug");
		logger.info(stu.toString() + "info");
		logger.warn(stu.toString() + "warn");
		logger.error(stu.toString() + "error");
		logger.trace(stu.toString() + "trace");
		return "hello";
	}

}
