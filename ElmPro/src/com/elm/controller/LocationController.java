package com.elm.controller;

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

import com.elm.entity.City;
import com.elm.service.LocationService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/location")
public class LocationController {
	
	@Resource
	public LocationService locationService; 
	
	@RequestMapping(value ="/getLocation",method = RequestMethod.POST)
	@ResponseBody
	public Map getLocation(@RequestBody Map obj,HttpServletRequest request) throws Exception{
		Double latitude = (Double) obj.get("latitude");
		Double longitude = (Double) obj.get("longitude");
		String resultJson =locationService.analysisLocation(latitude + "," + longitude);
		Map<String,Object> map = new HashMap<String,Object>();
		JSONObject jsonObject = JSONObject.fromObject(resultJson);
		if(jsonObject.getInt("status") != 0){
			map.put("stateCode", 1);
			map.put("message","Õ¯¬ÁŒ Ã‚");
		}else{
			map.put("stateCode", 0);
			map.put("data",resultJson);
			map.put("message","success");
		}
		return map;
	}
	
	@RequestMapping(value ="/getHotCity",method = RequestMethod.POST)
	@ResponseBody
	public Map getHotCity(HttpServletRequest request){
		
		List<String> list =locationService.findHotCity();
		Map<String,Object> map = new HashMap<String,Object>();
		if(list != null){
			map.put("stateCode", 0);
			map.put("data",list);
			map.put("message","success");
		}else{
			map.put("stateCode", 1);
			map.put("message","fail");
		}
		
		return map;
		
	}
	
	@RequestMapping(value ="/searchAddress",method = RequestMethod.POST)
	@ResponseBody
	public Map searchAddress(@RequestBody Map obj,HttpServletRequest request){
		String query = (String) obj.get("searchText");
		String city = (String) obj.get("currentLocation");
		System.out.println(obj);
		String location= "";
		if(obj.get("latitude") != null && obj.get("longitude") != null){
			Double latitude = (Double) obj.get("latitude");
			Double longitude = (Double) obj.get("longitude");
			location = latitude + "," + longitude;
		}
		String resultJson = locationService.findAddress(query, city, location);
		Map<String,Object> map = new HashMap<String,Object>();
		JSONObject jsonObject = JSONObject.fromObject(resultJson);
		map.put("data",resultJson);
		return map;
	}
	
}
