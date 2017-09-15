package com.elm.entity;

public class City {
	/**
	 *  id 唯一标识
	 *  name 城市名称
	 *  hotCityId 是否是热门城市 1 => 是
	 */
	private Integer id;
	private String name;
	private Integer hotCityId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getHotCityId() {
		return hotCityId;
	}
	public void setHotCityId(Integer hotCityId) {
		this.hotCityId = hotCityId;
	}
	
}
