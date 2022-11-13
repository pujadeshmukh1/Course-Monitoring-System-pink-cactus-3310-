package CoursePlan;


import java.util.Scanner;

import Dao.CourseplanDao;

import Dao.CourseplanDaoImpl;

import Exceptions.CoursPlanException;
import JavaBean.Courseplan;



public class addCoursePlan {

		public static void main(String[] args) throws CoursPlanException {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter planId CoursePlan : ");
			int planId = sc.nextInt();
			
			System.out.println("Enter batchId CoursePlan : ");
			int batchId = sc.nextInt();
			
			System.out.println("Enter daynumber CoursePlan : ");
			int daynumber = sc.nextInt();
			
			System.out.println("Enter topic CoursePlan : ");
			String topic = sc.next();
			
		
			
			System.out.println("Enter status CoursePlan : ");
			String status = sc.next();
			
			Courseplan c= new Courseplan();
			
			c.setPlanId(planId);
			
			c.setBatchId(batchId);
			
			c.setDaynumber(daynumber);
			
			c.setTopic(topic);
			
	        c.setStatus(status);
			
			CourseplanDao dao = new CourseplanDaoImpl();
			
			try {
			String result= dao.addCourseplan(c);
			
			System.out.println(result);
			
			
			}catch (CoursPlanException e) {
				System.out.println(e.getMessage());
			}
			
		}
	
		
	
				
		
		
		}
		
	
	

