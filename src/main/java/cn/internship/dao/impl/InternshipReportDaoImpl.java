package cn.internship.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.internship.dao.InternshipReportDao;
import cn.internship.entity.InternshipReport;

/**
 * 实习报告持久层操作
 * @author dreamlate
 */
public class InternshipReportDaoImpl extends HibernateDaoSupport implements InternshipReportDao{

	//通过学生学号查找实习报告
	public InternshipReport get(String studentId) {
		String hql = "from InternshipReport ir where ir.studentId=?";
		Object[] values = {studentId};
		List<InternshipReport> list = (List<InternshipReport>) getHibernateTemplate().find(hql, values);
		if(list==null || list.size() ==0){
			return null;
		}
		return list.get(0);
	}

	//添加实习报告
	public void add(InternshipReport internshipReport) {
		getHibernateTemplate().save(internshipReport);
	}

	//修改实习报告
	public void update(InternshipReport internshipReport) {
		getHibernateTemplate().update(internshipReport);
	}


}
