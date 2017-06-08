package com.student.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.student.model.Student;

public interface StudentMapper {
	
	public List<Student> searchStudents(Map<String,Object> map);
	
	public List<Student> searchStudents2(Map<String,Object> map);
	
	public List<Student> searchStudents3(Map<String,Object> map);
	
	public List<Student> searchStudents4(Map<String,Object> map);
	
	public List<Student> searchStudents5(Map<String,Object> map);
	
	public List<Student> searchStudents6(String name,Integer age);
	
	public int updateStudent(Student student);
	
	public int insertStudent(Student student);
	
	public Student getStudentById(int id);
	
	public List<Student> findStudents(RowBounds rowBounds);
	
	public List<Student> findStudents2(Map<String,Object> map);
	
}