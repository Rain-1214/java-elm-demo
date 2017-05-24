package com.jdbc.hellow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import util.DbUtil;

public class Demo9 {
	
	private static DbUtil dbUtil = new DbUtil();
	
	private static void outCount(Connection con,String accountName,int account) throws Exception{
		String sql = "update t_account set accountBalance = accountBalance +? where accountName = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, account);
		pstmt.setString(2, accountName);
		pstmt.executeUpdate();
	}
	
	private static void inCount(Connection con,String accountName,int account) throws Exception{
		String sql = "update t_account set accountBalance = accountBalance -? where accountName = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, account);
		pstmt.setString(2, accountName);
		pstmt.executeUpdate();
	}
	
	public static void main(String[] args) {
		
		Connection con = null;
		Savepoint sp = null;
		try {
			con = dbUtil.getCon();
			con.setAutoCommit(false);
			
			int account = 500;
			outCount(con, "����", account);
			sp = con.setSavepoint();
			inCount(con, "����", account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback(sp);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
				con.commit();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
}
