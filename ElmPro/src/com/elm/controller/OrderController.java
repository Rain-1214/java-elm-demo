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

import com.elm.entity.Hongbao;
import com.elm.entity.Order;
import com.elm.service.OrderService;
import com.elm.service.UserService;
import com.elm.util.DecimalCompute;
import com.elm.util.MapEquals;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Resource
	public OrderService orderService;
	
	@Resource
	public UserService userService;
	
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
	
	@RequestMapping(value = "/checkOrder",method = RequestMethod.POST)
	@ResponseBody
	public Map checkOrder(@RequestBody Map obj,HttpServletRequest request){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		String selectDeliveryTime = (String) obj.get("pickerValue");
		String deliveryMethod = (String) obj.get("deliveryMethod");
		String payMethod = (String) obj.get("payMethod");
		String creatTime = (String) obj.get("time");
		String remark = (String) obj.get("remarkString");
		Integer deliveryTime = (Integer) obj.get("deliveryTime");
		Integer addressId = (Integer) ((Map<String,Object>) obj.get("address")).get("id");
		Integer shopId = (Integer) obj.get("shopId");
		Integer userId = (Integer) obj.get("userId");
		Integer redPacketId = (Integer) obj.get("redPacketId");
		Boolean needInvoice = (Boolean) obj.get("needInvoice");
		String companyName = null;
		String code = null;
		double payPrice;
		if(obj.get("payPrice") instanceof Double) {
			payPrice = (double) obj.get("payPrice");
		} else {
			payPrice = (Integer) obj.get("payPrice");
		}
		
		if (needInvoice) {
			companyName = (String) obj.get("companyName");
			code = (String) obj.get("code");
		}
		
		String sessionId = request.getSession().getId();
		HashMap<String,Object> tempOrder = (HashMap<String, Object>) request.getSession().getAttribute(sessionId + "tempOrder");
		List<Map> tempProductList = (List<Map>) tempOrder.get("orderProductList");
		
		double totalPrice = (double) tempOrder.get("totalPrice");
		double tempDiscounts = (double) tempOrder.get("discounts");
		double tempDeliveryCost = (double) tempOrder.get("deliveryCost");
		
		double tempPayPrice = DecimalCompute.add(DecimalCompute.subtraction(totalPrice, tempDiscounts),tempDeliveryCost);
		
		if (redPacketId != -1) {
			Hongbao hongbao = userService.findHongbaoById(redPacketId);
			if (hongbao.getHongbaoState() != hongbao.CAN_USE){
				resultMap.put("stateCode", "0");
				resultMap.put("message", "∂©µ•≥ˆ¥Ì«Î÷ÿ ‘3");
				return resultMap;
			}
			tempPayPrice = tempPayPrice - hongbao.getMinusMoney() < 1 ? 1.00:DecimalCompute.subtraction(tempPayPrice, hongbao.getMinusMoney());
			if (payPrice != tempPayPrice) {
				resultMap.put("stateCode", "0");
				resultMap.put("message", "∂©µ•≥ˆ¥Ì«Î÷ÿ ‘4");
				return resultMap;
			}
		}

		Order order = new Order(shopId, userId, addressId, deliveryTime, selectDeliveryTime, creatTime, payMethod, deliveryMethod, remark, redPacketId, tempPayPrice, companyName, code, Order.NON_PAYMENT);
		
		Boolean orderResult = orderService.saveOrder(order, tempProductList, redPacketId);
		
		if (orderResult){
			resultMap.put("stateCode", "1");
			resultMap.put("message", "success");
			return resultMap;
		}
		
		resultMap.put("stateCode", "0");
		resultMap.put("message", "Œ¥÷™¥ÌŒÛ");
		
		return resultMap;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
