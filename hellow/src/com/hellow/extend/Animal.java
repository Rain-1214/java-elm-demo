package com.hellow.extend;

public class Animal {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	Animal(){
		System.out.println("父类构造方法");
	}
	
	Animal(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	public void say(){
		System.out.println("动物姓名" + this.getName() + "年龄" + this.getAge());
	}
}
