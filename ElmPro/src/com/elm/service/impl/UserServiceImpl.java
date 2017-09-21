package com.elm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.elm.dao.UserDao;
import com.elm.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Resource
	public UserDao userDao;
	
	
	
}
