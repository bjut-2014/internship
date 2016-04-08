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

	//通过学号、密码查找学生
	public Student findStudentByUP(String username, String password) {
		String hql = "from Student stu where stu.studentId=? and stu.password=?";
		Object[] values = {username,password};
		List<Student> list = (List<Student>) getHibernateTemplate().find(hql,values);
		if(list==null||list.size()==0){
			return null;
		}
		return list.get(0);
	}
	
	

}
