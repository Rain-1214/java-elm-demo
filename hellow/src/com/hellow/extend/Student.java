package com.hellow.extend;

public class Student extends People implements C{

	@Override
	public void professer() {
		System.out.println("ѧ��");
	}
	

	@Override
	public void a() {
		System.out.println("a����");
		
	}
	
	@Override
	public void b() {
		// TODO Auto-generated method stub
		System.out.println("b����");
	}



	@Override
	public void c() {
		// TODO Auto-generated method stub
		System.out.println("c����");
	}
	
	public static void main(String[] args) {
		Student student = new Student();
		student.professer();
		System.out.println(A.TITLE);
		student.a();
	}
}
