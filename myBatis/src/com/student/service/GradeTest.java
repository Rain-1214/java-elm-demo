package com.student.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.student.mappers.GradeMapper;
import com.student.mappers.StudentMapper;
import com.student.model.Grade;
import com.student.model.Student;
import com.student.util.SqlSessionFactoryUtil;

public class GradeTest {
	
	private static Logger logger =Logger.getLogger(StudentTest.class);
	
	private SqlSession sqlSession = null;
	
	private GradeMapper gradeMapper = null;

	@Before
	public void setUp() throws Exception {
		sqlSession = SqlSessionFactoryUtil.openSession();
		gradeMapper = sqlSession.getMapper(GradeMapper.class);
	}

	@After
	public void tearDown() throws Exception {
		sqlSession.close();
	}
	
	@Test
	public void testFind(){
		logger.info("�����꼶(��ѧ��)");
		Grade grade = gradeMapper.findById(1);
		System.out.println(grade);
	}
	
}
