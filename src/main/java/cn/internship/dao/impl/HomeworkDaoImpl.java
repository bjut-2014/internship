package cn.internship.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.internship.dao.HomeworkDao;
import cn.internship.entity.Homework;

/**
 * 上传作业持久层操作
 * @author MengHan
 */
public class HomeworkDaoImpl extends HibernateDaoSupport implements HomeworkDao{

	//上传作业或者重新上传作业
	@Override
	public void save(Homework homework) {
		getHibernateTemplate().saveOrUpdate(homework);
	}

	//通过主键获得作业
	@Override
	public Homework get(Integer homeworkId) {
		return getHibernateTemplate().get(Homework.class, homeworkId);
	}

	//通过学生主键和课程主键获得作业
	@Override
	public Homework get(Integer studentId, Integer courseId) {
		String hql = "from Homework h where h.studentId = "+studentId+" and h.courseId = "+courseId;
		List<Homework> list = (List<Homework>) getHibernateTemplate().find(hql);
		if(list==null||list.size()==0){
			return null;
		}
		return list.get(0);
	}

	//获得指定课程下的所有作业
	@Override
	public List<Homework> getByCourse(Integer courseId) {
		String hql = "from Homework h where h.courseId = "+courseId;
		List<Homework> list = (List<Homework>) getHibernateTemplate().find(hql);
		return list;
	}

}
