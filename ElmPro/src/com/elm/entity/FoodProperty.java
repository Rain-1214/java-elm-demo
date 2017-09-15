package com.elm.entity;

import java.util.List;

public class FoodProperty {
	/**
	 * id Ψһ��ʶ
	 * typeName ��������
	 * foodId ��ӦʳƷId
	 * foodPropertyDetail �ù���Ӧ����ϸ���
	 */
	private Integer id;
	private String typeName;
	private Integer foodId;
	private List<FoodPropertyDetail> foodPropertyDetail;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Integer getFoodId() {
		return foodId;
	}
	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}
	public List<FoodPropertyDetail> getFoodPropertyDetail() {
		return foodPropertyDetail;
	}
	public void setFoodPropertyDetail(List<FoodPropertyDetail> foodPropertyDetail) {
		this.foodPropertyDetail = foodPropertyDetail;
	}
	
	
	
}
