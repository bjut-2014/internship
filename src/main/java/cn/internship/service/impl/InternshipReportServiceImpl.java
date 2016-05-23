package cn.internship.service.impl;

import cn.internship.dao.InternshipReportDao;
import cn.internship.entity.InternshipReport;
import cn.internship.service.InternshipReportService;

public class InternshipReportServiceImpl implements InternshipReportService{

	private InternshipReportDao internshipReportDao;
	public InternshipReportDao getInternshipReportDao() {
		return internshipReportDao;
	}
	public void setInternshipReportDao(InternshipReportDao internshipReportDao) {
		this.internshipReportDao = internshipReportDao;
	}
	@Override
	//保存实习报告
	public void saveInternshipReport(InternshipReport internshipReport) {
		internshipReportDao.save(internshipReport);
	}
	//获取实习报告
	@Override
	public InternshipReport getInternshipReport(String sno) {
		return internshipReportDao.get(sno);
	}
	//更新实习报告
	@Override
	public void updateInternshipDetail(InternshipReport internshipReport) {
		internshipReportDao.update(internshipReport);
	}

	
	
	
}
