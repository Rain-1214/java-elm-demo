package com.student.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.student.entity.Student;
import com.student.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Resource
	public StudentService studentService;
	
	@RequestMapping(value = "/findStudent",method=RequestMethod.POST)
	@ResponseBody
	public Map findStudent(HttpServletRequest request){
		List<Student> studentList = studentService.findStudnet();
		Map<String,Object> map = new HashMap<String,Object>();
		if(studentList != null){
			map.put("errorCode", 1);
			map.put("data", studentList);
			map.put("message", "success");
		}else{
			map.put("errorCode", 0);
			map.put("message", "�������");
		}
		return map;
	}
	
}
