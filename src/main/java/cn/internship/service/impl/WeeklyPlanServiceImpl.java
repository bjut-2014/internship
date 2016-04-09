package cn.internship.service.impl;

import java.util.List;

import cn.internship.dao.WeeklyPlanDao;
import cn.internship.entity.WeeklyPlan;
import cn.internship.service.WeeklyPlanService;

/**
 * 学生周报业务层操作
 * @author dreamlate
 */
public class WeeklyPlanServiceImpl implements WeeklyPlanService{

	WeeklyPlanDao weeklyPlanDao;
	
	//通过主键找到指定周报
	public WeeklyPlan get(Integer id) {
		return weeklyPlanDao.get(id);
	}

	//通过主键删除指定周报
	public void delete(Integer id) {
		weeklyPlanDao.delete(id);
	}

	//通过主键修改指定周报
	public void update(WeeklyPlan weeklyPlan) {
		weeklyPlanDao.update(weeklyPlan);
	}

	//增加一条周报数据
	public void save(WeeklyPlan weeklyPlan) {
		weeklyPlanDao.save(weeklyPlan);
	}

	//获得所有周报
	public List<WeeklyPlan> getAll(String studentId) {
		return weeklyPlanDao.getAll(studentId);
	}

	public WeeklyPlanDao getWeeklyPlanDao() {
		return weeklyPlanDao;
	}

	public void setWeeklyPlanDao(WeeklyPlanDao weeklyPlanDao) {
		this.weeklyPlanDao = weeklyPlanDao;
	}

	
	
}
