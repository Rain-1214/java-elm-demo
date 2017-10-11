package com.elm.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.elm.dao.UserDao;
import com.elm.entity.Address;
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

	@Override
	public Integer insertUserAddress(Address address) {
		Integer resultNum = userDao.insertUserAddress(address);
		return resultNum;
	}

	@Override
	public List<Address> findAddressByUserId(Integer userId) {
		List<Address> result = userDao.findAddressByUserId(userId);
		return result;
	}

	@Override
	public Integer deleteAddressById(Integer id) {
		return userDao.deleteAddressById(id);
	}


	
	
	
}
