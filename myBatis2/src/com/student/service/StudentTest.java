package com.student.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.student.mappers.StudentMapper;
import com.student.model.Student;
import com.student.util.SqlSessionFactoryUtil;

public class StudentTest {
	
	private static Logger logger =Logger.getLogger(StudentTest.class);
	
	private SqlSession sqlSession = null;
	
	private StudentMapper studentMapper = null;

	@Before
	public void setUp() throws Exception {
		sqlSession = SqlSessionFactoryUtil.openSession();
		studentMapper = sqlSession.getMapper(StudentMapper.class);
	}

	@After
	public void tearDown() throws Exception {
		sqlSession.close();
	}
	
	@Test
	public void testInsert(){
		logger.info("添加学生");
		Student student = new Student();
		student.setName("张三n");
		student.setAge(20);
		student.setRemark("很长的文本。。。。。。");
		byte[] pic = null;
		try {
			File file = new File("d://boy.png");
			InputStream inputStream = new FileInputStream(file);
			pic = new byte[inputStream.available()];
			inputStream.read(pic);
			inputStream.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		student.setPic(pic);
		int result = studentMapper.insertStudent(student); 
		sqlSession.commit();
		System.out.println(result);
		
	}
	
	@Test
	public void testGetStudentById(){
		logger.info("通过ID查找学生");
		Student student = studentMapper.getStudentById(9);
		byte[] pic = student.getPic();
		try {
			File file = new File("h://a.png");
			OutputStream outputStream = new FileOutputStream(file);
			outputStream.write(pic);
			outputStream.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
}
