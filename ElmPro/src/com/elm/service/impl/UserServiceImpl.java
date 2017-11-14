package com.elm.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.elm.dao.OrderDao;
import com.elm.dao.UserDao;
import com.elm.entity.Address;
import com.elm.entity.Hongbao;
import com.elm.entity.User;
import com.elm.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Resource
	public UserDao userDao;
	
	@Resource
	public OrderDao orderDao;

	@Override
	public User findUserByNameAndPass(String userName, String password) {
		return userDao.findUserByNameAndPass(userName, password);
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

	@Override
	public Integer editAddressById(Address address) {
		return userDao.updateAddressById(address);
	}

	@Override
	public Integer setNewPassword(Integer id, String password) {
		return userDao.updatePasswordById(id, password);
	}

	@Override
	public Hongbao findHongbaoById(Integer id) {
		return userDao.findHongbaoById(id);
	}

	@Override
	public List<Hongbao> findHongbaoByUserId(Integer userId) {
		List<Hongbao> result = userDao.findHongbaoByUserId(userId);
//		for(int i = 0;i < result.size();i++){
//			long nowTime = new Date().getTime();
//			Hongbao hongbao = result.get(i);
//			long endTime = hongbao.getEndTime().getTime();
//			if(nowTime > endTime){
//				orderDao.updateHongbaoStateById(userId, Hongbao.STALE);
//				hongbao.setHongbaoState(Hongbao.STALE);
//			}
//		}
		return result;
	}


	
	
	
}
