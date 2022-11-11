package Dao;

import java.util.List;

import Exceptions.FacultyException;
import JavaBean.Faculty;

public interface FacultyDao {
  
	public String addFaculty(Faculty faculty) throws FacultyException;
	
	public List<Faculty> searchFacultyByName(String facultyName) throws FacultyException;
	
     public List<Faculty> getAllFacultyDetails()throws FacultyException;
	
	public Faculty searchFacultyById(int facultyId) throws FacultyException;
	
	public String updateFacultyDetails(String str, String set, int facultyId) throws FacultyException;
	
}
