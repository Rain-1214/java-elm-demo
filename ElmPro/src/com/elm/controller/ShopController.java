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

import com.elm.entity.ShopType;
import com.elm.service.ShopService;

@Controller
@RequestMapping("/shop")
public class ShopController {
	
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
			map.put("message","��������");
		}
		return map;
	}
	
}
