package cn.internship.service.impl;

import java.util.List;

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

	@Override
	public List<Homework> getByCourse(Integer courseId) {
		return homeworkDao.getByCourse(courseId);
	}
	
	@Override
	public void saveHomework(Homework homework) {
		homeworkDao.save(homework);
	}
	
	
	//----------------------------get与set方法-------------------------
	
	public HomeworkDao getHomeworkDao() {
		return homeworkDao;
	}
	
	public void setHomeworkDao(HomeworkDao homeworkDao) {
		this.homeworkDao = homeworkDao;
	}

	
	

}
