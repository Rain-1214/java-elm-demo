package com.elm.entity;

import java.util.List;

public class FoodType {
	/**
	 * id 唯一标识
	 * listName 食品类别名字
	 * description 简介
	 * shopId 对应的商店
	 * foodList 该类型下的食品
	 */
	private Integer id;
	private String listName;
	private String description;
	private Integer shopId;
	private List<Food> foodList;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	public List<Food> getFoodList() {
		return foodList;
	}
	public void setFoodList(List<Food> foodList) {
		this.foodList = foodList;
	}
	
	
	
}
