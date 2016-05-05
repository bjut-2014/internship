package cn.internship.service;

import java.util.List;

import cn.internship.entity.CarouselFigure;

/**
 * 轮播图业务层操作
 * @author MengHan
 *
 */
public interface CarouselFigureService {

	public void add(CarouselFigure carouselFigure);
	
	public void delete(Integer id);
	
	public CarouselFigure get(Integer id);
	
	public void update(CarouselFigure carouselFigure);
	
	public List<CarouselFigure> getAll();
	
	public List<CarouselFigure> getByNum(int num);
	
}
