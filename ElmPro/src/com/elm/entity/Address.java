package com.elm.entity;

public class Address {
	
	/**
	 * id Ψһ��ʶ
	 * userName �û�����
	 * sex �Ա�
	 * phoneNumber �绰
	 * addressName ��ַ����
	 * addressDetail ��ַ��ϸ��Ϣ
	 * tag ��ַ��ǩ
	 * lat,lon ��γ��
	 * userId ��Ӧ�ĸ��û�
	 */
	
	private Integer id;
	private String userName;
	private Integer sex;
	private String phoneNumber;
	private String addressName;
	private String addressDetail;
	private String tag;
	private double lat;
	private double lon;
	private Integer userId;
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
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
	
	
	
}
