package com.student.service.impl;

import java.util.HashMap;
import java.util.Map;

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
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return userDao.insertUser(user);
	}

	@Override
	public User findUser(User user) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userName", user.getUserName());
		User resultUser = userDao.findUser(map);
		return resultUser;
	}

	@Override
	public int updateUser(User user) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", user.getId());
		map.put("password", user.getPassword());
		return userDao.updateUser(map);
	}

	

	

}
