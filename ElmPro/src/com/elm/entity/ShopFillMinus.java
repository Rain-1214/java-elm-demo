package com.elm.entity;

public class ShopFillMinus {

	private Integer id;
	private double full;
	private double minus;
	private Integer shopId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getFull() {
		return full;
	}
	public void setFull(double full) {
		this.full = full;
	}
	public double getMinus() {
		return minus;
	}
	public void setMinus(double minus) {
		this.minus = minus;
	}
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	@Override
	public String toString() {
		return "ShopFillMinus [id=" + id + ", full=" + full + ", minus=" + minus + ", shopId=" + shopId + "]";
	}
	
	
	
}
