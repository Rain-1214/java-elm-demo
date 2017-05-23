package com.jdbc.hellow;

import java.sql.Connection;
import java.sql.Statement;

import util.DbUtil;

public class Demo2 {
	public static void main(String[] args) throws Exception {
		DbUtil dbu = new DbUtil();
		String sql = "insert into t_book values(null,'aaaa',888,'ace',1)";
		
		Connection con = dbu.getCon();
		
		Statement stmt = con.createStatement();
		
		int result = stmt.executeUpdate(sql);
		System.out.println(result);
		
		stmt.close();
		con.close();
	}
}
