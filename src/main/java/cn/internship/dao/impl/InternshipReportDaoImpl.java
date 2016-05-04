package cn.internship.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.internship.dao.InternshipReportDao;
import cn.internship.entity.InternshipReport;

public class InternshipReportDaoImpl extends HibernateDaoSupport implements InternshipReportDao{

	@Override
	public void save(InternshipReport internshipReport) {
		getHibernateTemplate().save(internshipReport);
	}

	@Override
	public InternshipReport get(String sno) {
		String hql="from InternshipReport it where it.sno=?";
		Object[] values={sno};
		List<InternshipReport> list=(List<InternshipReport>) getHibernateTemplate().find(hql, values);
		if(list.isEmpty()){
			return null;
		}else{
			return list.get(0);
		}
	}

}
