package cn.internship.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.internship.entity.GraduationProSele;
import cn.internship.dao.GraduationSelectionDao;


public class GraduationSelectionDaoImpl extends HibernateDaoSupport implements GraduationSelectionDao{

	//根据教师编号获取毕设选题信息
	@Override
	public List<GraduationProSele> getSelectInfoByTno(String tno) {
		String hql="from GraduationProSele gs where gs.tno=?";
		Object values[]={tno};
		List<GraduationProSele> list=(List<GraduationProSele>) getHibernateTemplate().find(hql, values);
		return list;
	}



}
