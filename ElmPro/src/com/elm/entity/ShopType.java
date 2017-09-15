package com.elm.entity;

public class ShopType {
	/**
	 * id唯一标识
	 * typeName 类型名称
	 * typeLogo 类型logo
	 */
	
	private Integer id;
	private String typeName;
	private String typeLogo;
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
	public String getTypeLogo() {
		return typeLogo;
	}
	public void setTypeLogo(String typeLogo) {
		this.typeLogo = typeLogo;
	}
	
	
}
