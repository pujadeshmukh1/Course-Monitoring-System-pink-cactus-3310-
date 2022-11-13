package Batch;




import java.util.Scanner;

import Dao.BatchDao;
import Dao.BatchDaoImpl;
import Exceptions.BatchException;
import Exceptions.InputException;
import JavaBean.Batch;
import custom.ConsoleColors;

public class BatchDaoUSeCases {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws InputException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(ConsoleColors.CYAN+"Enter batchId of the Batch"+ConsoleColors.RESET);
		int batchId = sc.nextInt();
		
		System.out.println(ConsoleColors.CYAN+"Enter courseId of the Batch"+ConsoleColors.RESET);
		int courseId = sc.nextInt();
		
		System.out.println(ConsoleColors.CYAN+"Enter facultyId of the Batch"+ConsoleColors.RESET);
		int facultyId = sc.nextInt();
		
		System.out.println(ConsoleColors.CYAN+"Enter numberofStudents of the Batch"+ConsoleColors.RESET);
		int numberofStudents = sc.nextInt();
	
		
		System.out.println(ConsoleColors.CYAN+"Enter Start date of the Batch(YYYY-MM-DD)."+ConsoleColors.RESET);
		String batchstartDate = sc.next();
		
		sc.nextLine();
		System.out.println(ConsoleColors.CYAN+"Enter Batch Duration"+ConsoleColors.RESET);
		String duration = sc.nextLine();
		
		Batch batch = new Batch(batchId,courseId,facultyId,numberofStudents, batchstartDate, duration);
		
		BatchDao dao1 = new BatchDaoImpl();
	
		try {
			String str = dao1.addBatch(batch);
		
			System.out.println(str);
			
			
		} catch (BatchException e) {

			System.out.println(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
		
	}catch(Exception e) {
		throw new InputException(ConsoleColors.RED+"Please Enter Right Input"+ConsoleColors.RESET);
	}
	}
}

