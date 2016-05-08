package cn.internship.dao;

import java.util.List;

import cn.internship.entity.Student;

/**
 * 学生持久层接口
 * @author dreamlate
 */
public interface StudentDao {

	//通过学号密码查找学生
	public Student get(String sno,String password);
	
	//通过主键查找学生
	public Student get(Integer id);

	//通过学号查找学生
	public Student get(String sno);

	//更新用户信息
	public void updateStudent(Student student);
	
	//获取所有学生信息
	public List<Student> getAllStudents();
	
	//添加学生信息
	public void addStudent(Student student);
	
	//通过主键删除学生信息
	public void deleteStudent(Integer id);
}
