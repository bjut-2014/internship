package cn.internship.service.impl;

import java.util.List;

import cn.internship.dao.GraduationSelectionDao;
import cn.internship.entity.GraduationProSele;
import cn.internship.service.GraduationSelectionService;


public class GraduationSelectionServiceImpl implements GraduationSelectionService{
	
	private GraduationSelectionDao graduationSelectionDao;
	
	//通过教师编号获取相应的毕设信息
	public List<GraduationProSele> getSelectInfoByTno(String tno){
		return graduationSelectionDao.getSelectInfoByTno(tno);
	}

	

	@Override
	//获取所有的毕设信息
	public List<GraduationProSele> getAllSelectInfo() {
		return graduationSelectionDao.getAllSelectInfo();
	}

	@Override
	//通过主键获取一条毕设选题信息
	public GraduationProSele getOneSelectInfo(Integer id) {
		return graduationSelectionDao.getOneSelectInfoById(id);
	}

	@Override
	//添加一条毕设选题信息
	public void addSelectInfo(GraduationProSele gr) {
		graduationSelectionDao.addSelectInfo(gr);
	}

	@Override
	//更新一条毕设选题信息
	public void updateSelectInfo(GraduationProSele gr) {
		graduationSelectionDao.updateSelectInfo(gr);
	}

	@Override
	//根据主键删除一条毕设选题信息
	public void deleteSelecInfo(Integer deleteId) {
		graduationSelectionDao.deleteSelectInfo(deleteId);
	}
	
	
	//================================getter setter方法===================================
	public GraduationSelectionDao getGraduationSelectionDao() {
		return graduationSelectionDao;
	}

	public void setGraduationSelectionDao(GraduationSelectionDao graduationSelectionDao) {
		this.graduationSelectionDao = graduationSelectionDao;
	}

}
