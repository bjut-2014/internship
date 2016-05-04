package cn.internship.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.internship.dao.WeeklyReportDao;
import cn.internship.entity.WeeklyReport;

public class WeeklyReportDaoImpl extends HibernateDaoSupport implements WeeklyReportDao {

	//根据id主键查找相应的周报
	@Override
	public WeeklyReport get(Integer id) {
		
		return getHibernateTemplate().get(WeeklyReport.class, id);
	}

	//根据id主键删除相应的周报
	@Override
	public void delete(Integer id) {
		WeeklyReport weeklyReport=get(id);
		getHibernateTemplate().delete(weeklyReport);
	}

	//更新周报
	@Override
	public void update(WeeklyReport weeklyReport) {
		getHibernateTemplate().update(weeklyReport);
		
	}

	//保存一条周报
	@Override
	public void save(WeeklyReport weeklyReport) {
		System.out.println(weeklyReport);
		try{
			//getHibernateTemplate().save(weeklyReport);
			getHibernateTemplate().save(weeklyReport);
			System.out.println("save success!");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		
	}

<<<<<<< HEAD
	//根据学生学号获取所有的周报
=======
	//根据学生主键获取所有的周报
>>>>>>> ef354a5734f8648f56c1e17d2a743b42e8e3293f
	@Override
	public List<WeeklyReport> getAll(String sno) {
		String hql="from WeeklyReport wr where wr.sno=?";
		Object[] values={sno};
		List<WeeklyReport> list=(List<WeeklyReport>) getHibernateTemplate().find(hql, values);
		if(list.isEmpty()){
			WeeklyReport wr=new WeeklyReport();
			wr.setSno(sno);
			wr.setTitle("尚未提交周报！");
		}
		return list;
	}

}
