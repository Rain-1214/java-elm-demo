package com.jdbc.hellow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DbUtil;

public class Demo4 {
	
	private static DbUtil dbUtil = new DbUtil();
	
	private static void listBook() throws Exception{
		
		Connection con = dbUtil.getCon();
		String sql = "select * from t_book";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet result = pstmt.executeQuery();
		while(result.next()){
			int id = result.getInt(1);
			String bookName = result.getString(2);
			float price = result.getFloat(3);
			String author = result.getString(4);
			int bookTypeId = result.getInt(5);
			
			System.out.println(" È:" + id + bookName + price + author + bookTypeId);
		}
		
		
		
	}
	
	private static void listBook2() throws Exception{
		
		Connection con = dbUtil.getCon();
		String sql = "select * from t_book";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet result = pstmt.executeQuery();
		while(result.next()){
			int id = result.getInt("id");
			String bookName = result.getString("bookName");
			float price = result.getFloat("price");
			String author = result.getString("author");
			int bookTypeId = result.getInt("bookTypeId");
			
			System.out.println(" È:" + id + bookName + price + author + bookTypeId);
		}
	}
	
	private static List<Book> listBook3() throws Exception{
		
		List<Book> bookList = new ArrayList<Book>();
		Connection con = dbUtil.getCon();
		String sql = "select * from t_book";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet result = pstmt.executeQuery();
		while(result.next()){
			int id = result.getInt("id");
			String bookName = result.getString("bookName");
			float price = result.getFloat("price");
			String author = result.getString("author");
			int bookTypeId = result.getInt("bookTypeId");
			
			Book book = new Book(id,bookName,price,author,bookTypeId);
			bookList.add(book);
		}
		
		return bookList;
	}
	
	public static void main(String[] args) throws Exception {
		List<Book> bookList = listBook3();
		
		for(Book book:bookList){
			System.out.println(book.getBookName());
		}
		
	}
	
}
