package com.hellow.obj;


public class Throws {
	
	public static void test() throws Exception{
		String a = "123a";
		int b = Integer.parseInt(a);
		System.out.println(b);
	}
	
	public static void main(String[] args) {
		try {
			test();
		} catch (Exception e) {
			System.out.println("我们在这里处理异常");
			e.printStackTrace();
		}
		System.out.println("aa");
	}
	
}
