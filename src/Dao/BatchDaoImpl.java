package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import Exceptions.BatchException;
import JavaBean.Batch;
import Utility.DBconn;
import custom.ConsoleColors;

public class BatchDaoImpl implements BatchDao{

	@Override
	public String addBatch(Batch batch) throws BatchException {
		
		String message = "Data not Insert";
		
		try (Connection conn = DBconn.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select courseName from course where courseId= ?");
			
			ps.setInt(1, batch.getCourseId());
			
			ResultSet rs = ps.executeQuery();
			
			String Name="";
			
			if(rs.next()) {
				Name= rs.getString("courseName");
				
			}
			else {
				throw new BatchException(ConsoleColors.RED_BACKGROUND+"Course Id does not exist."+ConsoleColors.RESET);
			}
			
			
           PreparedStatement ps1 = conn .prepareStatement("select count(courseId) from Batch where courseId = ?");
			
			ps1.setInt(1, batch.getCourseId());
			
			ResultSet rs1 = ps1.executeQuery();
			

			int count = 0;
			if(rs1.next()) {		
				count = rs1.getInt(1);
			}else {
				throw new BatchException(ConsoleColors.RED_BACKGROUND+"Course Id does not exist."+ConsoleColors.RESET);
			}
			
			count++;
			
			String text =  String.format("%03d", count);
			
			String batchId = Name + text;
			
			PreparedStatement ps2 = conn .prepareStatement("insert into Batch(batchId, courseId,facultyId, "+ " numberofStudents, batchstartDate, duration) values(?,?,?,?,?,?)");
			
			ps2.setInt(1, batch.getBatchId());
			ps2.setInt(2, batch.getCourseId());
			ps2.setInt(3, batch.getFacultyId());
			ps2.setInt(4,batch.getNumberofStudents());
			
			ps2.setString(5, batch.getBatchstartDate());
			ps2.setString(6, batch.getDuration());
			
			int x = ps2.executeUpdate();
			
			if(x>0) {		
				message = ConsoleColors.GREEN+"New Course Added Successfully.."+ConsoleColors.RESET;	
				
			}else {
				throw new BatchException(ConsoleColors.RED_BACKGROUND+"Duplicate Entry"+ConsoleColors.RESET);
				
			}
			
		}catch(SQLException e) {
			
			throw new BatchException(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
			
		}
		
		return message;
		
		
		
	}

	
	
	
	
	@Override
	public Batch searchBatchById(String id) throws BatchException {

		Batch batch = null;
		
		try(Connection conn = DBconn.provideConnection()){
			
			
			PreparedStatement ps = conn .prepareStatement("Select b.batchId, b.courseId, b.facultyId, f.facultyFname, b.noOfStudents, b.batchstartDate, b.duration from Batch b, Faculty f where b.facultyID = f.facultyID and b.batchId = ?");
			
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {		
				String bid = rs.getString("batchId");
				int cid = rs.getInt("courseId");
				int fid = rs.getInt("facultyId");
				String fName = rs.getString("facultyFname");
				int nos = rs.getInt("noOfStudents");
				Date date = rs.getDate("batchstartDate");
				String dur = rs.getString("duration");
				
				String sDate = date.toString();
				
				batch = new Batch(bid,cid,fid,fName,nos,sDate,dur);
				
			}else 
				throw new BatchException(ConsoleColors.RED_BACKGROUND+"Batch does not exist with this id "+ id + "."+ConsoleColors.RESET);
			
		}catch(SQLException e) {
			
			throw new BatchException(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
			
		}
		
		
		return batch;
		
		
	}

}
