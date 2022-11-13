package Adamin_UseCases;

import java.util.Scanner;


import Dao.AdminDao;
import Dao.AdminDaoImpl;
import Exceptions.AdminException;
import JavaBean.Admin;

public class registerAdmin {
	
	public static void main(String[] args) {
Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Admin AdminId:");
		int AdminId= sc.nextInt();

		System.out.println("Enter Admin username :");
		String username= sc.next();
		
		System.out.println("Enter Admin Address :");
		String address= sc.next();

		System.out.println("Enter Admin email :");
		String email= sc.next();
		
		System.out.println("Enter Password :");
		String password= sc.next();

		
		Admin adm= new Admin();
		adm.setAdminId(AdminId);
		adm.setUsername(username);
		adm.setAddress(address);
		adm.setEmail(email);
		adm.setPassword(password);
		
		AdminDao dao = new AdminDaoImpl();
		
		try {
		String result= dao.registerAdmin(adm);
		
		System.out.println(result);
		
		
		}catch (AdminException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
	
	
	
	
	
	
	
	



