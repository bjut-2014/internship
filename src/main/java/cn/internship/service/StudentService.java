package cn.internship.service;

import cn.internship.entity.Student;

/**
 * 学生业务层接口
 * @author dreamlate
 */
public interface StudentService {

	//根据学号查找学生
	public Student get(String studentId);
	
}
