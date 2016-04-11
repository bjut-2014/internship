package cn.internship.service.impl;

import cn.internship.dao.InternshipReportDao;
import cn.internship.entity.InternshipReport;
import cn.internship.service.InternshipReportService;

/**
 * 实习报告业务层操作
 * @author dreamlate
 */
public class InternshipReportServiceImpl implements InternshipReportService {

	private InternshipReportDao internshipReportDao;
	
	//通过学生学号查找实习报告
	public InternshipReport get(String studentId) {
		return internshipReportDao.get(studentId);
	}

	//写实习报告
	public void save(InternshipReport internshipReport) {
		internshipReportDao.add(internshipReport);
	}

	//通过修改实习报告
	public void update(InternshipReport internshipReport) {
		internshipReportDao.update(internshipReport);
	}

	
	//-----------------------get与set方法-------------------------------
	
	public InternshipReportDao getInternshipReportDao() {
		return internshipReportDao;
	}

	public void setInternshipReportDao(InternshipReportDao internshipReportDao) {
		this.internshipReportDao = internshipReportDao;
	}

	
	
	
}
