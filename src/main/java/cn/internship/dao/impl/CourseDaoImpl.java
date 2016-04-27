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

	@Override
	public Course get(String tno) {
		return null;
	}

	@Override
	public Course get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
