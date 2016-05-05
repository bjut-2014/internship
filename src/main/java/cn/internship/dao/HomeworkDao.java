package cn.internship.dao;

import java.util.List;

import cn.internship.entity.Homework;

/**
 * 上传作业持久层接口
 * @author MengHan
 */
public interface HomeworkDao {

	public void save(Homework homework);
	
	public Homework get(Integer homeworkId);
	
	public Homework get(Integer studentId,Integer courseId);
	
	public List<Homework> getByCourse(Integer courseId);

}
