package com.student.service;

import java.util.List;

import com.student.model.Student;

public interface StudentService {
	public int addStudent(Student student);
	
	public int deleteStudent(int id);
	
	public int updateStudent(Student student);
	
	public List<Student> findStudents();
}
