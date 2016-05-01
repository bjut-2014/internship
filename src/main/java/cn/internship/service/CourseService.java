package cn.internship.service;

import java.util.List;

import cn.internship.entity.Course;

/**
 * 课程业务层接口
 * @author dreamlate
 */
public interface CourseService {
	public List<Course> getAll();

	public List<Course> getBySno(Integer studentId);

	public List<Course> getByTno(Integer teacherId);
	
	public Integer getCourseScore(Integer studentId,Integer courseId);

	public Course get(Integer courseId);
}
