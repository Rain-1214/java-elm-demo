package com.jdbc.hellow;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo1 {
	
	private static String jdbcName = "com.mysql.jdbc.Driver";
	
	private static String dbUrl = "jdbc:mysql://localhost:3306/db_book";
	
	private static String dbUserName = "root";
	
	private static String dbPassWord = "123456";
	
	public static void main(String[] args) {
		
		try {
			Class.forName(jdbcName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("aa");
		Connection con = null;
		try {
			//获取数据库链接
			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassWord);
			System.out.println("成功");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
