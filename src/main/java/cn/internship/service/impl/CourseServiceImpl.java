package cn.internship.service.impl;

import java.util.List;

import cn.internship.dao.CourseDao;
import cn.internship.entity.Course;
import cn.internship.service.CourseService;

/**
 * 课程业务层操作
 * @author dreamlate
 */
public class CourseServiceImpl implements CourseService{

	private CourseDao courseDao;
	
	//获得所有课程
	@Override
	public List<Course> getAll() {
		return courseDao.getAll();
	}

	//通过学生学号获得部分课程
	@Override
	public List<Course> getBySno(Integer studentId) {
		return courseDao.getBySno(studentId);
	}

	//通过教师职工号获得部分课程
	@Override
	public List<Course> getByTno(Integer teacherId) {
		return courseDao.getByTno(teacherId);
	}

	@Override
	public Integer getCourseScore(Integer studentId, Integer courseId) {
		return courseDao.getCourseScore(studentId, courseId);
	}
	
	@Override
	public Course get(Integer courseId) {
		return courseDao.get(courseId);
	}
	
	@Override
	public void saveCourse(Course course) {
		courseDao.addCourse(course);
	}
	
	@Override
	public void deleteCourse(Integer id) {
		courseDao.deleteCourse(id);
	}

	@Override
	public void updateCourse(Course course) {
		courseDao.updateCourse(course);
	}

	
	//-----------------------------------get与set方法--------------------------------------------
	
	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	

}
