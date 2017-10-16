package com.elm.dao;

import java.util.List;

import com.elm.entity.Address;
import com.elm.entity.Hongbao;
import com.elm.entity.HongbaoRule;
import com.elm.entity.User;

public interface UserDao {
	
	public User findUserByNameAndPass(String userName,String password);
	
	public User findUserByName(String userName);
	
	public Hongbao findHongbao(Integer id);
	
	public Address findAddress(Integer id);
	
	public HongbaoRule findHongbaoRule(Integer id);
	
	public List<Address> findAddressByUserId(Integer userId);
	
	public Integer insertUser(User user);
	
	public Integer insertUserAddress(Address address);
	
	public Integer deleteAddressById(Integer id);
	
	public Integer updateAddressById(Address address);
	
	public Integer updatePasswordById(Integer id,String password);

}
