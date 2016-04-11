package cn.internship.dao;

import cn.internship.entity.InternshipReport;

/**
 * 实习报告持久层接口
 * @author MengHan
 */
public interface InternshipReportDao {

	//通过学生学号查找实习报告
	public InternshipReport get(String studentId);
	
	//写实习报告
	public void add(InternshipReport internshipReport);
	
	//修改实习报告
	public void update(InternshipReport internshipReport);
	
}
