package cn.internship.service.Impl;

import cn.internship.dao.StudentDao;
import cn.internship.entity.Student;
import cn.internship.service.StudentService;

public class StudentServiceImpl implements StudentService{

	private StudentDao studentDao;

	//登陆
	public Student login(String username, String password) {
		return studentDao.findStudentByUP(username, password);
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
}
