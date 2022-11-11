package Usecase_Faculty;

import java.util.List;


import Dao.FacultyDao;
import Dao.FacultyDaoImpl;

import Exceptions.FacultyException;
import JavaBean.Faculty;

import custom.ConsoleColors;

public class getAllFacultyDetails_useCases {

	public static void main(String[] args) throws FacultyException{
		
		
		FacultyDao dao = new FacultyDaoImpl();
			
			try {
			 	List<Faculty> c = dao.getAllFacultyDetails();
			 	
			 	c.forEach(s ->{
			 		System.out.println();
			 		
                    System.out.println(ConsoleColors.ORANGE+"facultyId: "+ s.getFacultyId());
			 		
                    System.out.println("faculty Name : " + s.getFacultyName());
					
                    System.out.println("faculty Address : " + s.getFacultyAddress());
					
                    System.out.println("faculty mobile : " + s.getMobile());
					
                    System.out.println("faculty email : " + s.getEmail());
					
                    System.out.println("faculty username : " + s.getUsername());
					
                    System.out.println("faculty password : " + s.getPassword());
					
					
					System.out.println("------------------------------"+ConsoleColors.RESET);
			 		
			 	});
				 	
			 	System.out.println();
			}
			catch (FacultyException e) {
				System.out.println(e.getMessage());
			}
			
			
		}
		
	
	
}
