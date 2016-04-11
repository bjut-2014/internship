package cn.internship.dao.impl;

import cn.internship.dao.PracticalReportsDao;
import cn.internship.entity.PracticalReports;
import cn.internship.entity.WeeklyPlan;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

/**
 * 实训报告持久层操作
 * Created by surprise on 4/9/16.
 */
public class PracticalReportsDaoImpl extends HibernateDaoSupport implements PracticalReportsDao {
	
	//根据主键查找实训报告
	public PracticalReports get(Integer id) {
        return getHibernateTemplate().get(PracticalReports.class, id);
    }

	//根据主键删除实训报告
    public void delete(Integer id) {
        PracticalReports practicalReports = get(id);
        getHibernateTemplate().delete(practicalReports);
    }

  //更新实训报告
    public void update(PracticalReports practicalReports) {
        getHibernateTemplate().update(practicalReports);
    }

    //保存实训报告
    public void save(PracticalReports practicalReports) {
        getHibernateTemplate().save(practicalReports);
    }

    //获得所有实训报告
    public List<PracticalReports> getAll(String studentId) {
        String hql = "from PracticalReports pr where pr.studentId = ?";
        Object[] values = {studentId};
        List<PracticalReports> list = (List<PracticalReports>) getHibernateTemplate().find(hql, values);
        return list;
    }
}
