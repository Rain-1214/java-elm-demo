package com.elm.entity;

public class Order {
	
	private Integer id;
	private Integer shopId;
	private Integer userId;
	private Integer deliveryTime;
	private String selectDeliveryTime;
	private String creatTime;
	private String payMethod;
	private String deliveryMethod;
	private String remark;
	private Integer redPacketId;
	private double payPrice;
	private double discounts;
	private double deliveryCost;
	private String companyName;
	private String code;
	private Integer orderState;
	private String userName;
	private String userAddressName;
	private String userAddressDetail;
	private String userPhoneNumber;
	
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


	public double getDiscounts() {
		return discounts;
	}


	public void setDiscounts(double discounts) {
		this.discounts = discounts;
	}


	public double getDeliveryCost() {
		return deliveryCost;
	}


	public void setDeliveryCost(double deliveryCost) {
		this.deliveryCost = deliveryCost;
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


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserAddressName() {
		return userAddressName;
	}


	public void setUserAddressName(String userAddressName) {
		this.userAddressName = userAddressName;
	}


	public String getUserAddressDetail() {
		return userAddressDetail;
	}


	public void setUserAddressDetail(String userAddressDetail) {
		this.userAddressDetail = userAddressDetail;
	}


	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}


	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}


	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Order(Integer shopId, Integer userId, Integer deliveryTime, String selectDeliveryTime, String creatTime,
			String payMethod, String deliveryMethod, String remark, Integer redPacketId, double payPrice,
			double discounts, double deliveryCost, String companyName, String code, Integer orderState, String userName,
			String userAddressName, String userAddressDetail, String userPhoneNumber) {
		super();
		this.shopId = shopId;
		this.userId = userId;
		this.deliveryTime = deliveryTime;
		this.selectDeliveryTime = selectDeliveryTime;
		this.creatTime = creatTime;
		this.payMethod = payMethod;
		this.deliveryMethod = deliveryMethod;
		this.remark = remark;
		this.redPacketId = redPacketId;
		this.payPrice = payPrice;
		this.discounts = discounts;
		this.deliveryCost = deliveryCost;
		this.companyName = companyName;
		this.code = code;
		this.orderState = orderState;
		this.userName = userName;
		this.userAddressName = userAddressName;
		this.userAddressDetail = userAddressDetail;
		this.userPhoneNumber = userPhoneNumber;
	}
	
	
	
	
	
	
	
	
	
}
