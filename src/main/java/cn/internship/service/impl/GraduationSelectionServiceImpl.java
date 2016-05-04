package cn.internship.service.impl;

import java.util.List;

import cn.internship.dao.GraduationSelectionDao;
import cn.internship.entity.GraduationProSele;
import cn.internship.service.GraduationSelectionService;


public class GraduationSelectionServiceImpl implements GraduationSelectionService{
	
	private GraduationSelectionDao graduationSelectionDao;
	
	public List<GraduationProSele> getSelectInfoByTno(String tno){
		return graduationSelectionDao.getSelectInfoByTno(tno);
	}

	public GraduationSelectionDao getGraduationSelectionDao() {
		return graduationSelectionDao;
	}

	public void setGraduationSelectionDao(GraduationSelectionDao graduationSelectionDao) {
		this.graduationSelectionDao = graduationSelectionDao;
	}
	
	

}
