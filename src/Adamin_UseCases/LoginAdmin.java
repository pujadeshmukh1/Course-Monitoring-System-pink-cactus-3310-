package Adamin_UseCases;

import java.util.Scanner;


import Dao.AdminDao;
import Dao.AdminDaoImpl;
import Exceptions.AdminException;
import JavaBean.Admin;

public class LoginAdmin {
	
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your Username : - ");
		String username = sc.next();
		
		System.out.println("Enter your password : - ");
		String password = sc.next();
		
		 AdminDao dao = new AdminDaoImpl();
		 try {
			 Admin adm= dao.LoginAdmin(username, password);
			
		 	System.out.println("Welcome "+adm.getUsername());
		 	
		 		
		 
		 	
		 	
		 	
			}catch (AdminException e) {
				System.out.println(e.getMessage());
			}
			
			
		
		
	}
	

}