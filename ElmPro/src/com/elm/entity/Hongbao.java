package com.elm.entity;

public class Hongbao {
	/**
	 * id Ψһ��ʶ
	 * hongbaoName �������
	 * fillMoney ������
	 * minusNum ������
	 * userId ��Ӧ�û�ID
	 * hongbaoState �����Ӧ״̬      0=���ѹ���             1=����ʹ��                2=������
	 * hongbaoRule �������
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
