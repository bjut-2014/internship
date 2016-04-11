package cn.internship.service;

import java.util.List;

import cn.internship.entity.WeeklyPlan;

/**
 * 学生周报业务层接口
 * 
 * @author dreamlate
 */
public interface WeeklyPlanService {

	// 通过主键找到指定周报
	public WeeklyPlan get(Integer id);

	// 通过主键删除指定周报
	public void delete(Integer id);

	// 通过主键修改指定周报
	public void update(WeeklyPlan weeklyPlan);

	// 增加一条周报数据
	public void save(WeeklyPlan weeklyPlan);

	// 获得所有周报
	public List<WeeklyPlan> getAll(String studentId);

}
