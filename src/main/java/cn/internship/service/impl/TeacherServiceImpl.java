package cn.internship.service.impl;

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

	public TeacherDao getTeacherDao() {
		return teacherDao;
	}

	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	//-----------------------get与set方法--------------------
	
	
}