package com.jdbc.hellow;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import util.DbUtil;

public class Insert {

	private static DbUtil dbUtil = new DbUtil();

	private static int insert(String bookName, float price, String author, int bookTypeId) throws Exception {
		Connection con = dbUtil.getCon();
		String sql = "insert into t_book values(null,'" + bookName + "'," + price + ",'" + author + "'," + bookTypeId
				+ ")";
		Statement stmt = con.createStatement();
		int result = stmt.executeUpdate(sql);
		return result;
	}

	private static int insert2(Book book) throws Exception {
		Connection con = dbUtil.getCon();
		String sql = "insert into t_book values(null,'" + book.getBookName() + "'," + book.getPrice() + ",'" + book.getAuthor()
				+ "'," + book.getBookTypeId() + ")";
		Statement stmt = con.createStatement();
		int result = stmt.executeUpdate(sql);
		return result;
	}

	public static void main(String[] args) throws Exception {

/*		int i = insert("bbb", 120, "ccc", 1);

		if (i == 1) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}*/
		Book book = new Book(15,"aaaa",20,"eee",1);
		int i = insert2(book);

		if (i == 1) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}

	}
}
