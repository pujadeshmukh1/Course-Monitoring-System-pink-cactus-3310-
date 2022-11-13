package Faculty_Login_usecases;



import java.util.Scanner;

import Dao.AdminDao;
import Dao.AdminDaoImpl;
import Dao.FacultyDao;
import Dao.FacultyDaoImpl;

import Exceptions.FacultyException;
import JavaBean.Faculty;

public class loginFaculty {

public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your Username : - ");
		String name = sc.next();
		
		System.out.println("Enter your password : - ");
		String password = sc.next();
		
		FacultyDao dao = new FacultyDaoImpl();
		 try {
			 Faculty ft= dao.loginFaculty(name, password);
			
		 	System.out.println("Welcome "+ft.getFacultyName());
		 	
		 		
		 
		 	
		 	
		 	
			}catch (FacultyException e) {
				System.out.println(e.getMessage());
			}
			
			
		
		
	}
	

}