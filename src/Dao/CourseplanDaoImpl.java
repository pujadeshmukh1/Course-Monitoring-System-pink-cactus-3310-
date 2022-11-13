package Dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Exceptions.CoursPlanException;
import JavaBean.Courseplan;
import Utility.DBconn;


public class CourseplanDaoImpl implements CourseplanDao{

	@Override
	public String addCourseplan(Courseplan courseplan) throws CoursPlanException {
      
		String result = "Not Inserted..";
		
		try(Connection conn= DBconn.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("insert into courseplanss(planId, batchId, daynumber, topic, status) values(?,?,?,?,?)");

			ps.setInt(1, courseplan.getPlanId());
			ps.setString(2, courseplan.getBatchId());
			ps.setInt(3, courseplan.getDaynumber());
			ps.setString(4, courseplan.getTopic());
			
			ps.setString(5, courseplan.getStatus());
			
			
			int x= ps.executeUpdate();
			
			if(x >0)
				result = "Courseplan add Sucessfully..";
				
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CoursPlanException(e.getMessage());
		}
		
		

		return result;
	}

	@Override
	public String updateStatus(String batchId, int dayNo) throws CoursPlanException {
		// TODO Auto-generated method stub
		return null;
	}

	
	


	
}