package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.javaWork;
import com.test.HelloWorld;

public class Test2 {
	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		javaWork javaWork = (javaWork) ac.getBean("javaWork");
		javaWork.doTest();
	}
}
