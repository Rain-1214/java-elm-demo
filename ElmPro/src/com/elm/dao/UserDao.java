package com.elm.dao;

import com.elm.entity.Address;
import com.elm.entity.Hongbao;
import com.elm.entity.HongbaoRule;
import com.elm.entity.User;

public interface UserDao {
	
	public User findUserByNameAndPass(String userName,String password);
	
	public User findUserByName(String userName);
	
	public Integer insertUser(User user);
	
	public Hongbao findHongbao(Integer id);
	
	public Address findAddress(Integer id);
	
	public HongbaoRule findHongbaoRule(Integer id);

}
