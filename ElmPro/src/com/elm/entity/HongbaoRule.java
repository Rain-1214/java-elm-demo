package com.elm.entity;

import java.util.List;

public class HongbaoRule {
	/**
	 *  id Ψһ��ʶ
	 *  startTime ������Կ�ʼʹ�õ�ʱ��
	 *  endTime ����ʱ��
	 *  phoneNumber �绰
	 *  foodType ���ƿ���ʹ�õĵ�������
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
