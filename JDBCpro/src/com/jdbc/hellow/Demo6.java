package com.jdbc.hellow;

import java.sql.Connection;
import java.sql.Types;

import com.mysql.jdbc.CallableStatement;

import util.DbUtil;

public class Demo6 {
	
	private static DbUtil dbUtil = new DbUtil();
	
	private static String getBookNameById(int id) throws Exception{
		Connection con = dbUtil.getCon();
		String sql = "{call pro_getBookNameById(?,?)}";
		CallableStatement cstmt = (CallableStatement) con.prepareCall(sql);
		cstmt.setInt(1, id);
		cstmt.registerOutParameter(2, Types.VARCHAR);
		cstmt.execute();
		String bookName = cstmt.getString("bN");
		dbUtil.close(cstmt, con);
		return bookName;
	}
	
	
	public static void main(String[] args) throws Exception {
		System.out.println(getBookNameById(4));
	}
}
