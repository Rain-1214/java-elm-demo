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
	 * safetyQuestion 安全问题
	 * safetyAnswer 安全答案
	 * address 地址
	 * hongBao 红包
	 */
	private Integer id;
	private String userName;
	private String password;
	private String phoneNumber;
	private String userImg;
	private Integer activityPoints;
	private String safetyQuestion;
	private String safetyAnswer;
	private List address;
	private List hongbao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Integer getActivityPoints() {
		return activityPoints;
	}
	public void setActivityPoints(Integer activityPoints) {
		this.activityPoints = activityPoints;
	}
	public String getSafetyQuestion() {
		return safetyQuestion;
	}
	public void setSafetyQuestion(String safetyQuestion) {
		this.safetyQuestion = safetyQuestion;
	}
	public String getSafetyAnswer() {
		return safetyAnswer;
	}
	public void setSafetyAnswer(String safetyAnswer) {
		this.safetyAnswer = safetyAnswer;
	}
	public List getAddress() {
		return address;
	}
	public void setAddress(List address) {
		this.address = address;
	}
	public List getHongBao() {
		return hongbao;
	}
	public void setHongBao(List hongbao) {
		this.hongbao = hongbao;
	}
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userName, String password, String safetyQuestion, String safetyAnswer) {
		super();
		this.userName = userName;
		this.password = password;
		this.safetyQuestion = safetyQuestion;
		this.safetyAnswer = safetyAnswer;
	}
	
	
	
}
