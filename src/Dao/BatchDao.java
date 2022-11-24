package Dao;

import java.util.List;

import Exceptions.BatchException;
import Model_JavaBeen.Batch;
import Model_JavaBeen.Report;

public interface BatchDao {
    public String addBatch() throws BatchException;
	
	public List<Batch> allBatch() throws BatchException;
	
	public Batch searchBatchById() throws BatchException;

//	public String updateBatch () throws BatchException;
//	
	public String deleteBatch() throws BatchException;
	
	public String allocateFaculty() throws BatchException;
//	
   public List<Report> generateReport() throws BatchException;

	
}
