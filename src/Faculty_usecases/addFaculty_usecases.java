package Faculty_usecases;




import java.util.Scanner;

import Dao.FacultyDao;
import Dao.FacultyDaoImpl;
import Exceptions.FacultyException;
import Exceptions.InputException;
import JavaBean.Faculty;
import custom.ConsoleColors;

public class addFaculty_usecases {
	
	public static void main(String[] args) throws InputException{
		
		try {
		
			//@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			System.out.println(ConsoleColors.CYAN+"Enter First facultyId of Faculty"+ConsoleColors.RESET);
			int facultyId = sc.nextInt();
			
			System.out.println(ConsoleColors.CYAN+"Enter First Name of Faculty"+ConsoleColors.RESET);
			String facultyName = sc.next();
				
			sc.nextLine();
			System.out.println(ConsoleColors.CYAN+"Enter Faculty facultyAddress"+ConsoleColors.RESET);
			String facultyAddress = sc.nextLine();
			
			System.out.println(ConsoleColors.CYAN+"Enter Faculty Mobile No."+ConsoleColors.RESET);
			String mobile = sc.next();
			
			System.out.println(ConsoleColors.CYAN+"Enter Faculty Email"+ConsoleColors.RESET);
			String email = sc.next();
			
			
			System.out.println(ConsoleColors.CYAN+"Enter Faculty username"+ConsoleColors.RESET);
			String username = sc.next();
			
			System.out.println(ConsoleColors.CYAN+"Enter Faculty password"+ConsoleColors.RESET);
			String password = sc.next();
			
			
			FacultyDao dao = new FacultyDaoImpl();
			
			Faculty faculty = new Faculty(facultyId, facultyName, facultyAddress,  mobile, email,username,  password);
			
			String result = dao.addFaculty(faculty);
			
			System.out.println(result);
	
				
		
		
		}catch(Exception e) {
			throw new InputException(ConsoleColors.RED+"Please Enter Right Input"+ConsoleColors.RESET);
			
		}
		
	}
	
}
