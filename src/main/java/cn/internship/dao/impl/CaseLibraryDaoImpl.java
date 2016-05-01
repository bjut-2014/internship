package cn.internship.dao.impl;

import java.util.List;
import java.util.Set;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.internship.dao.CaseLibraryDao;
import cn.internship.entity.CaseLibrary;
import cn.internship.entity.Course;

/**
 * 案例库持久层操作
 * @author MengHan
 */
public class CaseLibraryDaoImpl extends HibernateDaoSupport implements CaseLibraryDao{

	//获得指定课程的所有案例库文件
	@Override
	public List<CaseLibrary> getAll() {
		String hql = "from CaseLibrary";
		List<CaseLibrary> caseLibraries = (List<CaseLibrary>) getHibernateTemplate().find(hql);
		return caseLibraries;
	}

	//获得指定案例库文件
	@Override
	public CaseLibrary get(Integer id) {
		return getHibernateTemplate().get(CaseLibrary.class, id);
	}

	@Override
	public List<CaseLibrary> getByCId(Integer courseId) {
		String hql = "from CaseLibrary cl where cl.course.courseId = "+courseId;
		List<CaseLibrary> caseLibraries = (List<CaseLibrary>) getHibernateTemplate().find(hql);
		if(caseLibraries==null||caseLibraries.size()==0){
			return null;
		}
		return caseLibraries;
	}

}
