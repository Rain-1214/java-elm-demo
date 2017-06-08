package com.student.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.student.dao.GradeDao;
import com.student.entity.Grade;
import com.student.service.GradeService;

@Service("gradeService")
public class GradeServiceImpl implements GradeService{

	@Resource
	public GradeDao gradeDao;

	@Override
	public List<Grade> findGrade() {
		return gradeDao.findGrade();
	}
	
	
	
}
