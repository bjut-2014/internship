package cn.internship.service;

import java.util.List;

import cn.internship.entity.WeeklyReport;

public interface WeeklyReportService {

	// 通过主键找到指定周报
	public WeeklyReport getWeeklyReport(Integer id);

	// 通过主键删除指定周报
	public void deleteWeeklyReport(Integer id);

	// 通过主键修改指定周报
	public void updateWeeklyReport(WeeklyReport weeklyPlan);

	// 增加一条周报数据
	public void saveWeeklyReport(WeeklyReport weeklyPlan);

	// 获得所有周报
	public List<WeeklyReport> getAllWeeklyReport(String studentId);

}
