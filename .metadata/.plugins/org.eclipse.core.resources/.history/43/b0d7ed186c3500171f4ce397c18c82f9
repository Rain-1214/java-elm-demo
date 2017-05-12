package com.hellow.obj;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dates {
	
	public static String dateFormat(Date date,String type){
		
		SimpleDateFormat dateFormat= new SimpleDateFormat(type);
		return dateFormat.format(date);
	}
	
	public static Date StringToDate(String date,String type) throws ParseException{
		SimpleDateFormat dateFormat= new SimpleDateFormat(type);
		return dateFormat.parse(date);
	}
	
	public static void main(String[] args) throws ParseException {
		
		Date date = new Date();
		System.out.println(date);
		System.out.println(dateFormat(date,"yyyy-MM-dd"));
		System.out.println(dateFormat(date,"yyyy-MM-dd HH:mm:ss"));
		
		String dateStr = "1995-01-02 12:15:02";
		Date date2 = StringToDate(dateStr,"yyyy-MM-dd HH:mm:ss");
		System.out.println(dateFormat(date2,"yyyy-MM-dd HH:mm:ss"));
		
	}
	
}
