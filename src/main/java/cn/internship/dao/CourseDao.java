package cn.internship.dao;

import java.util.List;

import cn.internship.entity.Course;

/**
 * 课程持久层接口
 * @author dreamlate
 */
public interface CourseDao {

	public List<Course> getAll();
	
	public List<Course> getBySno(Integer studentId);
	
	public List<Course> getByTno(Integer teacherId);
	
	public Course get(Integer id);
	
	public Integer getCourseScore(Integer studentId,Integer courseId);
	
	public void addCourse(Course course);
	
	public void deleteCourse(Integer id);
	
	public void updateCourse(Course course);
}
