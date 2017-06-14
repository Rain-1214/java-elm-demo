package com.elm.service;

import java.util.ArrayList;
import java.util.List;

import com.elm.entity.City;

public interface LocationService {
	
	public String analysisLocation(String location);
	
	public ArrayList<String> findHotCity();
	
}
