package com.hellow.extend;

public class Cat extends Animal{
	
	private String address;
	
	
	
//	public Cat() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//
//	public Cat(String name, int age) {
//		super(name, age);
//		// TODO Auto-generated constructor stub
//	}


	public Cat(String address) {
		super();
		this.address = address;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	public void say(){
		System.out.println("����" + this.getName() + "����" + this.getAge() + "��ַ" + this.getAddress());
	}

	public static void main(String[] args) {
		Cat cat = new Cat("111");
		cat.setAge(10);
		cat.setName("è");
		cat.say();
	}
}
