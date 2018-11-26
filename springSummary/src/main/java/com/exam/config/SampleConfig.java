package com.exam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.beans.ABean;
import com.example.beans.AllBean;
import com.example.beans.BBean;
//容器配置的第三种：Java
//@Configuration指定该类为配置类，与xml文件的功能相同
@Configuration
//@Primary//若发生重复，则调用primary指定的属性或bean
//@ComponentScan(basePackages="com.example")//指定该类扫描com.example包下的所有文件
public class SampleConfig {
	@Bean//相当于xml文件中的<bean></bean>
//	@Primary
	public AllBean all() {
		AllBean allBean = new AllBean();
		allBean.setAbean(aa());//通过引用将ABean注入到Allbean的属性中
		allBean.setBbean(bb());//通过引用将BBean注入到Allbean的属性中
		allBean.setI(6876);
		return allBean;
	}

	@Bean
//	@Primary
	public ABean aa() {
		// TODO Auto-generated method stub
		ABean ab = new ABean();
		ab.setName("i am aaa");
		return ab;
	}

	@Bean
//	@Primary
	public BBean bb() { //方法名就是bean的id
		// TODO Auto-generated method stub
		BBean bb = new BBean();
		bb.setName("i am bbb");
		return bb;
	}
}
