package cn.internship.service;

import java.util.List;

import cn.internship.entity.Teacher;

/**
 * 教师业务层接口
 * @author MengHan
 */
public interface TeacherService {

	public Teacher login(String tno,String password);
	
	public void logout();
	
	public Teacher get(Integer teacherId);

	//修改密码
	public void updatePwd(Teacher teacher);
	
	public void saveTeacher(Teacher teacher);
	
	public List<Teacher> getAll();
	
	public void deleteTeacher(Integer id);
	
	public void updateTeacher(Teacher teacher);
}