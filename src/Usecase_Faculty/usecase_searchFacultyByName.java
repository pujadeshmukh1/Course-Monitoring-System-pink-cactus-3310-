package Usecase_Faculty;

import java.util.List;
import java.util.Scanner;
import Dao.FacultyDao;
import Dao.FacultyDaoImpl;
import Exceptions.FacultyException;
import JavaBean.Faculty;
import custom.ConsoleColors;

public class usecase_searchFacultyByName {


	public static void main(String[] args) {
		
        Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter facultyname to Get details  :");
		String facultyname= sc.next();

		
		FacultyDao dao = new FacultyDaoImpl();
		
		try {
		List<Faculty> dtos= dao.searchFacultyByName(facultyname);
		
		dtos.forEach(dto -> System.out.println(dto));
		
		
		
		}catch(FacultyException c) {
			System.out.println(c.getMessage());
		}
		

	}
	

}
	
	

	


