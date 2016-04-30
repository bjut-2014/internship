package cn.internship.dao;

import cn.internship.entity.Teacher;

/**
 * 教师类持久层接口
 * @author MengHan
 */
public interface TeacherDao {

	public Teacher get(String tno,String password);
	
	public Teacher get(Integer teacherId);
	
}
