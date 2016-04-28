package cn.internship.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import cn.internship.dao.CaseLibraryDao;
import cn.internship.entity.Course;

/**
 * 案例库持久层操作
 * @author MengHan
 */
public class CaseLibraryDaoImpl extends HibernateDaoSupport implements CaseLibraryDao{

	//获得指定课程的所有案例库文件
	@Override
	public List<Course> getAll(Integer courseId) {
		String hql = "";
		return null;
	}

	//获得指定案例库文件
	@Override
	public Course get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
