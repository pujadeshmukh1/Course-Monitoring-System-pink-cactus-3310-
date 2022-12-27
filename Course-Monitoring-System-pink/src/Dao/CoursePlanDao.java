package Dao;

import java.util.List;

import Exceptions.CoursePlanException;
import Model_JavaBeen.CoursePlan;

public interface CoursePlanDao {
public String addCoursePlan() throws CoursePlanException;
	
	public String updateStatus() throws CoursePlanException;
	
	public String updateStatusAdmin() throws CoursePlanException;
	
	public String updateTopic() throws CoursePlanException;
	
//	public String updateDate() throws CoursePlanException;
//	
//	public String deleteStatus() throws CoursePlanException;
//	
	public List<CoursePlan> viewAllCoursePlanDateWise() throws CoursePlanException;
//	
//	public List<CoursePlan> viewFacultyCoursePlan() throws CoursePlanException;
	
//	public List<CoursePlan> viewCourseplan() throws CoursePlanException;
}
