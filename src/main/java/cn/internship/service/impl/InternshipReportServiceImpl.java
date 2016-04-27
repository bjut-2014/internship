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
	public void saveInternshipReport(InternshipReport internshipReport) {
		internshipReportDao.save(internshipReport);
	}

}
