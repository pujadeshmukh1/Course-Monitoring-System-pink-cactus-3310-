//package Usecase_Faculty;
//
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
//import Dao.FacultyDao;
//import Dao.FacultyDaoImpl;
//import Exceptions.FacultyException;
//import custom.ConsoleColors;
//
//public class Usecase_updateFacultyDetails {
//	
//	try private static final int facultyId = 0;
//	{
//		@SuppressWarnings("resource")
//		Scanner sc = new Scanner(System.in);
//		
//		boolean flag = true;
//		boolean flag2 = true;
//		
//		while(flag) {
//			
//			String str = "";
//
//			
//			while(true) {	
//				
//				System.out.println(ConsoleColors.CYAN+"What do you want to update?");
//				
//				System.out.println("1. First Name");
//				
//				System.out.println("3. Address");
//				
//				System.out.println("6. Mobile");
//				
//				System.out.println("7. Email");
//				
//				System.out.println("8. Username");
//				
//				System.out.println("9. password");
//				
//				System.out.println("10. Close" +ConsoleColors.RESET);
//				
//				int ch = sc.nextInt();
//				
//				if(ch == 8) {
//					flag = false;
//					flag2 = false;
//					break;
//					
//				}else if(ch== 9) {
//					System.out.println(ConsoleColors.BANANA_YELLOW+"See You Soon..."+ConsoleColors.RESET);
//					System.exit(0);	
//				}
//			
//				if(ch == 1) {
//					str = "facultyname";
//					break;
//				}else if(ch == 2) {
//					str = "facultyAddress";
//					break;
//				}else if(ch == 3) {
//					str = "mobile";
//					break;
//				}else if(ch == 4) {
//					str = "email";
//					break;
//				}else if(ch == 5) {
//					str = "email";
//					break;
//				}
//				else {
//					System.out.println(ConsoleColors.RED+"Wrong Input Try Again"+ConsoleColors.RESET);
//				}
//			}
//			
//			if(flag2) {
//				sc.nextLine();
//				System.out.println("Enter New Entry :");
//				String set = sc.nextLine();
//				
//				FacultyDao dao = new FacultyDaoImpl();
//				
//				String result;
//				try {
//				
//					result = dao.updateFacultyDetails(str, set, facultyId);
//					System.out.println();
//					System.out.println(result);
//					System.out.println();
//					
//				} catch (FacultyException e) {
//				
//					System.out.println(ConsoleColors.RED_BACKGROUND+ e.getMessage()+ConsoleColors.RESET);
//				
//				}
//				
//			}
//			
//			
//			while(flag2) {
//				System.out.println(ConsoleColors.CYAN+"Want to update anything else?(y/n)"+ConsoleColors.RESET);
//				String choice = sc.next();
//				
//				if(choice.equalsIgnoreCase("y")) {
//					break;
//				}else if(choice.equalsIgnoreCase("n")){
//					flag = false;
//					break;
//				}else {
//					System.out.println();
//					System.out.println(ConsoleColors.RED+"Wrong Input...!"+ConsoleColors.RESET);
//					System.out.println();
//				}
//			}
//		}
//		
//	}catch(InputMismatchException e) {
//		System.out.println();
//		System.out.println(ConsoleColors.RED+"Wrong Input Try Again!"+ConsoleColors.RESET);
//		System.out.println();
//		UpdateById(facultyId);
//	}
//	private void UpdateById(int facultyid2) {
//		// TODO Auto-generated method stub
//		
//	}
//
//}
//
//	
//
//
