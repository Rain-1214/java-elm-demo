package com.elm.dao;

import java.util.List;

import com.elm.entity.ShopFillMinus;

public interface OrderDao {

	public List<ShopFillMinus> findShopFillMinusByshopId(Integer shopId);
	
}
