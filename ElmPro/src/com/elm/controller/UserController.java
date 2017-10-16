package com.elm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elm.entity.Address;
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
			if(user == null){
				map.put("stateCode", 0);
				map.put("message", "�û������������");
			}else{
				Map userMap = new HashMap<String,Object>();
				userMap.put("userName", user.getUserName());
				userMap.put("userImg", user.getUserImg());
				userMap.put("phoneNumber", user.getPhoneNumber());
				userMap.put("activityPoints",user.getActivityPoints());
				userMap.put("address", user.getAddress());
				userMap.put("hongbao", user.getHongBao());
				userMap.put("id", user.getId());
				map.put("stateCode",1);
				map.put("data", userMap);
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
				userMap.put("id", userRegistered.getId());
				map.put("stateCode", 1);
				map.put("data", userMap);
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
	
	@RequestMapping(value="/addAddress", method = RequestMethod.POST)
	@ResponseBody
	public Map addAddress(@RequestBody Map obj){
		Integer sex = (Integer) obj.get("sex");
		String userName = (String) obj.get("userName");
		String phoneNumber = (String) obj.get("phoneNumber");
		String addressName = (String) obj.get("addressName");
		String addressDetail = (String) obj.get("addressDetail");
		Integer userId = (Integer) obj.get("userId");
		double lat = (double) obj.get("lat");
		double lng = (double) obj.get("lng");
		String tag = "";
		if (!(obj.get("tag") == "")){
			tag = (String) obj.get("tag");
		}
		Address userAddress = new Address(userName, sex, phoneNumber, addressName, addressDetail, tag, lat, lng, userId);
		Integer resultNum = userService.insertUserAddress(userAddress);
		Map resultMap = new HashMap<String,Object>();
		if(resultNum == 1) {
			resultMap.put("stateCode", 1);
			resultMap.put("message", "��ӳɹ�");
		}else{
			resultMap.put("stateCode", 0);
			resultMap.put("message", "���ʧ��,������");
		}
		
		return resultMap;
	}
	
	@RequestMapping(value = "/findAddressByUserId", method = RequestMethod.POST)
	@ResponseBody
	public Map findAddressByUserId(@RequestBody Map obj){
		Integer userId = (Integer) obj.get("userId");
		List<Address> addressList = userService.findAddressByUserId(userId);
		Map resultMap = new HashMap<String,Object>();
		resultMap.put("stateCode", 1);
		resultMap.put("data", addressList);
		resultMap.put("message", "success");
		return resultMap;
	}
	
	@RequestMapping(value = "/deleteAddressById", method = RequestMethod.POST)
	@ResponseBody
	public Map deleteAddressById(@RequestBody Map obj){
		Integer id = (Integer) obj.get("addressId");
		Integer resultNum = userService.deleteAddressById(id);
		Map resultMap = new HashMap<String,Object>();
		if(resultNum == 1) {
			resultMap.put("stateCode", 1);
			resultMap.put("message", "ɾ���ɹ�");
		}else{
			resultMap.put("stateCode", 0);
			resultMap.put("message", "ɾ��ʧ��");
		}
		return resultMap;
	}
	
	@RequestMapping(value = "/editAddressById", method = RequestMethod.POST)
	@ResponseBody
	public Map editAddressById(@RequestBody Map obj){
		Integer id = (Integer) obj.get("id");
		Integer sex = (Integer) obj.get("sex");
		String userName = (String) obj.get("userName");
		String phoneNumber = (String) obj.get("phoneNumber");
		String addressName = (String) obj.get("addressName");
		String addressDetail = (String) obj.get("addressDetail");
		Integer userId = (Integer) obj.get("userId");
		double lat = (double) obj.get("lat");
		double lng = (double) obj.get("lng");
		String tag = "";
		if (!(obj.get("tag") == "")){
			tag = (String) obj.get("tag");
		}
		Address userAddress = new Address(id, userName, sex, phoneNumber, addressName, addressDetail, tag, lat, lng, userId);
		Integer resultNum = userService.editAddressById(userAddress);
		Map resultMap = new HashMap<String,Object>();
		if(resultNum == 1) {
			resultMap.put("stateCode", 1);
			resultMap.put("message", "�޸ĳɹ�");
		}else{
			resultMap.put("stateCode", 0);
			resultMap.put("message", "�޸�ʧ��");
		}
		return resultMap;
	}
	
	@RequestMapping(value = "/getUserSafetyQuestion", method = RequestMethod.POST)
	@ResponseBody
	public Map getUserSafetyQuestion(@RequestBody Map obj,HttpServletRequest request){
		String userName = (String) obj.get("userName");
		User user = userService.findUserByName(userName);
		Map result = new HashMap<String,Object>();
		if(user == null){
			result.put("stateCode", 0);
			result.put("message", "�û���������");
		}else{
			String sessionId = request.getSession().getId();
			request.getSession().setAttribute(sessionId + "safetyAnswer", user.getSafetyAnswer());
			String safetyQuestion = user.getSafetyQuestion();
			Integer id = user.getId();
			Map data = new HashMap<String,Object>();
			data.put("id", id);
			data.put("safetyQuestion", safetyQuestion);
			result.put("stateCode",1);
			result.put("message", "success");
			result.put("data", data);
		}
		return result;
	}
	
	@RequestMapping(value = "/checkUserSafetyQuestion", method = RequestMethod.POST)
	@ResponseBody
	public Map checkUserSafetyQuestion(@RequestBody Map obj,HttpServletRequest request){
		String safetyAnswer = (String) obj.get("safetyAnswer");
		String sessionId = request.getSession().getId();
		String trueSafetyAnser = (String) request.getSession().getAttribute(sessionId + "safetyAnswer");
		Map result = new HashMap<String,Object>();
		if (safetyAnswer.equals(trueSafetyAnser)){
			result.put("stateCode", 1);
			result.put("message", "success");
		}else{
			result.put("stateCode", 0);
			result.put("message", "������Ĵ𰸲���ȷ");
		}
		return result;
	}
	
	@RequestMapping(value = "/setNewPassword", method = RequestMethod.POST)
	@ResponseBody
	public Map setNewPassword(@RequestBody Map obj){
		String password = (String) obj.get("password");
		Integer id = (Integer) obj.get("id");
		Integer result = userService.setNewPassword(id, password);	
		Map resultMap = new HashMap<String,Object>();
		if(result == 1) {
			resultMap.put("stateCode", 1);
			resultMap.put("message", "success");
		}else{
			resultMap.put("stateCode", 0);
			resultMap.put("message", "�޸�ʧ�ܣ�������");
		}
		return resultMap;
	}
	
	
	
	
	
	
	
	
	
}
