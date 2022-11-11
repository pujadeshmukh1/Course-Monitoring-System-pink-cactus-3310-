package Uses_cases_Course;

import java.util.List;

import Dao.CourseDao;
import Dao.CourseDaoImpl;
import Exceptions.CourseException;
import JavaBean.Course;
import custom.ConsoleColors;

public class getAllCourse_UseCases {

public static void main(String[] args) {
		
		
	CourseDao dao = new CourseDaoImpl();
		
		
		try {
		 	List<Course> c = dao.getAllCourse();
		 	c.forEach(s ->{
		 		System.out.println();
		 		
		 		System.out.println(ConsoleColors.ORANGE+"Course Id : "+ s.getCourseId());
		 		System.out.println("Course Name : " + s.getCourseName());
				System.out.println("Course Fee : " + s.getFee() + " Rs.");
				System.out.println("Course Description : " + s.getCourseDescription());
				System.out.println("------------------------------"+ConsoleColors.RESET);
		 		
		 	});
			 	
		 	System.out.println();
		}
		catch (CourseException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
}
