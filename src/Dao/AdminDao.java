package Dao;


import Exceptions.AdminException;
import JavaBean.Admin;

public interface AdminDao {
    
	public String registerAdmin(Admin admin)throws AdminException;
	
	public Admin LoginAdmin(String username, String password)throws AdminException;
	
	
}




