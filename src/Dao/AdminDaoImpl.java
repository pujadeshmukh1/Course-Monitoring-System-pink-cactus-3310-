package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import Exceptions.AdminException;
import JavaBean.Admin;
import Utility.DBconn;

public class AdminDaoImpl implements AdminDao{

	@Override
	public String registerAdmin(Admin admin) throws AdminException {
		String result = "Not Inserted..";
		
		try(Connection conn= DBconn.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("insert into Admins(AdminId,username,address,email,password) values(?,?,?,?,?)");

			ps.setInt(1, admin.getAdminId());
			ps.setString(2, admin.getUsername());
			ps.setString(3, admin.getAddress());
			ps.setString(4, admin.getEmail());
			ps.setString(5, admin.getPassword());
			
			
			int x= ps.executeUpdate();
			
			if(x >0)
				result = "Admin Registered Sucessfully..";
				
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AdminException(e.getMessage());
		}
		
		

		return result;
	
}

	@Override
	public Admin LoginAdmin(String username, String password) throws AdminException {
		Admin admin = null;
		
		try (Connection conn = DBconn.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from admins where username=?  AND password = ?");
			
			ps.setString(1,username);
			//ps.setString(2,email);
			ps.setString(2,password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int r= rs.getInt("AdminId");
				
				String n= rs.getString("username");
				
				String a= rs.getString("address");
				
				String e= rs.getString("email");
				
				String p= rs.getString("password");
				
				admin= new Admin(r, n, a, e, p);
				
			}else
				throw new AdminException("Invalid Username or password..");
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return admin;
		
	}

	}


