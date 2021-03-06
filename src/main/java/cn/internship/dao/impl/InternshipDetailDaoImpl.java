package cn.internship.dao.impl;

import java.io.Serializable;
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

	@Override
	public List<InternshipDetail> getAllStudents() {
		String hql="from InternshipDetail";
		List<InternshipDetail> list=(List<InternshipDetail>) getHibernateTemplate().find(hql);
		return list;
	}

	@Override
	//添加一条实习信息
	public void addInternshipDetail(InternshipDetail it) {
		getHibernateTemplate().save(it);
	}

	@Override
	//更新一条实习信息
	public void updateInternshipDetail(InternshipDetail it) {
		getHibernateTemplate().update(it);
	}

	@Override
	//删除一条实习信息
	public void deleteInternshipDetail(Integer deleteId) {
		InternshipDetail it=get(deleteId);
		getHibernateTemplate().delete(it);
	}

	
	//根据主键获取学生实习信息
	public InternshipDetail get(Integer id) {
		return getHibernateTemplate().get(InternshipDetail.class, id);
	}
	
	
}
