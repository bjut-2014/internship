package cn.internship.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.internship.dao.TeacherDao;
import cn.internship.entity.Student;
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
	//更新用户信息
	@Override
	public void updateTeacher(Teacher teacher) {
		getHibernateTemplate().update(teacher);
	}

	//添加教师
	@Override
	public void addTeacher(Teacher teacher) {
		getHibernateTemplate().save(teacher);
	}

	//获得所有教师
	@Override
	public List<Teacher> getAll() {
		return (List<Teacher>) getHibernateTemplate().find("from Teacher");
	}

	//删除教师
	@Override
	public void deleteTeacher(Integer id) {
		getHibernateTemplate().delete(get(id));
	}

	//根据教师编号获取教师信息
	@Override
	public Teacher get(String tno) {
		String hql = "from Teacher t where t.tno=?";
		Object[] values={tno};
		@SuppressWarnings("unchecked")
		List<Teacher> list = (List<Teacher>) getHibernateTemplate().find(hql,values);
		if(list==null||list.size()==0){
			return null;
		}
		else{
			return list.get(0);
		}
		
	}
}