package Utility;

import java.sql.Connection;

public class DBUtility {

	public static void main(String[] args) {
		
		Connection conn = DBconn.provideConnection();
		
		System.out.println(conn);
		
		
	}
	
}
