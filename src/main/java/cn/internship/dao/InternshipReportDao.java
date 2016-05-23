package cn.internship.dao;

import cn.internship.entity.InternshipReport;

public interface InternshipReportDao {

	public void save(InternshipReport internshipReport);
	public InternshipReport get(String sno);
	public void update(InternshipReport internshipReport);
}
