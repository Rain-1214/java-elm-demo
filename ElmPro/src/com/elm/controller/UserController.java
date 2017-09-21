package com.elm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elm.service.UserService;
import com.elm.util.HttpRequest;

@Controller
@RequestMapping("/User")
public class UserController {
	
	public HttpRequest httpRequest;
	
	@Resource
	public UserService userService;
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	@ResponseBody
	public Map userLogin(Map obj,HttpRequest httpRequest) {
		Map map = new HashMap<Object,String>();
		return map;
	}
	
}
