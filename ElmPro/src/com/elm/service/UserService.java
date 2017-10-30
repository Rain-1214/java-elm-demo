package com.elm.service;

import java.util.List;

import com.elm.entity.Address;
import com.elm.entity.Hongbao;
import com.elm.entity.User;

public interface UserService {
	
	public User findUserByNameAndPass(String userName,String password);
	
	public User findUserByName(String userName);
	
	public Integer insertUser(User user);
	
	public Integer insertUserAddress(Address address);
	
	public List<Address> findAddressByUserId(Integer userId);
	
	public Integer deleteAddressById(Integer id);
	
	public Integer editAddressById(Address address);
	
	public Integer setNewPassword(Integer id,String password);
	
	public Hongbao findHongbaoById(Integer id);
	
}
