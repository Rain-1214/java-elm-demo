package com.elm.dao;

import java.util.List;

import com.elm.entity.Food;
import com.elm.entity.FoodProperty;
import com.elm.entity.FoodPropertyDetail;
import com.elm.entity.FoodType;
import com.elm.entity.Shop;
import com.elm.entity.ShopProperty;
import com.elm.entity.ShopType;

public interface ShopDao {
	
	public List<ShopType> findShopType();
	
	public String findShopTypeNameById(Integer id);
	
	public List<Shop> findShopList();
	
	public Shop findShopById(Integer id);
	
	public ShopProperty findShopProperty();
	
	public String findShopPropertyType(Integer shopId);
	
	public Food findFoodByfoodTypeId(Integer id);
	
	public Food findFoodById(Integer id);
	
	public List<FoodType> findFoodType(Integer shopId);
	
	public List<FoodProperty> findFoodProperty(Integer id);
	
	public List<FoodPropertyDetail> findFoodPropertyDetail(Integer id);
	
	public double fingFoodTypePriceByFoodType(String foodType);
	
}
