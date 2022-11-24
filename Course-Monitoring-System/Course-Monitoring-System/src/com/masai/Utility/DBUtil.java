package com.masai.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	public static Connection provConnection() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		String url="jdbc:mysql://localhost:3306/myproject1";
		
		try {
			conn=DriverManager.getConnection(url,"root","1997");
		} catch (SQLException e) {
			
			e.printStackTrace();
//			System.out.println(e.getMessage());
		}
		return conn;
	}
}
