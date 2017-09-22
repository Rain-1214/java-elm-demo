package com.elm.entity;

public class Hongbao {
	/**
	 * id 唯一标识
	 * hongbaoName 红包名称
	 * fillMoney 满多少
	 * minusNum 减多少
	 * userId 对应用户ID
	 * hongbaoState 红包对应状态      0=》已过期             1=》已使用                2=》正常
	 * hongbaoRule 红包规则
	 * 
	 */
	private Integer id;
	private String hongbaoName;
	private double fillMoney;
	private double minusNum;
	private Integer userId;
	private Integer hongbaoState;
	private HongbaoRule hongbaoRule;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHongbaoName() {
		return hongbaoName;
	}
	public void setHongbaoName(String hongbaoName) {
		this.hongbaoName = hongbaoName;
	}
	public double getFillMoney() {
		return fillMoney;
	}
	public void setFillMoney(double fillMoney) {
		this.fillMoney = fillMoney;
	}
	public double getMinusNum() {
		return minusNum;
	}
	public void setMinusNum(double minusNum) {
		this.minusNum = minusNum;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getHongbaoState() {
		return hongbaoState;
	}
	public void setHongbaoState(Integer hongbaoState) {
		this.hongbaoState = hongbaoState;
	}
	public HongbaoRule getHongbaoRule() {
		return hongbaoRule;
	}
	public void setHongbaoRule(HongbaoRule hongbaoRule) {
		this.hongbaoRule = hongbaoRule;
	}
	
	
	
}
