package com.elm.entity;

public class ShopProperty {
	/**
	 * id 唯一标识
	 * newUserFavorable 新用户优惠
	 * safeguard 保价
	 * invoice 发票
	 * hummingbird 蜂鸟专送
	 * shopId 对应商店ID
	 */
	private Integer id;
	private Integer newUserFavorable;
	private Integer safeguard;
	private Integer invoice;
	private Integer hummingbird;
	private Integer shopId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNewUserFavorable() {
		return newUserFavorable;
	}
	public void setNewUserFavorable(Integer newUserFavorable) {
		this.newUserFavorable = newUserFavorable;
	}
	public Integer getSafeguard() {
		return safeguard;
	}
	public void setSafeguard(Integer safeguard) {
		this.safeguard = safeguard;
	}
	public Integer getInvoice() {
		return invoice;
	}
	public void setInvoice(Integer invoice) {
		this.invoice = invoice;
	}
	public Integer getHummingbird() {
		return hummingbird;
	}
	public void setHummingbird(Integer hummingbird) {
		this.hummingbird = hummingbird;
	}
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	
	
	
}
