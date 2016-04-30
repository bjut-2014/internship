package cn.internship.service.impl;

import cn.internship.dao.HomeworkDao;
import cn.internship.entity.Homework;
import cn.internship.service.HomeworkService;

/**
 * 上传作业业务层操作
 * @author MengHan
 *
 */
public class HomeworkServiceImpl implements HomeworkService{

	private HomeworkDao homeworkDao;
	
	@Override
	public void uploadHomework(Homework homework) {
		homeworkDao.save(homework);
	}

	@Override
	public Homework get(Integer homeworkId) {
		return homeworkDao.get(homeworkId);
	}

	@Override
	public Homework get(Integer studentId, Integer courseId) {
		return homeworkDao.get(studentId, courseId);
	}

	public HomeworkDao getHomeworkDao() {
		return homeworkDao;
	}

	public void setHomeworkDao(HomeworkDao homeworkDao) {
		this.homeworkDao = homeworkDao;
	}
	
	//----------------------------get与set方法-------------------------
	

}
