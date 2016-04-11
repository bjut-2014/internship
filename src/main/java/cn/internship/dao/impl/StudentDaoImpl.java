package cn.internship.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.internship.dao.StudentDao;
import cn.internship.entity.Student;

/**
 * 学生持久层操作
 * @author dreamlate
 */
public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao{


	//通过主键查找学生
	public Student get(Integer id) {
		return getHibernateTemplate().get(Student.class, id);
	}

	//通过学号查找学生
	public Student get(String studentId) {
		String hql = "from Student s where s.studentId=?";
//		List<Student> list = getSessionFactory().getCurrentSession()
//										.createQuery(hql).setParameter("studentId", studentId).list();
		List<Student> list = (List<Student>) getHibernateTemplate().find(hql, new Object[]{studentId});
		if(list==null || list.size() ==0){
			return null;
		}
		return list.get(0);
	}
	
	

}
