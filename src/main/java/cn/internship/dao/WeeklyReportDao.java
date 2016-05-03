package cn.internship.dao;

import java.util.List;

import cn.internship.entity.WeeklyReport;

public interface WeeklyReportDao {
	// 通过主键找到指定周报
	public WeeklyReport get(Integer id);

	// 通过主键删除指定周报
	public void delete(Integer id);

	// 通过主键修改指定周报
	public void update(WeeklyReport weeklyReport);

	// 增加一条周报数据
	public void save(WeeklyReport weeklyReport);

	// 获得所有周报
	public List<WeeklyReport> getAll(String studentId);

}
