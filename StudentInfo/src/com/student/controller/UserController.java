package com.student.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.student.entity.User;
import com.student.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	@ResponseBody
	public Map login(@RequestBody User user,HttpServletRequest request){
		System.out.println(user);
		User resultUser = userService.login(user);
		if(resultUser == null){
			Map params =  new HashMap();
			params.put("errorCode", 0);
			params.put("message", "用户名密码错误");
			return params;
		}else{
			Map params =  new HashMap();
			params.put("errorCode", 1);
			params.put("message", "用户名密码正确");
			return params;
		}
	}
	
	@RequestMapping(value = "/register",method=RequestMethod.POST)
	@ResponseBody
	public Map register(@RequestBody User user,HttpServletRequest request){
		System.out.println(user);
		int result = userService.insertUser(user);
		if(result == 0){
			Map params =  new HashMap();
			params.put("errorCode", 0);
			params.put("message", "注册失败");
			return params;
		}else{
			Map params =  new HashMap();
			params.put("errorCode", 1);
			params.put("message", "注册成功");
			return params;
		}
	}
	
	
}
