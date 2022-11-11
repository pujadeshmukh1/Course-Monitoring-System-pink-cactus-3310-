package Uses_cases_Course;

import java.util.Scanner;

import Dao.CourseDao;
import Dao.CourseDaoImpl;
import Dao.FacultyDao;
import Dao.FacultyDaoImpl;
import Exceptions.CourseException;
import Exceptions.InputException;
import JavaBean.Course;
import custom.ConsoleColors;

public class addCourse_usesCases {
	
public static void main(String[] args) throws InputException{
		
		try {
		
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			System.out.println(ConsoleColors.CYAN+"Enter First coursed_id "+ConsoleColors.RESET);
			int courseId = sc.nextInt();
			
			System.out.println(ConsoleColors.CYAN+"Enter courseName of course"+ConsoleColors.RESET);
			String courseName = sc.next();
				
			System.out.println(ConsoleColors.CYAN+"Enter courseFee of course"+ConsoleColors.RESET);
			int fee = sc.nextInt();
			
			sc.nextLine();
			System.out.println(ConsoleColors.CYAN+"Enter course Description of course"+ConsoleColors.RESET);
			String courseDesc = sc.next();
			
			
			
			
			Course course = new Course(courseId, courseName, fee,  courseDesc);
			CourseDao dao = new CourseDaoImpl();
			
			
			String res;
			try {
				res = dao.addCourse(course);
				System.out.println();
				System.out.println(res);
				System.out.println();
				
			} catch (CourseException ce) {
				System.out.println();
				System.out.println(ConsoleColors.RED_BACKGROUND+ce.getMessage()+ConsoleColors.RESET);
				System.out.println();
			}
			
		}catch(Exception e) {
			throw new InputException(ConsoleColors.RED+"Please Enter Right Input"+ConsoleColors.RESET);
			
		}
		
		
	}

			
			
}