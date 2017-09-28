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
	public Map userLogin(@RequestBody Map obj,HttpServletRequest httpRequest,HttpServletResponse httpResponse) {
		Map map = new HashMap<Object,String>();
		String userName = (String) obj.get("userName");
		String password = (String) obj.get("password");
		String code = (String) obj.get("code");
		code = code.toUpperCase();
		String sessionId = httpRequest.getSession().getId();
		String imgCode = (String) httpRequest.getSession().getAttribute(sessionId+"imageCode");
		if(!code.equals(imgCode)){
			map.put("stateCode",0);
			map.put("message", "验证码错误");
			return map;
		}else{
			User user = userService.findUserByNameAndPass(userName, password);
			if(user == null){
				map.put("stateCode", 0);
				map.put("message", "用户名或密码错误");
			}else{
				Map userMap = new HashMap<String,Object>();
				userMap.put("userName", user.getUserName());
				userMap.put("userImg", user.getUserImg());
				userMap.put("phoneNumber", user.getPhoneNumber());
				userMap.put("activityPoints",user.getActivityPoints());
				userMap.put("address", user.getAddress());
				userMap.put("hongbao", user.getHongBao());
				map.put("stateCode",1);
				map.put("data", userMap);
				map.put("message", "登录成功");
			}
			return map;
		}
		
	}
	
	@RequestMapping(value = "/checkUserName",method = RequestMethod.POST)
	@ResponseBody
	public Map checkUserName(@RequestBody Map obj,HttpServletRequest httpRequest){
		Map map = new HashMap<String,Object>();
		String userName = (String) obj.get("userName");
		User user = userService.findUserByName(userName);
		if(user == null){
			map.put("stateCode", 1);
			map.put("message", "用户名可用");
		}else{
			map.put("stateCode", 0);
			map.put("message","用户名已存在");
		}
		return map;
	}
	
	@RequestMapping(value = "/getCode",method = RequestMethod.GET)
	@ResponseBody
	public Map getCode(HttpServletRequest request,HttpServletResponse response){
		Map map = new HashMap<Object,String>();
		response.setContentType("image/jpeg");//设置响应类型，告知浏览器输出的是图片  
        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容  
        response.setHeader("Cache-Control", "no-cache");  
        response.setHeader("Set-Cookie", "name=value; HttpOnly");
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
	
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	@ResponseBody
	public Map register(@RequestBody Map obj,HttpServletRequest request){
		String userName = (String) obj.get("userName");
		String password = (String) obj.get("password");
		String safetyQuestion = (String) obj.get("safetyQuestion");
		String safetyAnswer = (String) obj.get("safetyAnswer");
		String code= (String) obj.get("code");
		code = code.toUpperCase();
		String sessionId = request.getSession().getId();
		String imgcode = (String) request.getSession().getAttribute(sessionId + "imageCode");
		
		System.out.println(code);
		System.out.println(imgcode);
		Map map = new HashMap<String,Object>();
		
		if(imgcode.equals(code)){
			User user = new User(userName, password, safetyQuestion, safetyAnswer);
			Integer resultNum = userService.insertUser(user);
			if(resultNum == 1){
				User userRegistered = userService.findUserByName(userName);
				Map userMap = new HashMap<String,Object>();
				userMap.put("userName", userRegistered.getUserName());
				userMap.put("userImg", userRegistered.getUserImg());
				userMap.put("phoneNumber", userRegistered.getPhoneNumber());
				userMap.put("activityPoints",userRegistered.getActivityPoints());
				userMap.put("address", userRegistered.getAddress());
				userMap.put("hongbao", userRegistered.getHongBao());
				map.put("stateCode", 1);
				map.put("data", userMap);
				map.put("message", "注册成功");
			}else{
				map.put("stateCode", 0);
				map.put("message", "网路错误，请重试");
			}
		}else{
			map.put("stateCode", 0);
			map.put("message", "验证码不正确");
		}
		
		return map;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
