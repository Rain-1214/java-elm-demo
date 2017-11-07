package com.elm.controller;

import java.util.Date;
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
import com.elm.websocket.Websocket;

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
		String sessionId = request.getSession().getId();
		Map<String, Object> resultMap = new HashMap<String,Object>();
		if (request.getSession().getAttribute(sessionId + "currentOrder") != null) {
			resultMap.put("stateCode", 0);
			resultMap.put("message", "您还有未支付订单，请先去支付或取消，再添加新订单");
			return resultMap;
		}
		List<Map> orderProductList = (List<Map>) obj.get("shoppingCartProducts");
		Integer shopId = (Integer) obj.get("shopId");
		Map map = orderService.creatOrder(orderProductList,shopId);
		if(map.get("message") != null) {
			resultMap.put("stateCode", 0);
			resultMap.put("message", map.get("message"));
			return resultMap;
		}
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
		Integer shopId = (Integer) obj.get("shopId");
		Integer userId = (Integer) obj.get("userId");
		Integer redPacketId = (Integer) obj.get("redPacketId");
		Boolean needInvoice = (Boolean) obj.get("needInvoice");
		Map<String,Object> address = (Map) obj.get("address");
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
				resultMap.put("stateCode", 0);
				resultMap.put("message", "订单出错请重试3");
				return resultMap;
			}
			tempPayPrice = tempPayPrice - hongbao.getMinusMoney() < 1 ? 1.00 : DecimalCompute.subtraction(tempPayPrice, hongbao.getMinusMoney());
			if (payPrice != tempPayPrice) {
				resultMap.put("stateCode", 0);
				resultMap.put("message", "订单出错请重试4");
				return resultMap;
			}
		}
		String userSex =(Integer) address.get("sex") == 1 ? "先生" : "女士";
		String userName = (String) address.get("userName") + userSex;
		String userAddressName = (String) address.get("addressName");
		String userAddressDetail = (String) address.get("addressDetail");
		String userPhoneNumber = (String) address.get("phoneNumber");
		
		Order order = new Order(shopId, userId, deliveryTime, selectDeliveryTime, creatTime, payMethod, deliveryMethod, remark, redPacketId, tempPayPrice, tempDiscounts, tempDeliveryCost, companyName, code, Order.NON_PAYMENT, userName, userAddressName, userAddressDetail, userPhoneNumber);
		
		Integer orderId = orderService.saveOrder(order, tempProductList, redPacketId);
		
		if (!orderId.equals(0)){
			resultMap.put("stateCode", 1);
			resultMap.put("message", "success");
			resultMap.put("payPrice",tempPayPrice);
			resultMap.put("orderId",orderId);
			request.getSession().removeAttribute(sessionId + "tempOrder");
			Map<String,Object> currentOrder = new HashMap<String,Object>();
			currentOrder.put("orderId", orderId);
			currentOrder.put("creatTime", new Date().getTime());
			request.getSession().setAttribute(sessionId + "currentOrder", currentOrder);
			return resultMap;
		}
		
		resultMap.put("stateCode", 0);
		resultMap.put("message", "未知错误");
		
		return resultMap;
	}
	
	
	@RequestMapping(value = "/getOrder",method = RequestMethod.POST)
	@ResponseBody
	public Map getOrder(@RequestBody Map obj,HttpServletRequest request){
		Integer userId = (Integer) obj.get("userId");
		Map<String,Object> result = new HashMap<String,Object>();
		List<Map> orderList = orderService.findOrderByUserId(userId);
		result.put("stateCode", 1);
		result.put("data", orderList);
		result.put("message", "success");
		return result;
	}
	
	@RequestMapping(value = "/getHongbao",method = RequestMethod.POST)
	@ResponseBody
	public Map getHongbao(@RequestBody Map obj,HttpServletRequest request){
		Integer hongbaoId = (Integer) obj.get("redPacketId");
		Map<String,Object> result = new HashMap<String,Object>();
		Hongbao hongbao = orderService.findHongbaoById(hongbaoId);
		result.put("stateCode", 1);
		result.put("data", hongbao);
		result.put("message", "success");
		return result;
	}
	
	
	@RequestMapping(value = "/orderCompleted",method = RequestMethod.POST)
	@ResponseBody
	public Map orderCompleted(@RequestBody Map obj,HttpServletRequest request){
		Integer orderId = (Integer) obj.get("orderId");
		Integer resultNum = orderService.updateOrderState(orderId, Order.ALREADY_COMPLETE);
		Map<String,Object> result = new HashMap<String,Object>();
		String sessionId = request.getSession().getId();
		if (resultNum.equals(1)){
			result.put("stateCode", 1);
			result.put("message", "success");
			request.getSession().removeAttribute(sessionId + "currentOrder");
			return result;
		}
		result.put("stateCode", 0);
		result.put("message", "未知错误");
		request.getSession().removeAttribute(sessionId + "currentOrder");
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
