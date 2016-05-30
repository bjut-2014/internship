package cn.internship.dao;

import java.util.List;

import cn.internship.entity.Teacher;

/**
 * 教师类持久层接口
 * @author MengHan
 */
public interface TeacherDao {

	public Teacher get(String tno,String password);
	
	public Teacher get(Integer teacherId);
	
	public Teacher get(String tno);
	
	//更新用户信息
	public void updateTeacher(Teacher teacher);
	
	public void addTeacher(Teacher teacher);
	
	public List<Teacher> getAll();
	
	public void deleteTeacher(Integer id);
}
