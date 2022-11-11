package Uses_cases_Course;

import java.util.Scanner;

import Dao.CourseDao;
import Dao.CourseDaoImpl;
import Exceptions.CourseException;
import Exceptions.InputException;
import custom.ConsoleColors;

public class deleteBatch_UseCases {

	public static void main(String[] args) throws InputException {
		
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			System.out.println(ConsoleColors.CYAN+"Enter Name of Course"+ConsoleColors.RESET);
			String courseName = sc.next();
			
			CourseDao dao = new CourseDaoImpl();
			
			try {
				String res = dao.deleteBatch(courseName);
				System.out.println();
				System.out.println(res);
				System.out.println();
				
			} catch (CourseException e) {
				System.out.println();
				System.out.println(ConsoleColors.RED_BACKGROUND+ e.getMessage()+ConsoleColors.RESET);
				System.out.println();
				
			}
			
		}catch(Exception e) {
			throw new InputException(ConsoleColors.RED+"Please Enter Right Input"+ConsoleColors.RESET);
			
		}
		
		
		
	}
	
}
