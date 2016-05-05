package cn.internship.dao;

import java.util.List;

import cn.internship.entity.CarouselFigure;

/**
 * 轮播图持久层接口
 * @author MengHan
 *
 */
public interface CarouselFigureDao {
	
	public void add(CarouselFigure carouselFigure);
	
	public void delete(Integer id);
	
	public CarouselFigure get(Integer id);
	
	public void edit(CarouselFigure carouselFigure);
	
	public List<CarouselFigure> getAll();
	
	public List<CarouselFigure> getByNum(int num);

}
