package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbUtil {
	private static String jdbcName = "com.mysql.jdbc.Driver";
	
	private static String dbUrl = "jdbc:mysql://localhost:3306/db_bank";
	
	private static String dbUserName = "root";
	
	private static String dbPassWord = "123456";
	
	public Connection getCon() throws Exception{
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassWord);
		return con;
	}
	
	public void close(Statement stmt,Connection con) throws Exception{
		if(stmt != null){
			stmt.close();
			if(con != null){
				con.close();
			}			
		}
		
	}
	
	
}
