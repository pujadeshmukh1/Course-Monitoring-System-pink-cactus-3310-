package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.protocol.Message;

import Exceptions.CourseException;
import Extra.ConsoleColors;
import Model_JavaBeen.Course;
import Utility.DBUtil;

public class CourseDaoImpl implements CourseDao{

	@Override
	public String addCourse() throws CourseException {

		Scanner sc=new Scanner(System.in);

		System.out.println("enter course id");
		int courseId = sc.nextInt();
		
		System.out.println("enter course name");
		String courseName=sc.next();
		System.out.println("enter course fee");
		int Fee=sc.nextInt();
		System.out.println("enter course CourseDesc");
		String courseDescription=sc.next();
		String message = ConsoleColors.RED+"Data Not Inserted..."+ConsoleColors.RESET;
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn .prepareStatement("insert into course(courseId, courseName, Fee, courseDescription)values(?,?,?,?)");
			
			ps.setInt(1, courseId);
			ps.setString(2,courseName);
			ps.setInt(3, Fee);
			ps.setString(4, courseDescription);
			
			int x = ps.executeUpdate();
			
			if(x>0) {		
				message = ConsoleColors.GREEN+"New Course Added Successfully.."+ConsoleColors.RESET;	
			}else {
				throw new CourseException(ConsoleColors.RED_BACKGROUND+"Duplicate Entry"+ConsoleColors.RESET);
			}
			
		}catch(SQLException e) {
//			e.printStackTrace();
			
			throw new CourseException(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
			
		}
		
		return message;
	}

	@Override
	public List<Course> getAllCourse() throws CourseException {
List<Course> courses = new ArrayList<>();
		
		try(Connection conn =DBUtil.provideConnection()){
			
			PreparedStatement ps = conn .prepareStatement("Select * from Course");

			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {		
				
				int cid = rs.getInt("courseId");
				String cname = rs.getString("courseName");
				int cfee = rs.getInt("Fee");
				String cdesc = rs.getString("courseDescription");
				
				Course course = new Course(cid, cname, cfee, cdesc);
				
				courses.add(course);
				
			}
			
			if(courses.size() == 0) {
				throw new CourseException(ConsoleColors.RED_BACKGROUND+"No Course found.."+ConsoleColors.RESET);
			}
			
				
		}catch(SQLException e) {
//			e.printStackTrace();
			
			throw new CourseException(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
		}
		
		return courses;
	}

	@Override
	public Course searchCourseName() throws CourseException {
		Course c=null;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter CourseName :-");
		String CourseName= sc.next();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from course where courseName=?");
			
			ps.setString(1, CourseName);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("courseid");
				String  n = rs.getString("courseName");
				int f = rs.getInt("fee");
				String cd = rs.getString("courseDescription");
				
				Course course = new Course(id,n,f,cd);
				
				
				
				
			}else {
				throw new CourseException(ConsoleColors.RED_BACKGROUND+"Course does not exist."+ConsoleColors.RESET);
			}
			
		} catch (Exception e) {
		e.getMessage();
		}
		
		return c;
	}

	@Override
	public String updateCourseDetails() throws CourseException {
		
		String message = "Data not update";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("give Course Name");
		String name = sc.next();
		
		System.out.println("give new fee");
		int fee = sc.nextInt();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update Course set fee =? where courseName=?");
			
			ps.setInt(1, fee);
			ps.setString(2, name);
			
			int rs = ps.executeUpdate();
			
			if( rs >0) {
				message = ConsoleColors.GREEN+"course Details Updated Successfully.."+ConsoleColors.RESET;	
			}else {
				throw new CourseException(ConsoleColors.RED+"Course Not Exist"+ConsoleColors.RESET);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return message;
	}

	@Override
	public String deleteCourse() throws CourseException {
		
		String message = "Course not update";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("give CourseName:- ");
		String CourseName = sc.next();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("delete from Course where courseName=?");
			
			ps.setString(1, CourseName);
			
			int rs = ps.executeUpdate();
		if(rs >0 ) {	
			message = ConsoleColors.GREEN+"Course Deleted Successfully.."+ConsoleColors.RESET;	
		}else {
			throw new CourseException(ConsoleColors.RED+"Course Not Exist"+ConsoleColors.RESET);
			
		}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}

	
}
