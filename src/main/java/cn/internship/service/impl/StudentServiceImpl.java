package cn.internship.service.impl;

import java.util.List;

import cn.internship.dao.StudentDao;
import cn.internship.entity.Student;
import cn.internship.service.StudentService;
import cn.internship.utils.UserInfo;

/**
 * 学生业务层操作
 * @author dreamlate
 */
public class StudentServiceImpl implements StudentService{

	private StudentDao studentDao;
	
	//登陆
	@Override
	public Student login(String sno, String password) {
		Student student = studentDao.get(sno, password);
		//设置全局用户信息
        if (student != null) {
            UserInfo.setInfo(student.getName(), student.getSno());
        }
		return student;
	}

	//注销
	@Override
	public void logout(){
		//方法体为空，主要为了aop框架能检测到注销事件
	}
	
	//获得指定学号的学生
	@Override
	public Student get(Integer id){
		return studentDao.get(id);
	}

	@Override
	//修改密码
	public void updatePwd(Student student) {
		studentDao.updateStudent(student);
	}
	
	//根据学号查找学生
	public Student get(String sno){
		return studentDao.get(sno);
	}
	
	
	@Override
	//获取所有的学生信息
	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}

	@Override
	//添加学生信息
	public void addStudent(Student student) {
		studentDao.addStudent(student);
	}

	@Override
	//更新学生信息
	public void updateStudent(Student student) {
		studentDao.updateStudent(student);
	}

	@Override
	//删除学生信息
	public void deleteStudent(Integer id) {
		studentDao.deleteStudent(id);
	}
	
	
	
	//------------------------------------------get与set方法-----------------------------------------------------------------
	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

}
