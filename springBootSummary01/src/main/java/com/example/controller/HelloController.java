package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Person;
import com.example.entity.Student;
import com.example.entity.User;

@RestController//返回值只是string类型，不会返回到jsp中
public class HelloController {

	@Autowired//注入实体类
	private Student student;
	@Autowired
	private User user;
	@Autowired
	private Person per;
	
	@RequestMapping("/he")
	public String he() {
		return "hehhehehehhehe";
	}
	
	@RequestMapping("/stu")
	public String stu() {
		return student.toString(); 
	}
	

	@RequestMapping("/us")
	public String us() {
		return user.toString(); 
	}
	
	@RequestMapping("/per")
	public String per() {
		return per.toString(); 
	}
}
