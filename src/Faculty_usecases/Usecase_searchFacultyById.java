package Faculty_usecases;

import java.util.Scanner;

import Dao.FacultyDao;
import Dao.FacultyDaoImpl;
import Exceptions.FacultyException;
import Exceptions.InputException;
import JavaBean.Faculty;
import custom.ConsoleColors;

public class Usecase_searchFacultyById {

		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println(ConsoleColors.CYAN+"Enter First facultyId of Faculty"+ConsoleColors.RESET);
			int facultyId = sc.nextInt();

			FacultyDao dao = new FacultyDaoImpl();
			
			try {
				Faculty fat= dao.searchFacultyById(facultyId);
			
				System.out.println("facultyId is :"+fat);
				
			}catch (FacultyException e) {
				System.out.println(e.getMessage());
			}
			
		
	
	}
}
