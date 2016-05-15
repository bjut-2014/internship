package cn.internship.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.internship.dao.AdminDao;
import cn.internship.entity.Admin;

/**
 * 管理员持久层操作
 * @author dreamlate
 *
 */
public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao{

	@Override
	public Admin get(Integer adminId) {
		return getHibernateTemplate().get(Admin.class, adminId);
	}

	@Override
	public Admin get(String username, String password) {
		String hql = "from Admin a where a.username=:username and a.password=:password";
		String[] params = new String[]{"username","password"};
		String[] values = new String[]{username,password};
		List<Admin> list = (List<Admin>) getHibernateTemplate().findByNamedParam(hql, params, values);
		if(list==null||list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public void updateAdmin(Admin admin) {
		getHibernateTemplate().update(admin);
	}

}
