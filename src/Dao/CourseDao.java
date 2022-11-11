package Dao;



import java.util.List;

import Exceptions.CourseException;
import JavaBean.Course;

public interface CourseDao {

	public String addCourse(Course course)throws CourseException;
	
	public List<Course> searchBYCourseName(String courseName) throws CourseException;
	
	public List<Course> getAllCourse() throws CourseException;
	
	public String updateCourseDetails(String str, String set, String name) throws CourseException;
	
	public String deleteBatch(String courseName) throws CourseException;
	
}
