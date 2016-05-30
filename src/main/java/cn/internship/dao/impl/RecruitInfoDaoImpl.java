package cn.internship.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.internship.dao.RecruitInfoDao;
import cn.internship.entity.RecruitInfo;

/**
 * 招聘信息持久层操作
 * @author MengHan
 *
 */
public class RecruitInfoDaoImpl extends HibernateDaoSupport implements RecruitInfoDao{

	@Override
	public void add(RecruitInfo recruitInfo) {
		getHibernateTemplate().save(recruitInfo);
	}

	@Override
	public void delete(Integer id) {
		RecruitInfo recruitInfo = get(id);
		getHibernateTemplate().delete(recruitInfo);
	}

	@Override
	public void update(RecruitInfo recruitInfo) {
		getHibernateTemplate().saveOrUpdate(recruitInfo);
	}

	@Override
	public RecruitInfo get(Integer id) {
		return getHibernateTemplate().get(RecruitInfo.class, id);
	}

	@Override
	public List<RecruitInfo> getAll() {
		String hql = "from RecruitInfo r order by r.date desc ";
		List<RecruitInfo> list = (List<RecruitInfo>) getHibernateTemplate().find(hql);
		return list;
	}

	@Override
	public List<RecruitInfo> getByNum(int num) {
		String hql = "from RecruitInfo r order by r.date desc ";
		List<RecruitInfo> list = (List<RecruitInfo>) getHibernateTemplate().find(hql);
		//只取前num条数据
		List<RecruitInfo> newList = null;
		if(list.size()>num){
			newList = list.subList(0, num);
			return newList;
		}
		return list;
	}

}
