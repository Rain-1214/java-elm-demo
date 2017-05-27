package com.student.dao.impl;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.student.dao.BankDao;

public class BankDaoImpl implements BankDao{
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public void inMoney(int money, int userId) {
		String sql = "update t_account set accountBalance = accountBalance + :money where id = :id";
		MapSqlParameterSource msps = new MapSqlParameterSource();
		msps.addValue("money", money).addValue("id", userId);
		namedParameterJdbcTemplate.update(sql, msps);
		
	}

	@Override
	public void OutMoney(int money, int userId) {
		String sql = "update t_account set accountBalance = accountBalance - :money where id = :id";
		MapSqlParameterSource msps = new MapSqlParameterSource();
		msps.addValue("money", money).addValue("id", userId);
		namedParameterJdbcTemplate.update(sql, msps);
		
	}
	
}
