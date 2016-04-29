package cn.internship.service;

import cn.internship.entity.InternshipReport;

public interface InternshipReportService {

	public void saveInternshipReport(InternshipReport internshipReport);
	//根据学号获取实习报告
	public InternshipReport getInternshipReport(String sno);
}
