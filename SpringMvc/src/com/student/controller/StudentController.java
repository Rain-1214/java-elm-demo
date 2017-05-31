package com.student.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.User;

@Controller
@RequestMapping("/user")
public class StudentController {
	
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	@ResponseBody 
	public User login(@RequestBody User user){
		System.out.println("µÇÂ¼ÑéÖ¤");
		
		String userName = user.getUserName();
		String passWord = user.getPassWord();
		System.out.println(userName + passWord);
		User user2 = new User(userName,passWord);
		return user2;
		
	}
	
}
