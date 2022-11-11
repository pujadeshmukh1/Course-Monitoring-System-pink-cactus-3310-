package Dao;

import Exceptions.BatchException;
import JavaBean.Batch;

public interface BatchDao {

	public String addBatch(Batch batch) throws BatchException;
	
	public Batch searchBatchById(String id) throws BatchException;
	
}
