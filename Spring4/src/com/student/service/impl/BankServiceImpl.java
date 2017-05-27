package com.student.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.student.dao.BankDao;
import com.student.service.BankService;


//@Transactional
public class BankServiceImpl implements BankService{
	
	private BankDao bankDao;


	public void setBankDao(BankDao bankDao) {
		this.bankDao = bankDao;
	}


	@Override
	public void transferAcounts(int account, int userIdA, int userIdB) {
		
		bankDao.OutMoney(account, userIdA);
		bankDao.inMoney(account, userIdB);
		
	}

}
