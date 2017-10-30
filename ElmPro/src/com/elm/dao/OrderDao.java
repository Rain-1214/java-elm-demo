package com.elm.dao;

import java.util.List;

import com.elm.entity.Order;
import com.elm.entity.OrderProduct;
import com.elm.entity.ShopFillMinus;

public interface OrderDao {

	public List<ShopFillMinus> findShopFillMinusByshopId(Integer shopId);
	
	public Integer insertOrder(Order order);
	
	public Integer insertOrderProduct(OrderProduct orderProduct);
	
}
