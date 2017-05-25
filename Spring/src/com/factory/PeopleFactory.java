package com.factory;

import com.entity.People;

public class PeopleFactory {
	public People createPeople(){
		People p = new People();
		p.setAge(10);
		p.setName("утаЫ");
		p.setId(4);
		return p;
	}
}
