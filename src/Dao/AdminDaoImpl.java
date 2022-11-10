package Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Exceptions.AdminExcep;
import Utility.DBconn;


public class AdminDaoImpl implements AdminDao{

	@Override
	public boolean LoginAdmin(String username, String password) throws AdminExcep {
		
		boolean flag= false;
		
		try (Connection conn = DBconn.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from admin where username = ?");
			
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				PreparedStatement ps1 = conn.prepareStatement("select * from admin where username = ? and password = ?");
				ps1.setString(1, username);
				ps1.setString(1, password);
				
//				if(rs1.next()) {
//					flag = true;
//				}else
//					throw new AdminExcep(ConsoleColors.RED+"Wrong Password"+ConsoleColors.RESET);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
	}

}

