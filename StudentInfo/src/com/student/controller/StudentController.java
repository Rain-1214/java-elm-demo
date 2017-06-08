package com.student.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.student.entity.Grade;
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
	
	@RequestMapping(value = "/updateStudent",method=RequestMethod.POST)
	@ResponseBody
	public Map updateStudent(@RequestBody Student student,HttpServletRequest request){
		int result = studentService.updateStudent(student);
		Map<String,Object> map = new HashMap<String,Object>();
		if(result == 1){
			map.put("errorCode", 1);
			map.put("message", "success");
			map.put("data", student);
		}else{
			map.put("errorCode", 0);
			map.put("message", "�������");
		}
		return map;
	}
	
	@RequestMapping(value = "/deleteStudent",method=RequestMethod.POST)
	@ResponseBody
	public Map deleteStudent(@RequestBody Map obj,HttpServletRequest request){
		System.out.println(obj);
		ArrayList<Integer> idList = (ArrayList<Integer>) obj.get("ids");
		System.out.println(idList);
		Map<String,Object> ids = new HashMap<String,Object>();
		ids.put("ids", idList);
		int result = studentService.deleteStudent(ids);
		Map<String,Object> map = new HashMap<String,Object>();
		if(result == 1){
			map.put("errorCode", 1);
			map.put("message", "success");
		}else{
			map.put("errorCode", 0);
			map.put("message", "�������");
		}
		return map;
	}
	
	@RequestMapping(value = "/addStudents",method=RequestMethod.POST)
	@ResponseBody
	public Map addStudents(@RequestBody Map obj,HttpServletRequest request){
		System.out.println(obj);
		List<Map> studentMapList = (ArrayList<Map>) obj.get("students");
		System.out.println(studentMapList);
		List<Student> studentList = new ArrayList<Student>();
		for(Map s:studentMapList){
			String name = (String) s.get("name");
			Integer age = (Integer) s.get("age");
			Map grade = (Map) s.get("grade");
			Integer id = (Integer) grade.get("id");
			String gradeName = (String) grade.get("gradeName");
			studentList.add(new Student(name,age,new Grade(id,gradeName)));
		}
		int result = studentService.insertStudent(studentList);
		Map<String,Object> map = new HashMap<String,Object>();
		if(result == studentList.size()){
			map.put("errorCode", 1);
			map.put("message", "success");
		}else{
			map.put("errorCode", 0);
			map.put("message", "�������");
		}
		return map;
	}
	
}