package cn.internship.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.internship.dao.CarouselFigureDao;
import cn.internship.entity.CarouselFigure;

/**
 * 轮播图持久层操作
 * @author MengHan
 *
 */
public class CarouselFigureDaoImpl extends HibernateDaoSupport implements CarouselFigureDao{

	@Override
	public void add(CarouselFigure carouselFigure) {
		getHibernateTemplate().save(carouselFigure);
	}

	@Override
	public void delete(Integer id) {
		CarouselFigure carouselFigure = get(id);
		getHibernateTemplate().delete(carouselFigure);
	}

	@Override
	public CarouselFigure get(Integer id) {
		return getHibernateTemplate().get(CarouselFigure.class, id);
	}

	@Override
	public void edit(CarouselFigure carouselFigure) {
		getHibernateTemplate().saveOrUpdate(carouselFigure);
	}

	@Override
	public List<CarouselFigure> getAll() {
		String hql = "from CarouselFigure";
		List<CarouselFigure> list = (List<CarouselFigure>) getHibernateTemplate().find(hql);
		return list;
	}

	@Override
	public List<CarouselFigure> getByNum(int num) {
		String hql = "from CarouselFigure cf order by cf.date desc ";
		List<CarouselFigure> list = (List<CarouselFigure>) getHibernateTemplate().find(hql);
		//只取前num条数据
		List<CarouselFigure> newList = null;
		if(list.size()>num){
			newList = list.subList(0, num);
			return newList;
		}
		return list;
	}

}
