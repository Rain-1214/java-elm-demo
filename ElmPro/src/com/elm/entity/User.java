package com.elm.entity;

import java.util.List;

public class User {
	/**
	 * id Ψһ��ʶ
	 * userName �û���
	 * password ����
	 * phoneNumber �ֻ�
	 * userImg ͷ��
	 * activityPoints ����
	 * address ��ַ
	 * hongBao ���
	 */
	private Integer id;
	private String userName;
	private String password;
	private String phoneNumber;
	private String userImg;
	private Integer activityPoints;
	private List address;
	private List hongBao;
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
