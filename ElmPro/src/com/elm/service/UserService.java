package com.elm.service;

import java.util.List;

import com.elm.entity.Address;
import com.elm.entity.User;

public interface UserService {
	
	public User findUserByNameAndPass(String userName,String password);
	
	public User findUserByName(String userName);
	
	public Integer insertUser(User user);
	
	public Integer insertUserAddress(Address address);
	
	public List<Address> findAddressByUserId(Integer userId);
	
	public Integer deleteAddressById(Integer id);
	
}
