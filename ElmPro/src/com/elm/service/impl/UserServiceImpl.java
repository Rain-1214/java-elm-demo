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
	public User findUserByNameAndPass(String userName, String password) {
		User user = userDao.findUserByNameAndPass(userName, password);
		return user;
	}

	@Override
	public User findUserByName(String userName) {
		User user = userDao.findUserByName(userName);
		return user;
	}

	@Override
	public Integer insertUser(User user) {
		Integer resultNum = userDao.insertUser(user);
		return resultNum;
	}


	
	
	
}
