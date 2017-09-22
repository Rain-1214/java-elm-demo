package com.elm.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.elm.dao.UserDao;
import com.elm.entity.User;
import com.elm.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Resource
	public UserDao userDao;

	@Override
	public User findUserByName(String userName, String password) {
		User user = userDao.findUserByName(userName, password);
		return user;
	}


	
	
	
}
