package Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Exceptions.CourseException;
import Exceptions.FacultyException;
import JavaBean.Course;
import Utility.DBconn;
import custom.ConsoleColors;

public class CourseDaoImpl implements CourseDao{

	
	@Override
	public String addCourse(Course course) throws CourseException {
   String message = "Data not insert";
		
		try (Connection conn = DBconn.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into course(CourseId, courseName, fee, courseDescription) values(?,?,?,?)");
			
			ps.setInt(1, course.getCourseId());
			ps.setString(2, course.getCourseName());
			ps.setInt(3, course.getFee());
			ps.setString(4, course.getCourseDescription());
			
			int rs = ps.executeUpdate();
			
			if( rs > 0) {
				
				message = ConsoleColors.GREEN+"New Course Added Successfully.."+ConsoleColors.RESET;	
			}else {
				throw new CourseException(ConsoleColors.RED_BACKGROUND+"Duplicate Entry"+ConsoleColors.RESET);
			}
			
				
			}
			
			
			
		 catch (Exception e) {
			// TODO: handle exception
			 throw new CourseException(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
		}
	
		
		return message;
		
	
}

	@Override
	public List<Course> searchBYCourseName(String name) throws CourseException {
		 List<Course> course=new ArrayList<>();
		
		try (Connection conn = DBconn.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("Select * from Course where courseName = ?");
			
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				 int  coursed_id = rs.getInt("courseId");	
				 String  courseName = rs.getString("courseName");	
				 int  fee = rs.getInt("fee");	
				 String  courseDescription = rs.getString("courseDescription");	
				 
				 Course cour = new Course(coursed_id, courseName, fee, courseDescription);
				
				 course.add(cour);
				
			}
			if(course.size()==0) {
				throw new FacultyException("course does not exist by name");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		
		return course;
		
		
	}

	@Override
	public List<Course> getAllCourse() throws CourseException {
		
		
     List<Course> courses = new ArrayList<>();
		
		try(Connection conn = DBconn.provideConnection()){
			
			PreparedStatement ps = conn .prepareStatement("Select * from Course");

			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {		
				
				int coursed_id = rs.getInt("courseId");
				String courseName = rs.getString("courseName");
				int fee = rs.getInt("fee");
				String courseDescription = rs.getString("courseDescription");
				
				Course course = new Course(coursed_id, courseName, fee, courseDescription);
				
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
	public String updateCourseDetails(String str, String set, String name) throws CourseException {

		String message = ConsoleColors.RED+"Course Data Not Updated..."+ConsoleColors.RESET;
		
		try(Connection conn = DBconn.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update course set "+ str +" = ? where courseName = ?");
			
			ps.setString(1, set);
			ps.setString(2, name);
			
			int x = ps.executeUpdate();
			
			if(x>0) {		
				message = ConsoleColors.GREEN+"course Details Updated Successfully.."+ConsoleColors.RESET;	
			}else {
				throw new CourseException(ConsoleColors.RED+"Course Not Exist"+ConsoleColors.RESET);
			}
			
		} catch (SQLException e) {	
			throw new CourseException(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
			
		}
		
		return message;
	}

	
	
	
	
	@Override
	public String deleteBatch(String courseName) throws CourseException {
    String message = ConsoleColors.RED+"Batch Data Not Updated..."+ConsoleColors.RESET;
		
		try(Connection conn = DBconn.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("delete from courses where courseName = ?");
			
			ps.setString(1, courseName);
			
			int x = ps.executeUpdate();
			
			if(x>0) {		
				
				message = ConsoleColors.GREEN+"Course Deleted Successfully.."+ConsoleColors.RESET;
				
			}else {
				
				throw new CourseException(ConsoleColors.RED+"Course Not Exist"+ConsoleColors.RESET);
				
			}
		}catch (SQLException e) {
			
			throw new CourseException(ConsoleColors.RED+"Wrong Data Format"+ConsoleColors.RESET);
		}
		
		return message;
		
	}

	}
	

