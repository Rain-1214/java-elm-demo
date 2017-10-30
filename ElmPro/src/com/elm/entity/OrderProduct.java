package com.elm.entity;

public class OrderProduct {

	private Integer id;
	private Integer foodId;
	private String name;
	private Integer num;
	private String foodType;
	private double price;
	private Integer orderId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getFoodId() {
		return foodId;
	}
	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public OrderProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderProduct(Integer foodId, String name, Integer num, String foodType, double price, Integer orderId) {
		super();
		this.foodId = foodId;
		this.name = name;
		this.num = num;
		this.foodType = foodType;
		this.price = price;
		this.orderId = orderId;
	}
	
	
	
	
}
