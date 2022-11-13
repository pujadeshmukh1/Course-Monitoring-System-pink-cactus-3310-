package Batch;

import java.util.Scanner;

import Dao.BatchDao;
import Dao.BatchDaoImpl;
import Exceptions.BatchException;
import Exceptions.InputException;
import JavaBean.Batch;
import custom.ConsoleColors;

public class SearchBatchById {

public static void main(String[] args) throws InputException {
		
	Scanner sc = new Scanner(System.in);
	
	System.out.println(ConsoleColors.CYAN+"Enter First batchId of Batch"+ConsoleColors.RESET);
	int batchId = sc.nextInt();

	BatchDao dao = new BatchDaoImpl();
	
	try {
		Batch fat= dao.SearchBatchById(batchId);
	
		System.out.println("facultyId is :"+fat);
		
	}catch (BatchException e) {
		System.out.println(e.getMessage());
	}
		
	}

}
