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

	@Override
	//获取所有的毕设选题信息
	public List<GraduationProSele> getAllSelectInfo() {
		String hql="from GraduationProSele";
		List<GraduationProSele> list=(List<GraduationProSele>) getHibernateTemplate().find(hql);
		return list;
	}

	@Override
	//根据主键获取一条毕设选题信息
	public GraduationProSele getOneSelectInfoById(Integer id) {
		return getHibernateTemplate().get(GraduationProSele.class,id);
	}

	@Override
	//添加一条毕设选题信息
	public void addSelectInfo(GraduationProSele graduationProSele) {
		getHibernateTemplate().save(graduationProSele);
	}

	@Override
	//更新一条毕设选题信息
	public void updateSelectInfo(GraduationProSele graduationProSele) {
		getHibernateTemplate().update(graduationProSele);
	}

	@Override
	//根据主键删除一条毕设信息
	public void deleteSelectInfo(Integer deleteId) {
		GraduationProSele gr=getOneSelectInfoById(deleteId);
		getHibernateTemplate().delete(gr);
	}



}
