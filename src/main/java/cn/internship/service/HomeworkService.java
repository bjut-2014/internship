package cn.internship.service;

import cn.internship.entity.Homework;

/**
 * 上传作业业务层接口
 * @author MengHan
 */
public interface HomeworkService {

	public void uploadHomework(Homework homework);
	
	public Homework get(Integer homeworkId);
	
	public Homework get(Integer studentId,Integer courseId);
	
}
