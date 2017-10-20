package com.elm.service;

import java.util.List;
import java.util.Map;

import com.elm.entity.OrderProduct;

public interface OrderService {

	public Map creatOrder(List<Map> orderProductList,Integer shopId);
	
}
