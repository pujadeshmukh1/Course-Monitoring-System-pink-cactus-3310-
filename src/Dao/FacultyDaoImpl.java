package Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dao.custom.AutoPassGen;
import Exceptions.AdminException;
import Exceptions.CourseException;
import Exceptions.FacultyException;
import JavaBean.Faculty;
import Utility.DBconn;
import custom.ConsoleColors;

public class FacultyDaoImpl implements FacultyDao{

	
	
	@Override
	public String addFaculty(Faculty faculty) throws FacultyException {
		String message = "Data Not Inserted...";
		
		try(Connection conn = DBconn.provideConnection()){
			
			Statement statement = conn.createStatement();
			
            String sql = "SELECT MAX( facultyId ) FROM faculty";
            
            ResultSet result = statement.executeQuery(sql);
            
            Integer id = 0;
            
            if(result.next()) {
            	id = result.getInt("max( facultyId )");
            }
            
            id = id + 1;
            String text = String.format("%03d", id);
			String fname = faculty.getFacultyName().toLowerCase();
			String username = fname + text;
			String password = AutoPassGen.genPass(8);
			
			PreparedStatement ps1 = conn .prepareStatement("insert into Faculty(facultyId, facultyName, facultyAddress,  mobile, email ,username, password) values(?,?,?,?,?,?,?)");
			
			ps1.setInt(1, faculty.getFacultyId());
			ps1.setString(2, faculty.getFacultyName());
			
			ps1.setString(3, faculty.getFacultyAddress());
			
			ps1.setString(4, faculty.getMobile());
			ps1.setString(5, faculty.getEmail());
			ps1.setString(6, username);
			ps1.setString(7, password);
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
	public List<Faculty> searchFacultyByName(String fname) throws FacultyException{
		
		List<Faculty> facultys = new ArrayList<>();
		
		try (Connection conn = DBconn.provideConnection()){
			
			PreparedStatement ps3= conn.prepareStatement("Select * from Faculty where facultyName = ?");
			
			ps3.setString(1, fname);
			
			ResultSet rs = ps3.executeQuery();
			
			if(rs.next()) {
				
              int facultyId = rs.getInt("facultyId");
				
				String facultyname = rs.getString("facultyname");
				
				String facultyAddress = rs.getString("facultyAddress");
				
				String mobile = rs.getString("mobile");
				
				String email = rs.getString("email");
				
				String username = rs.getString("username");
				
				String password = rs.getString("password");

				Faculty faculty = new Faculty(facultyId, facultyname, facultyAddress, mobile, email, username, password);
				
				facultys.add(faculty);
				
			}
			if(facultys.size()==0) {
				throw new FacultyException("Faculty does not exist by name");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FacultyException(e.getMessage());
			// TODO: handle exception
		}
		return facultys;
		
		
		
		
	}



	@Override
	public Faculty searchFacultyById(int facultyId) throws FacultyException {
		
        Faculty faculty = null;
		
		try(Connection conn = DBconn.provideConnection()){
			
			
			PreparedStatement ps = conn .prepareStatement("Select * from Faculty where facultyId = ?");
			
			ps.setInt(1, facultyId);
			
			ResultSet rs = ps.executeQuery();
			
		
			if(rs.next()) {		
				int fid = rs.getInt("facultyId");
				
				String fname = rs.getString("facultyname");
				
				String address = rs.getString("facultyAddress");
				
				String mobile = rs.getString("mobile");
				
				String email = rs.getString("email");
				
				String username = rs.getString("username");
				
				String password = rs.getString("password");

				faculty = new Faculty(fid,fname,address,mobile,email,username, username);
				
			}else
			
				throw new FacultyException(ConsoleColors.RED_BACKGROUND+"Faculty does not exist with this id "+ facultyId + "."+ConsoleColors.RESET);
			
		}catch(SQLException e) {
//			e.printStackTrace();
			
			throw new FacultyException(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
		}
		
		return faculty;
	}




	@Override
	public String updateFacultyDetails(String str, String set, int facultyId) throws FacultyException {
		
		String message = "Data Not Updated..";
		
		try(Connection conn = DBconn.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update faculty set "+ str +" = ? where facultyId = ?");
			
			ps.setString(1, set);
			ps.setInt(2, facultyId);
			
			int x = ps.executeUpdate();
			
			if(x>0) {		
				message = ConsoleColors.GREEN+"Faculty Details Updated Successfully.."+ConsoleColors.RESET;	
			}
			
		}catch(SQLException e) {
			
			message = ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET;
			
		}
	
		return message;
	}




	@Override
	public List<Faculty> getAllFacultyDetails() throws FacultyException {
      
		List<Faculty> faculty = new ArrayList<>();
		
		try(Connection conn = DBconn.provideConnection()){
			
			PreparedStatement ps = conn .prepareStatement("Select * from faculty");

			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {		
				
				
				int facultyId = rs.getInt("facultyId");
				String facultyName = rs.getString("facultyName");
				String facultyAddress = rs.getString("facultyAddress");
				String mobile = rs.getString("mobile");
				String email = rs.getString("email");
				String username = rs.getString("username");
				String password = rs.getString("password");
				
				
			
				
				Faculty Facultys = new Faculty(facultyId, facultyName, facultyAddress, mobile, email, username, password);
				
				faculty.add(Facultys);
				
			}
			
			if(Faculty.size() == 0) {
				throw new FacultyException(ConsoleColors.RED_BACKGROUND+"No Faculty found.."+ConsoleColors.RESET);
			}
			
				
		}catch(SQLException e) {
    		e.printStackTrace();
			
			throw new FacultyException(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
		}
		
		return faculty;
			
	}



	// Delete details of faculty table
		@Override
		public String deleteFaculty(int facultyId) throws FacultyException {
			
			String message = ConsoleColors.RED+"Faculty Data Not Updated..."+ConsoleColors.RESET;
			
			try(Connection conn = DBconn.provideConnection()){
				
				
				PreparedStatement ps = conn .prepareStatement("delete from faculty where facultyId = ?");
				
				ps.setInt(1, facultyId);
				
				int x = ps.executeUpdate();
				
				if(x>0) {		
					message = ConsoleColors.GREEN+"Faculty Deleted Successfully.."+ConsoleColors.RESET;
					
				}else {
					throw new FacultyException(ConsoleColors.RED+"Faculty Not Exist"+ConsoleColors.RESET);
					
				}
				
			} catch (SQLException e) {

				throw new FacultyException(ConsoleColors.RED+"Wrong Data Format"+ConsoleColors.RESET);
			}
			
			return message;
		}




		@Override
		public Faculty loginFaculty(String username, String password) throws FacultyException {
			// TODO Auto-generated method stub
			return null;
		}




		


	}
