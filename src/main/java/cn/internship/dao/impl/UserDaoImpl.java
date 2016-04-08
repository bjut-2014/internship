package cn.internship.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import cn.internship.dao.UserDao;
import cn.internship.entity.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	//登陆
	public User login(String username, String password) {
		String hql = "from User u where u.username=? and u.password=?";
		Object[] values = {username,password};
		List<User> list = (List<User>) getHibernateTemplate().find(hql,values);
		if(list==null||list.size()==0){
			return null;
		}
		return list.get(0);
	}

}
