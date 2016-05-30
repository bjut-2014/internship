package cn.internship.service.impl;

import java.util.List;

import cn.internship.dao.TeacherDao;
import cn.internship.entity.Teacher;
import cn.internship.service.TeacherService;
import cn.internship.utils.UserInfo;

/**
 * 教师业务层操作
 * @author MengHan
 */
public class TeacherServiceImpl implements TeacherService{

	private TeacherDao teacherDao;
	
	//登录
	@Override
	public Teacher login(String tno, String password) {
		Teacher teacher = teacherDao.get(tno, password);
		//设置全局用户信息
		if(teacher!=null){
			UserInfo.setInfo(teacher.getName(), teacher.getTno());
		}
		return teacher;
	}

	//注销
	@Override
	public void logout() {
		//方法体为空，主要为了aop框架能检测到注销事件
	}

	@Override
	public void updatePwd(Teacher teacher) {
		teacherDao.updateTeacher(teacher);
	}
	@Override
	public Teacher get(Integer teacherId) {
		return teacherDao.get(teacherId);
	}

	@Override
	public void saveTeacher(Teacher teacher) {
		teacherDao.addTeacher(teacher);
	}

	@Override
	public List<Teacher> getAll() {
		return teacherDao.getAll();
	}

	@Override
	public void deleteTeacher(Integer id) {
		teacherDao.deleteTeacher(id);
	}
	
	@Override
	public void updateTeacher(Teacher teacher){
		teacherDao.updateTeacher(teacher);
	}
	
	@Override
	public Teacher get(String tno) {
		return teacherDao.get(tno);
	}

	
	//-----------------------get与set方法--------------------

	public TeacherDao getTeacherDao() {
		return teacherDao;
	}

	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	


}
