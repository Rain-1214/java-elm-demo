package com.student.dao;

import java.util.List;

import com.student.entity.Grade;

public interface GradeDao {

	public Grade findById(int id);
	
	public List<Grade> findGrade();
	
}
