package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Exceptions.FacultyException;
import Extra.ConsoleColors;
import Model_JavaBeen.Faculty;
import Utility.DBUtil;

public class FacultyDaoImpl implements FacultyDao{

	@Override
	public String addFaculty() throws FacultyException {
		String message=ConsoleColors.RED+"Faculty not added"+ConsoleColors.RESET;
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("enter facultyId ");
		int facultyId =sc.nextInt();
		System.out.println("enter facultyname ");
		String facultyname =sc.next();
		System.out.println("enter facultyaddress ");
		String facultyaddress =sc.next();
		System.out.println("enter mobile ");
		String mobile =sc.next();
		System.out.println("enter email ");
		String email =sc.next();
		System.out.println("enter username ");
		String username =sc.next();
		System.out.println("enter password ");
		String password  =sc.next();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into faculty(facultyId,facultyname,facultyaddress,mobile,email,username,password) values(?,?,?,?,?,?,?)");
			
			ps.setInt(1,facultyId);
			ps.setString(2,facultyname);
			ps.setString(3,facultyaddress);
			ps.setString(4,mobile);
			ps.setString(5,email);
			ps.setString(6,username);
			ps.setString(7,password);
			
			int rs=ps.executeUpdate();
			
			if(rs>0) {
				message=ConsoleColors.GREEN+"Faculty added"+ConsoleColors.RESET;
				
			}
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return message;
	}

	@Override
	public List<Faculty> getAllFacultyDetails() throws FacultyException {
		
		List<Faculty> fact = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("Select * from faculty");
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				int id = rs.getInt("facultyId");
				String name = rs.getString("facultyName");
				String address = rs.getString("facultyAddress");
				String mobile = rs.getString("mobile");
				String email = rs.getString("email");
				String username = rs.getString("username");
				String password = "********";
				
				Faculty f=new Faculty(id, name, address, mobile, email, username, password);
				
				fact.add(f);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return fact;
	}

	@Override
	public Faculty searchFacultyById() throws FacultyException {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter facultyId :-");
		int facultyId=sc.nextInt();
		
		Faculty faculty = null;
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("selet * from faculty where  facultyId= ? ");
			
			ps.setInt(1, facultyId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				int i = rs.getInt("facultyId");
				String n = rs.getString("facultyName");
				String a = rs.getString("facultyAddress");
				String m = rs.getString("mobile");
				String e= rs.getString("email");
				String u = rs.getString("username");
				String p = "********";
				
				faculty.setFacultyid(i);
				faculty.setFacultyname(n);
				faculty.setFacultyaddress(a);
				faculty.setMobile(m);
				faculty.setEmail(e);
				faculty.setUsername(u);
				faculty.setPassword(p);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return faculty;
	}

	@Override
	public List<Faculty> searchFacultyByName() throws FacultyException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter FacultyByName");
		String FacultyByName = sc.next();
		
		List<Faculty> fact = new ArrayList<>();
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from faculty where FacultyByName = ? ");
			
			ps.setString(1, FacultyByName);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				
				int id = rs.getInt("facultyId");
				
				String Name = rs.getString("FacultyByName");
				
				String add = rs.getString("facultyAddress");
				
				String mob = rs.getString("mobile");
				
				String em = rs.getString("email");
				
				String us = rs.getString("username");
			
		        String pass = "********";
				
           Faculty f=new Faculty(id, Name, add, mob, em, us, pass);
				
				fact.add(f);
				
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}

	@Override
	public String updateFacultyDetails() throws FacultyException {
		
	    String message = ConsoleColors.RED+"Not updated"+ConsoleColors.RESET;
		String str="";
        
		Scanner sc=new Scanner(System.in);
		
		System.out.println(ConsoleColors.PURPLE+"What do you want to update?"+ConsoleColors.RESET);
		
		System.out.println("1. facultyname");
		System.out.println("2. facultyaddress");
		System.out.println("3. mobile");
		System.out.println("4. email");
		System.out.println("5. username");
		System.out.println("6. password");
		
		int up=sc.nextInt();
		
		switch(up){
		
		case 1:str= "facultyname";
		break;
		
		case 2:str="facultyaddress";
		break;
		
		case 3:str="moblie";
		break;
		
		case 4:str="email";
		break;
		
		case 5:str="username";
		break;
		
		case 6:str="password";
		break;
		
		
		}
 
		System.out.println("entry facultyId :-");
		int id = sc.nextInt();
		
		
		System.out.println("enter new name :-"+str);
		String set=sc.next();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update faculty set "+str+" = ? where facultyid=?");
			
			ps.setString(1, set);
			ps.setInt(2, id);
			
			int rs =ps.executeUpdate();
			
			if(rs > 0) {
				message = ConsoleColors.GREEN+"faculty update";
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return message;
	}

	@Override
	public String deleteFaculty() throws FacultyException {
		String message=ConsoleColors.RED+" Faculty Not deleted "+ConsoleColors.RESET;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter facultyId ");
		int facultyId =sc.nextInt();
		
		
		try(Connection conn = DBUtil.provideConnection()){
			
			
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
	public String updateppssword() throws FacultyException {
		
		String msg=ConsoleColors.RED+"Not updated"+ConsoleColors.RESET;
		String str="";
	
		Scanner sc=new Scanner(System.in);
		
		str="password";
		
		
		System.out.println("enter facultyid");
		int id=sc.nextInt();
		System.out.println("enter new"+str);
		String set=sc.next();
		try(Connection conn=DBUtil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("update faculty set "+str+" = ? where facultyid=?");
			
			ps.setString(1, set);
			ps.setInt(2, id);
			
			int rs=ps.executeUpdate();
			
			if (rs>0) {
				msg=ConsoleColors.GREEN+"faculty update";
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return msg;
	}

	@Override
	public Boolean FacultyLogin() throws FacultyException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
