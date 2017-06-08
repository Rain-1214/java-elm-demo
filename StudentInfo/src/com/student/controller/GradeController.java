package com.student.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.student.entity.Grade;
import com.student.entity.Student;
import com.student.service.GradeService;

@Controller
@RequestMapping("/grade")
public class GradeController {

	@Resource
	public GradeService gradeService;
	
	@RequestMapping(value = "/findGrade",method=RequestMethod.POST)
	@ResponseBody
	public Map findGrade(HttpServletRequest request){
		List<Grade> gradetList = gradeService.findGrade();
		Map<String,Object> map = new HashMap<String,Object>();
		if(gradetList != null){
			map.put("errorCode", 1);
			map.put("data", gradetList);
			map.put("message", "success");
		}else{
			map.put("errorCode", 0);
			map.put("message", "ÍøÂç´íÎó");
		}
		return map;
	}
	
}
