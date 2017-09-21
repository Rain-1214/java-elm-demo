package com.elm.entity;

import java.util.List;

public class User {
	/**
	 * id 唯一标识
	 * userName 用户名
	 * password 密码
	 * phoneNumber 手机
	 * userImg 头像
	 * activityPoints 积分
	 * address 地址
	 * hongBao 红包
	 */
	private int id;
	private String userName;
	private String password;
	private String phoneNumber;
	private String userImg;
	private int activityPoints;
	private List address;
	private List hongBao;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUserImg() {
		return userImg;
	}
	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	public int getActivityPoints() {
		return activityPoints;
	}
	public void setActivityPoints(int activityPoints) {
		this.activityPoints = activityPoints;
	}
	public List getAddress() {
		return address;
	}
	public void setAddress(List address) {
		this.address = address;
	}
	public List getHongBao() {
		return hongBao;
	}
	public void setHongBao(List hongBao) {
		this.hongBao = hongBao;
	}
	
	
	
	
	
	
}
