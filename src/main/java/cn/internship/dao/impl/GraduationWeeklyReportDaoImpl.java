package cn.internship.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.internship.dao.GraduationWeeklyReportDao;
<<<<<<< HEAD

=======
>>>>>>> ef354a5734f8648f56c1e17d2a743b42e8e3293f
import cn.internship.entity.GraduationWeeklyReport;

public class GraduationWeeklyReportDaoImpl extends HibernateDaoSupport implements GraduationWeeklyReportDao{

	@Override
	public GraduationWeeklyReport get(Integer id) {
		return getHibernateTemplate().get(GraduationWeeklyReport.class, id);
	}

	@Override
	public void delete(Integer id) {
		GraduationWeeklyReport graduationWeeklyReport=get(id);
		getHibernateTemplate().delete(graduationWeeklyReport);
	}

	@Override
	public void update(GraduationWeeklyReport graduationWeeklyReport) {
		getHibernateTemplate().update(graduationWeeklyReport);
	}

	@Override
	public void save(GraduationWeeklyReport graduationWeeklyReport) {
		getHibernateTemplate().save(graduationWeeklyReport);
	}

	@Override
	public List<GraduationWeeklyReport> getAll(String studentId) {
		String hql="from GraduationWeeklyReport gwr where gwr.sno=?";
		Object[] values={studentId};
		List<GraduationWeeklyReport> list=(List<GraduationWeeklyReport>) getHibernateTemplate().find(hql, values);
		return list;
	}

<<<<<<< HEAD

=======
>>>>>>> ef354a5734f8648f56c1e17d2a743b42e8e3293f
}
