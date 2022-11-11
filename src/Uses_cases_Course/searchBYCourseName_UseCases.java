package Uses_cases_Course;

import java.util.List;
import java.util.Scanner;

import Dao.CourseDao;
import Dao.CourseDaoImpl;

import JavaBean.Course;

public class searchBYCourseName_UseCases {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter courseName to Get details  :");
		String courseName= sc.next();

		
		CourseDao dao = new CourseDaoImpl();
		
		try {
			List<Course> result= dao.searchBYCourseName(courseName);
			result.forEach(res -> System.out.println(res));
		 
		
		
		
		}catch(Exception c) {
			System.out.println(c.getMessage());
		}
		

	}
		
		
	}
	
	


