package cn.internship.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import cn.internship.dao.SyslogDao;
import cn.internship.entity.Syslog;

/**
 * 系统日志持久层操作
 * @author dreamlate
 */
public class SyslogDaoImpl extends HibernateDaoSupport implements SyslogDao{

	//通过主键找到一条日志
	@Override
	public Syslog get(Integer id) {
		return getHibernateTemplate().get(Syslog.class, id);
	}

	//获得所有日志
	@Override
	public List<Syslog> getAll() {
		String hql = "from Syslog";
		List<Syslog> list = (List<Syslog>) getHibernateTemplate().find(hql);
		if(list==null||list.size()==0){
			return null;
		}
		return list;
	}

	//获得某个编号下的前10条日志
	@Override
	public List<Syslog> getAll(String no) {
		String hql = "from Syslog s where s.no='"+no+"' order by s.date desc";
//		String[] params = new String[]{"no"};
//		String[] values = new String[]{no};
		List<Syslog> list = (List<Syslog>) getHibernateTemplate().find(hql);
		if(list==null||list.size()==0){
			return null;
		}
		//只取前10条数据
		List<Syslog> newList = null;
		if(list.size()>10){
			newList = list.subList(0, 10);
			return newList;
		}
		return list;
	}

	//添加一条日志
	@Override
	public void add(Syslog syslog) {
		getHibernateTemplate().save(syslog);
	}

	//通过主键删除一条日志
	@Override
	public void delete(Integer id) {
		Syslog syslog = get(id);
		delete(syslog);
	}

	//通过实体删除一条日志
	@Override
	public void delete(Syslog syslog) {
		getHibernateTemplate().delete(syslog);
	}

}
