package com.elm.service;

import com.elm.entity.User;

public interface UserService {
	
	public User findUserByName(String userName,String password);
	
}
