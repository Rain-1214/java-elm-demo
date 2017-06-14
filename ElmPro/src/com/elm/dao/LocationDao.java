package com.elm.dao;

import java.util.List;
import java.util.Map;

import com.elm.entity.City;

public interface LocationDao {

	public List<City> findHotCity();
	
}
