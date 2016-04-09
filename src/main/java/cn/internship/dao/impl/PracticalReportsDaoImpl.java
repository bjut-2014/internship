package cn.internship.dao.impl;

import cn.internship.dao.PracticalReportsDao;
import cn.internship.entity.PracticalReports;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by surprise on 4/9/16.
 */
public class PracticalReportsDaoImpl extends HibernateDaoSupport implements PracticalReportsDao {
    public PracticalReports getPracticalReports(String studentId) {
        String hql = "from PracticalReports pr where pr.studentId = ?";
        List<PracticalReports> list = (List<PracticalReports>) getHibernateTemplate().find(hql, new Object[]{studentId});
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }
}
