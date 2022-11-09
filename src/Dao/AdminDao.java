package Dao;

import Exceptions.AdminExcep;

public interface AdminDao {
	public boolean LoginAdmin(String username , String password) throws AdminExcep;
}
