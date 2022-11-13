package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import Dao.custom.AutoPassGen;
import Exceptions.AdminException;
import Exceptions.FacultyException;
import JavaBean.Faculty;
import Utility.DBconn;

public class Faculty_Login_DaoImpl implements Faculty_Login_Dao{

	@Override
	public String registerFaculty(Faculty faculty) throws FacultyException {
         String message = "Data Not Inserted...";
		
		try(Connection conn = DBconn.provideConnection()){
			
			
			
			PreparedStatement ps1 = conn .prepareStatement("insert into Faculty(facultyId, facultyName, facultyAddress,  mobile, email ,username, password) values(?,?,?,?,?,?,?)");
			
			ps1.setInt(1, faculty.getFacultyId());
			ps1.setString(2, faculty.getFacultyName());
			
			ps1.setString(3, faculty.getFacultyAddress());
			
			ps1.setString(4, faculty.getMobile());
			ps1.setString(5, faculty.getEmail());
			ps1.setString(6,faculty.getUsername() );
			ps1.setString(7, faculty.getPassword());
			int x = ps1.executeUpdate();
			
			if(x>0) {		
				message = "Faculty Added Successfully..";	
			}
			
		}catch(SQLException e) {
			
			message = e.getMessage();
			
		}
		
		return message;
	}

	@Override
	public Faculty loginFaculty(String username, String password) throws FacultyException {
		Faculty faculty = null;
		
		try (Connection conn = DBconn.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from Faculty where username=?  AND password = ?");
			
			ps.setString(1,username);
			//ps.setString(2,email);
			ps.setString(2,password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int i= rs.getInt("facultyId");
				
				String n= rs.getString("facultyName");
				
                String a= rs.getString("address");
                
                String m= rs.getString("mobile");
				
				String e= rs.getString("email");
				 
				String u= rs.getString("username");
				
				String p= rs.getString("password");
				
				faculty= new Faculty(i, n, a, m, u, p);
				
			}else
				throw new FacultyException("Invalid Username or password..");
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return faculty;
		
	}

	

	}


