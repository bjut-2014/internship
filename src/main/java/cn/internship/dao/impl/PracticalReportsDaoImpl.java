package cn.internship.dao.impl;

import cn.internship.dao.PracticalReportsDao;
import cn.internship.entity.PracticalReports;
import cn.internship.entity.WeeklyPlan;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by surprise on 4/9/16.
 */
public class PracticalReportsDaoImpl extends HibernateDaoSupport implements PracticalReportsDao {
    public PracticalReports get(Integer id) {
        return getHibernateTemplate().get(PracticalReports.class, id);
    }

    public void delete(Integer id) {
        PracticalReports practicalReports = get(id);
        getHibernateTemplate().delete(practicalReports);
    }

    public void update(PracticalReports practicalReports) {
        getHibernateTemplate().update(practicalReports);
    }

    public void save(PracticalReports practicalReports) {
        getHibernateTemplate().save(practicalReports);
    }

    public List<PracticalReports> getAll(String studentId) {
        String hql = "from practical_reports wp where wp.studentId = ?";
        Object[] values = {studentId};
        List<PracticalReports> list = (List<PracticalReports>) getHibernateTemplate().find(hql,values);
        return list;
    }
}
