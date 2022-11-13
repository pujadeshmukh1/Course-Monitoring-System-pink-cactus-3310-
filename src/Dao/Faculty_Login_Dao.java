package Dao;




import Exceptions.FacultyException;
import JavaBean.Faculty;


public interface Faculty_Login_Dao {
	public String registerFaculty(Faculty faculty)throws FacultyException;
	
	public Faculty loginFaculty(String username, String password) throws FacultyException;
}

