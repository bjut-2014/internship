package cn.internship.service.impl;

import java.util.List;

import cn.internship.dao.InternshipDetailDao;
import cn.internship.dao.impl.InternshipDetailDaoImpl;
import cn.internship.entity.InternshipDetail;
import cn.internship.service.InternshipDetailService;

public class InternshipDetailServiceImpl implements InternshipDetailService {

	private InternshipDetailDao internshipDetailDao;
	@Override
	//通过学生学号获取其实习信息
	public InternshipDetail getInternshipDetailBySno(String sno) {
		return internshipDetailDao.get(sno);
	}
	
	
	//==========================================================================//
	public InternshipDetailDao getInternshipDetailDao() {
		return internshipDetailDao;
	}
	public void setInternshipDetailDao(InternshipDetailDao internshipDetailDao) {
		this.internshipDetailDao = internshipDetailDao;
	}


	@Override
	public List<InternshipDetail> getAllStudents() {
		return internshipDetailDao.getAllStudents();
	}

}
