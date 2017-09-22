package com.elm.entity;

import java.util.List;

public class HongbaoRule {
	/**
	 *  id 唯一标识
	 *  startTime 红包可以开始使用的时间
	 *  endTime 过期时间
	 *  phoneNumber 电话
	 *  foodType 限制可以使用的店铺类型
	 */
	private Integer id;
	private Integer startTime;
	private Integer endTime;
	private String phoneNumber;
	private List foodType;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStartTime() {
		return startTime;
	}
	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}
	public Integer getEndTime() {
		return endTime;
	}
	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public List getFoodType() {
		return foodType;
	}
	public void setFoodType(List foodType) {
		this.foodType = foodType;
	}
	
	
}
