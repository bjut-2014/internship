package cn.internship.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.internship.dao.WeeklyPlanDao;
import cn.internship.entity.WeeklyPlan;

/**
 * 学生周报持久层操作
 * @author dreamlate
 */
public class WeeklyPlanDaoImpl extends HibernateDaoSupport implements WeeklyPlanDao {

	//通过主键找到指定周报
	public WeeklyPlan get(Integer id) {
		return getHibernateTemplate().get(WeeklyPlan.class, id);
	}

	//通过主键删除指定周报
	public void delete(Integer id) {
		WeeklyPlan weeklyPlan = get(id);
		getHibernateTemplate().delete(weeklyPlan);
	}

	//通过主键修改指定周报
	public void update(WeeklyPlan weeklyPlan) {
		getHibernateTemplate().update(weeklyPlan);
	}

	//增加一条周报数据
	public void save(WeeklyPlan weeklyPlan) {
		getHibernateTemplate().save(weeklyPlan);
	}
		
	//获得所有周报
	public List<WeeklyPlan> getAll(String studentId) {
		String hql = "from WeeklyPlan wp where wp.studentId = ?";
		Object[] values = {studentId};
		List<WeeklyPlan> list = (List<WeeklyPlan>) getHibernateTemplate().find(hql,values);
		return list;
	}


}
