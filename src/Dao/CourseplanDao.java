package Dao;

import Exceptions.CoursPlanException;
import JavaBean.Courseplan;

public interface CourseplanDao {

	public String addCourseplan(Courseplan courseplan) throws CoursPlanException;

	public String updateStatus(String batchId, int dayNo) throws CoursPlanException;
}
