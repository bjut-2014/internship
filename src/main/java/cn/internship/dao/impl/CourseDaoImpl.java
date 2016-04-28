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
//		String hql = "select c from Course c join c.studentId s join s.";
		return null;
	}


	//获得某个教师的所有教授课程
	@Override
	public List<Course> getByTno(String tno) {
		// TODO Auto-generated method stub
		return null;
	}

}
