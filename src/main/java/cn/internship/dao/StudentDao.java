package cn.internship.dao;

import cn.internship.entity.Student;

/**
 * 学生持久层接口
 * @author dreamlate
 */
public interface StudentDao{

	//通过主键查找学生
	public Student get(Integer id);
	
	//通过学号查找学生
	public Student get(String studentId);
	
}
