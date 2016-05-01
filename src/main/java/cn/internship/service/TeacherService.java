package cn.internship.service;

import cn.internship.entity.Teacher;

/**
 * 教师业务层接口
 * @author MengHan
 */
public interface TeacherService {

	public Teacher login(String tno,String password);
	
	public void logout();
	
	public Teacher get(Integer teacherId);
	
}
