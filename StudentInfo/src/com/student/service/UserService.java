package com.student.service;

import com.student.entity.User;

public interface UserService {
	
	public User login(User user);
	
	public int insertUser(User user);
	
}
