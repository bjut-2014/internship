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
	
	//登陆
	@Override
	public Student login(String sno, String password) {
		return studentDao.get(sno, password);
	}

	//获得指定学号的学生
	@Override
	public Student get(Integer id){
		return studentDao.get(id);
	}
	
	//------------------------------------------get与set方法-----------------------------------------------------------------
	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

}
