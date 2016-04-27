package cn.internship.service.impl;

import java.util.List;

import cn.internship.dao.GraduationWeeklyReportDao;
import cn.internship.dao.WeeklyReportDao;
import cn.internship.entity.GraduationWeeklyReport;
import cn.internship.entity.WeeklyReport;
import cn.internship.service.GraduationWeeklyReportService;

public class GraduationWeeklyReportServiceImpl implements GraduationWeeklyReportService{

private GraduationWeeklyReportDao graduationWeeklyReportDao;
	
	//通过主键id获取一条周报
	public GraduationWeeklyReport get(Integer id) {
		return graduationWeeklyReportDao.get(id);		
	}

	//通过主键id删除一条周报
	public void delete(Integer id) {
		graduationWeeklyReportDao.delete(id);
	}

	//更新一条周报
	public void update(GraduationWeeklyReport graduationWeeklyReport) {
		graduationWeeklyReportDao.update(graduationWeeklyReport);
	}

	//保存一条周报
	public void save(GraduationWeeklyReport graduationWeeklyReport) {
		graduationWeeklyReportDao.save(graduationWeeklyReport);
	}

	//根据当前学生学号获取所有的周报
	public List<GraduationWeeklyReport> getAll(String sno) {
		return graduationWeeklyReportDao.getAll(sno);
	}

	public GraduationWeeklyReportDao getGraduationWeeklyReportDao() {
		return graduationWeeklyReportDao;
	}

	public void setGraduationWeeklyReportDao(
			GraduationWeeklyReportDao graduationWeeklyReportDao) {
		this.graduationWeeklyReportDao = graduationWeeklyReportDao;
	}


}
