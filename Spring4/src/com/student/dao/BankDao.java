package com.student.dao;

public interface BankDao {
	public void inMoney(int money,int userId);
	
	public void OutMoney(int money,int userId);
}
