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
	
	//通过学号查找学生
	public Student get(String sno){
		String hql = "from Student s where s.sno=?";
		Object[] values={sno};
		List<Student> list = (List<Student>) getHibernateTemplate().find(hql,values);
		if(list==null||list.size()==0){
			return null;
		}
		else{
			return list.get(0);
		}
	}

	//更新用户信息
    @Override
	public void updateStudent(Student student) {
		getHibernateTemplate().update(student);
	}

	@Override
	//获取所有学生信息
	public List<Student> getAllStudents() {
		String hql="from Student";
		List<Student> list=(List<Student>) getHibernateTemplate().find(hql);
		return list;
	}

	@Override
	//添加学生信息
	public void addStudent(Student student) {
		getHibernateTemplate().save(student);
	}

	@Override
	//根据主键删除学生信息
	public void deleteStudent(Integer id) {
		Student st=get(id);
		getHibernateTemplate().delete(st);
	}

}
