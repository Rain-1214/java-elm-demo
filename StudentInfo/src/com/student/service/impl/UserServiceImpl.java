package com.student.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.student.dao.UserDao;
import com.student.entity.User;
import com.student.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Resource
	public UserDao userDao;
	
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}

	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return userDao.insertUser(user);
	}

}
