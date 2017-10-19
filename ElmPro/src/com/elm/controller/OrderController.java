package com.elm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elm.service.OrderService;
import com.sun.javafx.collections.MappingChange.Map;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Resource
	public OrderService orderservice;

	@RequestMapping(value = "/createOrder",method = RequestMethod.POST)
	@ResponseBody
	public Map creatOrder(@RequestBody Map obj,HttpServletRequest request){
		
		return null;
	}
}
