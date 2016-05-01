package cn.internship.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.internship.dao.TeacherDao;
import cn.internship.entity.Teacher;

/**
 * 教师持久层操作
 * @author MengHan
 */
public class TeacherDaoImpl extends HibernateDaoSupport implements TeacherDao{

	//通过用户名密码查找教师
	@Override
	public Teacher get(String tno, String password) {
		String hql = "from Teacher t where t.tno=:tno and t.password=:password";
		String[] params = new String[]{"tno","password"};
		String[] values = new String[]{tno,password};
		List<Teacher> list = (List<Teacher>) getHibernateTemplate().findByNamedParam(hql, params, values);
		if(list==null||list.size()==0){
			return null;
		}
		return list.get(0);
	}

	//通过主键查找教师
	@Override
	public Teacher get(Integer teacherId) {
		return getHibernateTemplate().get(Teacher.class, teacherId);
	}

}