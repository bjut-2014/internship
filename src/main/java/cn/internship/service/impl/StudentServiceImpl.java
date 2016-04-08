package cn.internship.service.impl;

import cn.internship.dao.StudentDao;
import cn.internship.entity.Student;
import cn.internship.service.StudentService;

/**
 * 学生业务层操作
 * @author dreamlate
 */
public class StudentServiceImpl implements StudentService{

	private StudentDao studentDao;

	//根据学号查找学生
	public Student get(String studentId) {
		return studentDao.get(studentId);
	}
	
	//-------------------------------------------set与get方法-------------------------------------------------

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	
	
}
