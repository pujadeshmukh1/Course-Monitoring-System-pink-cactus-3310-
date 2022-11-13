package Dao;




import java.util.List;

import Exceptions.BatchException;
import JavaBean.Batch;


public interface BatchDao {
	
	public String addBatch(Batch batch) throws BatchException;
	
	public List<Batch> allBatch() throws BatchException;
	
	public List<Batch> searchBatchByName(String name) throws BatchException;

	public Batch SearchBatchById(int batchId) throws BatchException;
	
	//public List<Batch> allBatch() throws BatchException;
	
	//public String updateBatch (String str, String set, String batchId) throws BatchException;
	
	//public String deleteBatch(String batchId) throws BatchException;
	
	//public String allocateFaculty(int fName, String batchId) throws BatchException;
	
	//public List<Report> generateReport() throws BatchException;
}