package com.elm.util;

import java.util.Map;

public class MapEquals {
	
	public <T> Boolean mapEquals(Map<String,T> map1,Map<String,T> map2,String...keys){
		for(String s:keys){
			T value1 = map1.get(s);
			T value2 = map1.get(s);
			if (value1 != value2) {
				return false;
			}
		}
		return true;
	}
	
}
