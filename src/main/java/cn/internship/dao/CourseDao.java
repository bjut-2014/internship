package cn.internship.dao;

import java.util.List;

import cn.internship.entity.Course;

/**
 * 课程持久层接口
 * @author dreamlate
 */
public interface CourseDao {

	public List<Course> getAll();
	
	public Course get(String tno);
	
	public Course get(Integer id);
	
}
