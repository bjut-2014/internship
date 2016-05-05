package cn.internship.service.impl;

import java.util.List;

import cn.internship.dao.CarouselFigureDao;
import cn.internship.entity.CarouselFigure;
import cn.internship.service.CarouselFigureService;

public class CarouselFigureServiceImpl implements CarouselFigureService{

	private CarouselFigureDao carouselFigureDao;
	
	@Override
	public void add(CarouselFigure carouselFigure) {
		carouselFigureDao.add(carouselFigure);
	}

	@Override
	public void delete(Integer id) {
		carouselFigureDao.delete(id);
	}

	@Override
	public CarouselFigure get(Integer id) {
		return carouselFigureDao.get(id);
	}

	@Override
	public void update(CarouselFigure carouselFigure) {
		carouselFigureDao.edit(carouselFigure);
	}

	@Override
	public List<CarouselFigure> getAll() {
		return carouselFigureDao.getAll();
	}

	@Override
	public List<CarouselFigure> getByNum(int num) {
		return carouselFigureDao.getByNum(num);
	}

	public CarouselFigureDao getCarouselFigureDao() {
		return carouselFigureDao;
	}

	public void setCarouselFigureDao(CarouselFigureDao carouselFigureDao) {
		this.carouselFigureDao = carouselFigureDao;
	}
	

}
