package com.hellow.extend;

public class Student extends People implements C{

	@Override
	public void professer() {
		System.out.println("学生");
	}
	

	@Override
	public void a() {
		System.out.println("a方法");
		
	}
	
	@Override
	public void b() {
		// TODO Auto-generated method stub
		System.out.println("b方法");
	}



	@Override
	public void c() {
		// TODO Auto-generated method stub
		System.out.println("c方法");
	}
	
	public static void main(String[] args) {
		Student student = new Student();
		student.professer();
		System.out.println(A.TITLE);
		student.a();
	}
}
