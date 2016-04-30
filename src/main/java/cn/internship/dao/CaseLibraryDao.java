package cn.internship.dao;

import java.util.List;

import cn.internship.entity.Course;

/**
 * 案例库持久层接口
 * @author MengHan
 */
public interface CaseLibraryDao {

	public List<Course> getAll(Integer courseId);
	
	public Course get(Integer id);
	
}
