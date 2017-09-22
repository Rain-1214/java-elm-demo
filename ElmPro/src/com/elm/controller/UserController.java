package com.elm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elm.entity.User;
import com.elm.service.UserService;
import com.elm.util.RandomValidateCode;

@Controller
@RequestMapping("/User")
public class UserController {
	
	@Resource
	public UserService userService;
	
	
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	@ResponseBody
	public Map userLogin(@RequestBody Map obj,HttpServletRequest httpRequest) {
		Map map = new HashMap<Object,String>();
		String userName = (String) obj.get("userName");
		String password = (String) obj.get("password");
		System.out.println(userName);
		System.out.println(password);
		User user = userService.findUserByName(userName, password);
		map.put("data", user);
		return map;
	}
	
	@RequestMapping(value = "/getCode",method = RequestMethod.GET)
	@ResponseBody
	public Map getCode(HttpServletRequest request,HttpServletResponse response){
		Map map = new HashMap<Object,String>();
		response.setContentType("image/jpeg");//设置响应类型，告知浏览器输出的是图片  
        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容  
        response.setHeader("Cache-Control", "no-cache");  
        response.setHeader("Set-Cookie", "name=value; HttpOnly");//设置HttpOnly属性,防止Xss攻击  
        response.setDateHeader("Expire", 0);  
		RandomValidateCode randomValidateCode = new RandomValidateCode();
		
		try {
			randomValidateCode.getRandomCode(request, response, "imageCode");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return map;
		
	}
	
}
