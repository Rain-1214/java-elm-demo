package com.entity.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.People;

public class T {
	
	private ApplicationContext ac;

	@Before
	public void setUp() throws Exception {
		ac = new ClassPathXmlApplicationContext("beans.xml");
	}

	@Test
	public void test() {
		
		People people = (People) ac.getBean("people");
		System.out.println(people.getName());
	}
	
	@Test
	public void test2() {
		People people1 = (People) ac.getBean("people2");
		System.out.println(people1.getDog().getName());
	}
	
	@Test
	public void test3() {
		People people2 = (People) ac.getBean("people3");
		System.out.println(people2.getName());
		System.out.println(people2.getDog().getName());
	}
	
	@Test
	public void test4() {
		People people3 = (People) ac.getBean("people4");
		System.out.println(people3);

	}
	
	@Test
	public void test5() {
		People people3 = (People) ac.getBean("people5");
		System.out.println(people3);

	}
	
	@Test
	public void test6() {
		People people3 = (People) ac.getBean("people6");
		System.out.println(people3);

	}
	
	@Test
	public void test7() {
		People people3 = (People) ac.getBean("people7");
		System.out.println(people3);

	}

}
