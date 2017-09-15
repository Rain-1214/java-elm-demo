package com.elm.entity;

import java.util.List;

public class FoodProperty {
	/**
	 * id 唯一标识
	 * typeName 多规格名称
	 * foodId 对应食品Id
	 * foodPropertyDetail 该规格对应的详细规格
	 */
	private Integer id;
	private String typeName;
	private Integer foodId;
	private List<FoodPropertyDetail> foodPropertyDetail;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Integer getFoodId() {
		return foodId;
	}
	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}
	public List<FoodPropertyDetail> getFoodPropertyDetail() {
		return foodPropertyDetail;
	}
	public void setFoodPropertyDetail(List<FoodPropertyDetail> foodPropertyDetail) {
		this.foodPropertyDetail = foodPropertyDetail;
	}
	
	
	
}
