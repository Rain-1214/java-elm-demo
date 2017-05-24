package com.test;

import com.service.Tester;

public class HelloWorld {
	
	private Tester tester;

	public void setTester(Tester tester) {
		this.tester = tester;
	}
	
	public void doTest(){
		tester.test();
	}
	
}
