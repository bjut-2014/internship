package cn.internship.service;

import cn.internship.entity.Student;

/**
 * 学生业务层接口
 * @author dreamlate
 */
public interface StudentService {

	//登陆
	public Student login(String sno,String password);
	
}
