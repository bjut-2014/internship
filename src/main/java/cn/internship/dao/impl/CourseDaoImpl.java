package cn.internship.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import cn.internship.dao.CourseDao;
import cn.internship.entity.Course;

/**
 * 课程持久层操作
 * @author dreamlate
 */
public class CourseDaoImpl extends HibernateDaoSupport implements CourseDao{

	//获得所有课程
	@Override
	public List<Course> getAll() {
		String hql = "from Course";
		return (List<Course>) getHibernateTemplate().find(hql);
	}


	//根据主键获得指定课程
	@Override
	public Course get(Integer id) {
		return getHibernateTemplate().get(Course.class, id);
	}


	//获得某个学生的所有必修课程
	@Override
	public List<Course> getBySno(Integer studentId) {
//		String sql = "SELECT * FROM course c WHERE c.courseId IN ( SELECT sc.courseId FROM student_course sc WHERE sc.studentId =:studentId";
		String hql = "select s.courses from Student s where s.studentId =  :studentId";
		String[] params = new String[]{"studentId"};
		Integer[] values = new Integer[]{studentId};
		List<Course> list = (List<Course>) getHibernateTemplate().findByNamedParam(hql, params, values);
		return list;
	}


	//获得某个教师的所有教授课程
	@Override
	public List<Course> getByTno(Integer teacherId) {
		String hql = "select t.courses from Teacher t where t.teacherId =  :teacherId";
		String[] params = new String[]{"teacherId"};
		Integer[] values = new Integer[]{teacherId};
		List<Course> list = (List<Course>) getHibernateTemplate().findByNamedParam(hql, params, values);
		return list;
	}

}
