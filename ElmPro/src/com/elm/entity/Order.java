package com.elm.entity;

public class Order {
	
	private Integer id;
	private Integer shopId;
	private Integer userId;
	private Integer addressId;
	private Integer deliveryTime;
	private String selectDeliveryTime;
	private String creatTime;
	private String payMethod;
	private String deliveryMethod;
	private String remark;
	private Integer redPacketId;
	private double payPrice;
	private double discounts;
	private String companyName;
	private String code;
	private Integer orderState;
	
	public static final Integer NON_PAYMENT = 1; 
	public static final Integer ALREADY_CLOSE = 2;
	public static final Integer WAIT_COMPLETE = 3;
	public static final Integer ALREADY_COMPLETE = 4;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public Integer getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(Integer deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getSelectDeliveryTime() {
		return selectDeliveryTime;
	}
	public void setSelectDeliveryTime(String selectDeliveryTime) {
		this.selectDeliveryTime = selectDeliveryTime;
	}
	public String getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public String getDeliveryMethod() {
		return deliveryMethod;
	}
	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getRedPacketId() {
		return redPacketId;
	}
	public void setRedPacketId(Integer redPacketId) {
		this.redPacketId = redPacketId;
	}
	public double getPayPrice() {
		return payPrice;
	}
	public void setPayPrice(double payPrice) {
		this.payPrice = payPrice;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public Integer getOrderState() {
		return orderState;
	}
	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}
	
	public double getDiscounts() {
		return discounts;
	}
	public void setDiscounts(double discounts) {
		this.discounts = discounts;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(Integer shopId, Integer userId, Integer addressId, Integer deliveryTime, String selectDeliveryTime,
			String creatTime, String payMethod, String deliveryMethod, String remark, Integer redPacketId,
			double payPrice, double discounts, String companyName, String code, Integer orderState) {
		super();
		this.shopId = shopId;
		this.userId = userId;
		this.addressId = addressId;
		this.deliveryTime = deliveryTime;
		this.selectDeliveryTime = selectDeliveryTime;
		this.creatTime = creatTime;
		this.payMethod = payMethod;
		this.deliveryMethod = deliveryMethod;
		this.remark = remark;
		this.redPacketId = redPacketId;
		this.payPrice = payPrice;
		this.discounts = discounts;
		this.companyName = companyName;
		this.code = code;
		this.orderState = orderState;
	}
	
	
	
	
	
	
	
}
