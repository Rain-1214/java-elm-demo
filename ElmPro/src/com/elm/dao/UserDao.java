package com.elm.dao;

import com.elm.entity.User;

public interface UserDao {
	
	public User findUserByName(String userName,String password);

}
