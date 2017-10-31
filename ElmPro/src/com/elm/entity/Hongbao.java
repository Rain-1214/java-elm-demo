package com.elm.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class Hongbao {
	/**
	 * id 唯一标识
	 * hongbaoName 红包名称
	 * fillMoney 满多少
	 * minusNum 减多少
	 * userId 对应用户ID
	 * hongbaoState 红包对应状态      0=》已过期             1=》已使用                2=》正常
	 * hongbaoRule 红包规则
	 * 
	 */
	public static final Integer STALE = 0;
	public static final Integer ALREADY_USE = 1;
	public static final Integer CAN_USE = 2;
	
	private Integer id;
	private String hongbaoName;
	private double fillMoney;
	private double minusMoney;
	private Integer userId;
	private Integer hongbaoState;
	private Timestamp startTime;
	private Timestamp endTime;
	private String phoneNumber;
	private List shopTypeList;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHongbaoName() {
		return hongbaoName;
	}
	public void setHongbaoName(String hongbaoName) {
		this.hongbaoName = hongbaoName;
	}
	public double getFillMoney() {
		return fillMoney;
	}
	public void setFillMoney(double fillMoney) {
		this.fillMoney = fillMoney;
	}
	public double getMinusMoney() {
		return minusMoney;
	}
	public void setMinusMoney(double minusMoney) {
		this.minusMoney = minusMoney;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getHongbaoState() {
		return hongbaoState;
	}
	public void setHongbaoState(Integer hongbaoState) {
		this.hongbaoState = hongbaoState;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public List getShopTypeList() {
		return shopTypeList;
	}
	public void setShopTypeList(List shopTypeList) {
		this.shopTypeList = shopTypeList;
	}
	
	
}
