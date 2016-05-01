package cn.internship.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.internship.dao.InternshipDetailDao;
import cn.internship.entity.InternshipDetail;
public class InternshipDetailDaoImpl extends HibernateDaoSupport implements InternshipDetailDao{

	//根据学生学号获取实习信息
	@Override
	public InternshipDetail get(String sno) {
		String hql="from InternshipDetail it where it.sno=?";
		Object[] values={sno};
		List<InternshipDetail> it=(List<InternshipDetail>) getHibernateTemplate().find(hql, values);
			if(it.isEmpty()){
				return null;
			}else{
				return it.get(0);
			}
			
			
		
	}

}
