package com.elm.service;

import com.elm.entity.User;

public interface UserService {
	
	public User findUserByNameAndPass(String userName,String password);
	
	public User findUserByName(String userName);
	
	public Integer insertUser(User user);
	
}
