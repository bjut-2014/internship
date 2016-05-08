package cn.internship.service;

import java.util.List;

import cn.internship.entity.Student;

/**
 * 学生业务层接口
 * @author dreamlate
 */
public interface StudentService {

	//登陆
	public Student login(String sno,String password);
	
	public void logout();
	
	//通过主键获取学生信息
	public Student get(Integer id);
	
	//通过学号获取学生信息
	public Student get(String sno);

	//修改密码
	public void updatePwd(Student student);
	
	//获取所有学生信息
	public List<Student> getAllStudents();
	
	//添加学生信息
	public void addStudent(Student student);
	
	//更新学生信息
	public void updateStudent(Student student);
	
	//根据主键删除学生信息
	public void deleteStudent(Integer id);
}
