package com.student.entity;

public class Student {
	
	private Integer id;
	private String name;
	private Integer age;
	private Grade grade;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, Integer age, Grade grade) {
		super();
		this.name = name;
		this.age = age;
		this.grade = grade;
	}
	
	
	
	
	
}