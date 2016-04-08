package cn.internship.dao;

import cn.internship.entity.Student;

/**
 * 学生持久层接口
 * @author dreamlate
 */
public interface StudentDao{

	//通过学号、密码查找学生
	public Student findStudentByUP(String username,String password);
	
	
	
}
