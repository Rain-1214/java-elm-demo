package com.elm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.elm.dao.ShopDao;
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
	public ShopDao shopDao;
	
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
		return result;
	}

	@Override
	public Integer findActivityPointByUserId(Integer id) {
		return userDao.findActivityPointByUserId(id);
	}

	@Override
	public List<Hongbao> insertHongbaoToUser(Hongbao hongbao, Integer expendActivityPoint, List<Integer> shopTypeIdList) {
		Integer userActivityPoint = userDao.findActivityPointByUserId(hongbao.getUserId());
		if (userActivityPoint < expendActivityPoint){
			return null;
		}
		Integer newUserAcitivityPoint = userActivityPoint - expendActivityPoint;
		userDao.insertHongbao(hongbao);
		userDao.updateUserActivityPointByUserId(hongbao.getUserId(), newUserAcitivityPoint);
		Integer hongbaoId = hongbao.getId();
		if (shopTypeIdList.size() > 0){
			shopTypeIdList.forEach((e) -> {
				String shoptypeName = shopDao.findShopTypeNameById(e);
				userDao.insertHongbaoRules(hongbaoId, e, shoptypeName);
			});
		}
		List<Hongbao> hongbaoList = userDao.findHongbaoByUserId(hongbao.getUserId());
		return hongbaoList;
	}

	@Override
	public Integer updateActivityPointByUserId(Integer userId,Integer activityPoint) {
		Integer userActivityPoint = userDao.findActivityPointByUserId(userId);
		Integer newUserActivityPoint = userActivityPoint + activityPoint;
		Integer result = userDao.updateUserActivityPointByUserId(userId, newUserActivityPoint);
		if (result == 1){
			return newUserActivityPoint;
		} 
		return null;
	}


	
	
	
}
