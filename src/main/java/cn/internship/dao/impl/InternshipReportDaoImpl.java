package cn.internship.dao.impl;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.internship.dao.InternshipReportDao;
import cn.internship.entity.InternshipReport;

public class InternshipReportDaoImpl extends HibernateDaoSupport implements InternshipReportDao{

	@Override
	public void save(InternshipReport internshipReport) {
		getHibernateTemplate().save(internshipReport);
	}

}
