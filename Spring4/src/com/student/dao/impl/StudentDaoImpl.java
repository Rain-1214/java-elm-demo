package com.student.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.student.dao.StudentDao;
import com.student.model.Student;

public class StudentDaoImpl implements StudentDao{
	
//	 extends JdbcDaoSupport
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public int addStudent(Student student) {
		String sql = "insert into student values(null,:name,:age)";
		MapSqlParameterSource msps = new MapSqlParameterSource();
		msps.addValue("name", student.getName());
		msps.addValue("age", student.getAge());
		return namedParameterJdbcTemplate.update(sql, msps);
	}

	@Override
	public int deleteStudent(int id) {
		String sql = "delete from student where id = :id";
		MapSqlParameterSource msps = new MapSqlParameterSource();
		msps.addValue("id", id);
		return namedParameterJdbcTemplate.update(sql, msps);
	}

	@Override
	public int updateStudent(Student student) {
		String sql = "update student set name=:name,age=:age where id = :id";
		MapSqlParameterSource msps = new MapSqlParameterSource();
		msps.addValue("name", student.getName());
		msps.addValue("age", student.getAge());
		msps.addValue("id", student.getId());
		return namedParameterJdbcTemplate.update(sql,msps);
	}

	@Override
	public List<Student> findStudents() {
		String sql = "select * from student";
		List<Student> studentList = new ArrayList<Student>();
		
		namedParameterJdbcTemplate.query(sql,new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet arg0) throws SQLException {
				Student student = new Student();
				student.setId(arg0.getInt("id"));
				student.setAge(arg0.getInt("age"));
				student.setName(arg0.getString("name"));
				studentList.add(student);
			}
		});
		
		return studentList;
	}

}
