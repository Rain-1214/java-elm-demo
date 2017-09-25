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
			map.put("message", "��֤�����");
			return map;
		}else{
			User user = userService.findUserByNameAndPass(userName, password);
			user.setPassword(null);
			if(user.equals(null)){
				map.put("stateCode", 0);
				map.put("message", "�û������������");
			}else{
				map.put("stateCode",1);
				map.put("data", user);
				map.put("message", "��¼�ɹ�");
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
			map.put("message", "�û�������");
		}else{
			map.put("stateCode", 0);
			map.put("message","�û����Ѵ���");
		}
		return map;
	}
	
	@RequestMapping(value = "/getCode",method = RequestMethod.GET)
	@ResponseBody
	public Map getCode(HttpServletRequest request,HttpServletResponse response){
		Map map = new HashMap<Object,String>();
		response.setContentType("image/jpeg");//������Ӧ���ͣ���֪������������ͼƬ  
        response.setHeader("Pragma", "No-cache");//������Ӧͷ��Ϣ�������������Ҫ���������  
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
				userRegistered.setPassword(null);
				map.put("stateCode", 1);
				map.put("data", userRegistered);
				map.put("message", "ע��ɹ�");
			}else{
				map.put("stateCode", 0);
				map.put("message", "��·����������");
			}
		}else{
			map.put("stateCode", 0);
			map.put("message", "��֤�벻��ȷ");
		}
		
		return map;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
