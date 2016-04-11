package cn.internship.service;

import cn.internship.entity.InternshipReport;

/**
 * 实习报告业务层接口
 * @author dreamlate
 */
public interface InternshipReportService {

	//通过学生学号查找实习报告
	public InternshipReport get(String studentId);
	
	//写实习报告
	public void save(InternshipReport internshipReport);
	
	//通过修改实习报告
	public void update(InternshipReport internshipReport);
	
}
