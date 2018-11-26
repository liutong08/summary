package com.example.beans;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component//注入bean
public class AllBean {

	// inject和autowired在现阶段上功能基本一样
//	@Inject
	@Autowired
//	@Qualifier("ab") // @Qualifier("名")该名为实体类的@Component("名")，也就类似于xml中bean的id
//	@Resource(name="ab")// @Resource(name="名")该名为实体类的@Component("名")，也就类似于xml中bean的id,可单独使用
	private ABean abean;

	@Autowired
//	@Qualifier("bb")
	// qualifier必须和autowired或者inject配合使用
//	@Resource(name="bb")
	// resource单独使用
//	@Inject
	private BBean bbean;
	@Value("123")
	private int i;

	public ABean getAbean() {
		return abean;
	}

	public void setAbean(ABean abean) {
		this.abean = abean;
	}

	public BBean getBbean() {
		return bbean;
	}

	public void setBbean(BBean bbean) {
		this.bbean = bbean;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public AllBean(ABean abean, BBean bbean, int i) {
		super();
		this.abean = abean;
		this.bbean = bbean;
		this.i = i;
	}

	public AllBean() {
		super();
	}

	@Override
	public String toString() {
		return "AllBean [abean=" + abean + ", bbean=" + bbean + ", i=" + i + "]";
	}

}
