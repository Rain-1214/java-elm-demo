package com.elm.entity;

public class FoodPropertyDetail {
	/**
	 * id 唯一标识
	 * name 类型名称
	 * price 该类型的价格浮动
	 * foodTypeId 对应的为哪个大类的类型
	 */
	private Integer id;
	private String name;
	private double price;
	private Integer foodTypeId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getFoodTypeId() {
		return foodTypeId;
	}
	public void setFoodTypeId(Integer foodTypeId) {
		this.foodTypeId = foodTypeId;
	}
	
	
	
}
