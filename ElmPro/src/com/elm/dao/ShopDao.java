package com.elm.dao;

import java.util.List;

import com.elm.entity.Food;
import com.elm.entity.FoodType;
import com.elm.entity.Shop;
import com.elm.entity.ShopProperty;
import com.elm.entity.ShopType;

public interface ShopDao {
	
	public List<ShopType> findShopType();
	
	public List<Shop> findShopList();
	
	public ShopProperty findShopPropery();
	
	public List<FoodType> findFoodType(Integer shopId);
	
	
	
}