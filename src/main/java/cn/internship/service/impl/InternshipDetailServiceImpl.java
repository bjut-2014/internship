package cn.internship.service.impl;

import cn.internship.dao.InternshipDetailDao;
import cn.internship.dao.impl.InternshipDetailDaoImpl;
import cn.internship.entity.InternshipDetail;
import cn.internship.service.InternshipDetailService;

public class InternshipDetailServiceImpl implements InternshipDetailService {

	private InternshipDetailDao internshipDetailDao;
	@Override
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

}
