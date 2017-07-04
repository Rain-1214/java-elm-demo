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

import com.elm.entity.FoodType;
import com.elm.entity.Shop;
import com.elm.entity.ShopType;
import com.elm.service.ShopService;
import com.elm.util.HttpRequest;

@Controller
@RequestMapping("/shop")
public class ShopController {
	
	public HttpRequest httpRequest;
	
	@Resource
	public ShopService shopService;
	
	@RequestMapping(value ="/shopTypeList",method = RequestMethod.POST)
	@ResponseBody
	public Map shopTypeList(HttpServletRequest request) throws Exception{
		List<ShopType> shopTypeList = shopService.findShopType();
		Map<String,Object> map = new HashMap<String,Object>();
		if(shopTypeList != null){
			map.put("stateCode", 0);
			map.put("data", shopTypeList);
			map.put("message","success");
		}else{
			map.put("stateCode", 1);
			map.put("message","网络问题");
		}
		return map;
	}
	
	@RequestMapping(value ="/shopList",method = RequestMethod.POST)
	@ResponseBody
	public Map shopList(HttpServletRequest request) throws Exception{
		List<Shop> shopList = shopService.findShopList();
		Map<String,Object> map = new HashMap<String,Object>();
		if(shopList != null){
			map.put("stateCode", 0);
			map.put("data", shopList);
			map.put("message","success");
		}else{
			map.put("stateCode", 1);
			map.put("message","网络问题");
		}
		return map;
	}
	
	@RequestMapping(value = "/shopFoodTypeList",method = RequestMethod.POST)
	@ResponseBody
	public Map shopFoodTypeList(@RequestBody Map obj,HttpServletRequest request) throws Exception{
		
		System.out.println(obj);
		Integer shopId = (Integer) obj.get("id");
		System.out.println(shopId);
		List<FoodType> foodTypeList = shopService.findFoodType(shopId);
		Map<String,Object> map = new HashMap<String,Object>();
		if(foodTypeList != null) {
			map.put("stateCode", 0);
			map.put("data", foodTypeList);
			map.put("message", "SUCCESS");
		}else {
			map.put("stateCode", 1);
			map.put("message", "网络问题");
		}
		return map;
	}
	
}
