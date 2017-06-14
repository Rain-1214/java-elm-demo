package com.elm.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.elm.dao.LocationDao;
import com.elm.entity.City;
import com.elm.service.LocationService;
import com.elm.util.HttpRequest;

@Service("locationService")
public class LocationServiceImpl implements LocationService{
	
	public HttpRequest httpRequest;
	
	@Resource
	public LocationDao locationDao;
	

	@Override
	public String analysisLocation(String location) {
		
		String s=HttpRequest.sendGet("http://api.map.baidu.com/geocoder/v2/", "location=" + location + "&ak=ExYQ53a0MI8lkOYh7S16oZMbeSgCkmpw&output=json");
		return s;
	}


	@Override
	public ArrayList<String> findHotCity() {
		List<City> list = locationDao.findHotCity();
		List<String> listCityName = new ArrayList();
		for(City c:list){
			listCityName.add(c.getName());
		}
		return (ArrayList<String>) listCityName;
		
	}

}