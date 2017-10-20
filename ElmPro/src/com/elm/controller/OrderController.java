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

import com.elm.entity.OrderProduct;
import com.elm.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Resource
	public OrderService orderService;

	@RequestMapping(value = "/createOrder",method = RequestMethod.POST)
	@ResponseBody
	public Map creatOrder(@RequestBody Map obj,HttpServletRequest request){
		List<Map> orderProductList = (List<Map>) obj.get("shoppingCartProducts");
		Integer shopId = (Integer) obj.get("shopId");
		Map map = orderService.creatOrder(orderProductList,shopId);
		Map<String, Object> resultMap = new HashMap<String,Object>();
		if(map.get("message") != null) {
			resultMap.put("stateCode", 0);
			resultMap.put("message", map.get("message"));
			return resultMap;
		}
		String sessionId = request.getSession().getId();
		request.getSession().setAttribute(sessionId + "tempOrder", map);
		resultMap.put("stateCode", 1);
		resultMap.put("message", "success");
		return resultMap;
	}
}
