package com.elm.service;

import java.util.List;

import com.elm.entity.Shop;
import com.elm.entity.ShopType;

public interface ShopService {
	
	public List<ShopType> findShopType();
	
	public List<Shop> findShopList();
	
}
