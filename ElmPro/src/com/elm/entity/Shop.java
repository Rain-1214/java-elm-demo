package com.elm.entity;

import java.util.List;

public class Shop {
	/**
	 *  id Ψһ��ʶ
	 *  shopName �̵�����
	 *  shopLogo �̵�logo
	 *  shopNptice �̵깫��
	 *  isBrand �Ƿ���Ʒ��
	 *  serveEvaluate ��������
	 *  foodEvaluate ʳƷ����
	 *  countOrder �ܶ�������
	 *  deliveryCost ���ͷ�
	 *  startCost ���ͷ�
	 *  latitude,longitude ��γ��
	 *  averageUserCost ƽ��ÿ�˻���
	 *  shopPropertyType ������������
	 */
	private Integer id;
	private String shopName;
	private String shopLogo;
	private String shopNptice;
	private Integer isBrand;
	private Double serveEvaluate;
	private Double foodEvaluate;
	private Integer countOrder;
	private Double deliveryCost;
	private Double startCost;
	private Double latitude;
	private Double longitude;
	private Double averageUserCost;
	private List shopPropertyType;
	private List shopFullMinus;
	private ShopProperty shopProperty;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopLogo() {
		return shopLogo;
	}

	public void setShopLogo(String shopLogo) {
		this.shopLogo = shopLogo;
	}

	public String getShopNptice() {
		return shopNptice;
	}

	public void setShopNptice(String shopNptice) {
		this.shopNptice = shopNptice;
	}

	public Integer getIsBrand() {
		return isBrand;
	}

	public void setIsBrand(Integer isBrand) {
		this.isBrand = isBrand;
	}

	public Double getServeEvaluate() {
		return serveEvaluate;
	}

	public void setServeEvaluate(Double serveEvaluate) {
		this.serveEvaluate = serveEvaluate;
	}

	public Double getFoodEvaluate() {
		return foodEvaluate;
	}

	public void setFoodEvaluate(Double foodEvaluate) {
		this.foodEvaluate = foodEvaluate;
	}

	public Integer getCountOrder() {
		return countOrder;
	}

	public void setCountOrder(Integer countOrder) {
		this.countOrder = countOrder;
	}

	public Double getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(Double deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getAverageUserCost() {
		return averageUserCost;
	}

	public void setAverageUserCost(Double averageUserCost) {
		this.averageUserCost = averageUserCost;
	}

	public ShopProperty getShopProperty() {
		return shopProperty;
	}

	public void setShopProperty(ShopProperty shopProperty) {
		this.shopProperty = shopProperty;
	}

	public Double getStartCost() {
		return startCost;
	}

	public void setStartCost(Double startCost) {
		this.startCost = startCost;
	}

	public List getShopPropertyType() {
		return shopPropertyType;
	}

	public void setShopPropertyType(List shopPropertyType) {
		this.shopPropertyType = shopPropertyType;
	}

	public List getShopFullMinus() {
		return shopFullMinus;
	}

	public void setShopFullMinus(List shopFullMinus) {
		this.shopFullMinus = shopFullMinus;
	}
	
	
	
	
}
