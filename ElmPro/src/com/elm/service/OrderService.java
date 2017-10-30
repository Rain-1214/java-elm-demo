package com.elm.service;

import java.util.List;
import java.util.Map;

import com.elm.entity.Order;

public interface OrderService {

	public Map creatOrder(List<Map> orderProductList,Integer shopId);
	
	public Integer saveOrder(Order order,List<Map> orderProductList);
}
