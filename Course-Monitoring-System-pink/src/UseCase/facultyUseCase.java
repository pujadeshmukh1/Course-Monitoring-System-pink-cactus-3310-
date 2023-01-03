package UseCase;

import java.util.List;
import java.util.Scanner;

import Dao.CoursePlanDao;
import Dao.CoursePlanDaoImpl;
import Dao.FacultyDao;
import Dao.FacultyDaoImpl;
import Exceptions.CoursePlanException;
import Exceptions.FacultyException;
import Extra.ConsoleColors;
import Main.Main;
import Model_JavaBeen.CoursePlan;

public class facultyUseCase {
	public static void facultyOptions() {
		FacultyDao f=new FacultyDaoImpl();
		CoursePlanDao cp=new CoursePlanDaoImpl();
		System.out.println(ConsoleColors.CYAN+"chose your option");
		System.out.println("1. View the Course Plan");
		System.out.println("2.Fill up the day wise planner");
		System.out.println("3. Update Password");
		System.out.println("4. update status");
		System.out.println("5. Log Out"+ConsoleColors.RESET);
		Scanner sc=new Scanner(System.in);
		System.out.println();
		
		String ip=sc.next();
		
		switch (ip) {
		case "1": {
			CoursePlanDao c=new CoursePlanDaoImpl();
			try {	List<CoursePlan>c1p=c.viewAllCoursePlanDateWise();

				for (CoursePlan coursePlan : c1p) {
					System.out.println(coursePlan);
				}
				} catch (CoursePlanException e) {
					// TODO Auto-generated catch block
					System.out.println();
					System.out.println(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
					System.out.println();
					facultyOptions();
				}
			facultyOptions();
				break;
		}
		case "2": {
			try {
				System.out.println(cp.updateTopic());
				facultyOptions();
			} catch (CoursePlanException e) {
				// TODO Auto-generated catch block
				System.out.println();
				System.out.println(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
				System.out.println();
				facultyOptions();
			}
			break;		
			}
		case "3": {
			try {
				System.out.println(f.updateppssword());
				facultyOptions();
			} catch (FacultyException e) {
				// TODO Auto-generated catch block
				System.out.println();
				System.out.println(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
				System.out.println();
				facultyOptions();
			}
			
			break;		
			}
		case "4": {
			CoursePlanDao c=new CoursePlanDaoImpl();
			try {
				System.out.println(c.updateStatus());
			} catch (CoursePlanException e) {

				System.out.println();
				System.out.println(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
				System.out.println();
				facultyOptions();
			}
			facultyOptions();
			break;	
		}
		case "5":{
			System.out.println(ConsoleColors.TEAL+"Log Out Successfuly"+ConsoleColors.RESET);
			Main.main(null);
			break;
		}
		
		default:
			System.out.println("Unexpected value: " +ip);

			
		}
		
	}

	

}
