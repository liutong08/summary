package com.example.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//在初始化和销毁时调用方法
public class LifeBean implements InitializingBean, DisposableBean {
	//在xml文件中调用这些方法，init-method在初始化时，destroy-method在销毁时
	
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("start lifebean");
	}

	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("stop lifebean");
	}

	//默认销毁时执行，不需要在xml文件中为destroy-method设定
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("destory lifebean");
	}
	///默认初始化时执行，不需要在xml文件中为init-method设定
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("init lifebean");
	}
}
