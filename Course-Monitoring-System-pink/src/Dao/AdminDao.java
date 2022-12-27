package Dao;

import Exceptions.AdminException;

public interface AdminDao {

	public boolean LoginAdmim(String username,String password)throws AdminException;
	
}
