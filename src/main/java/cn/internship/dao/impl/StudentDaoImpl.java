package cn.internship.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.internship.dao.StudentDao;
import cn.internship.entity.Student;

/**
 * 学生持久层操作 
 * @author dreamlate
 */
public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao{

	//通过用户名密码查找学生
	@Override
	public Student get(String sno, String password) {
		String hql = "from Student s where s.sno=:sno and s.password=:password";
		String[] params = new String[]{"sno","password"};
		String[] values = new String[]{sno,password};
		List<Student> list = (List<Student>) getHibernateTemplate().findByNamedParam(hql, params, values);
		if(list==null||list.size()==0){
			return null;
		}
		return list.get(0);
	}

	//通过主键查找学生
	@Override
	public Student get(Integer id) {
		return getHibernateTemplate().get(Student.class, id);
	}

}
