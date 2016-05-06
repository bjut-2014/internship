package cn.internship.service.impl;

import java.util.List;

import cn.internship.dao.InternshipDetailDao;
import cn.internship.dao.impl.InternshipDetailDaoImpl;
import cn.internship.entity.InternshipDetail;
import cn.internship.service.InternshipDetailService;

public class InternshipDetailServiceImpl implements InternshipDetailService {

	private InternshipDetailDao internshipDetailDao;

	@Override
	// 通过学生学号获取其实习信息
	public InternshipDetail getInternshipDetailBySno(String sno) {
		return internshipDetailDao.get(sno);
	}

	@Override
	//获取所有的实习信息
	public List<InternshipDetail> getAllStudents() {
		return internshipDetailDao.getAllStudents();
	}

	@Override
	//添加一条实习信息
	public void addInternshipDetail(InternshipDetail it) {
		internshipDetailDao.addInternshipDetail(it);
	}

	@Override
	//修改一条实习信息
	public void updateInternshipDetail(InternshipDetail it) {
		internshipDetailDao.updateInternshipDetail(it);
	}

	@Override
	//通过主键删除一条实习信息
	public void deleteInternshipDetail(Integer deleteId) {
		internshipDetailDao.deleteInternshipDetail(deleteId);
	}
	
	@Override
	//通过主键获取实习信息
	public InternshipDetail getInternshipDetailById(Integer id) {
		return internshipDetailDao.get(id);
	}


	// ==========================================================================//
	public InternshipDetailDao getInternshipDetailDao() {
		return internshipDetailDao;
	}

	public void setInternshipDetailDao(InternshipDetailDao internshipDetailDao) {
		this.internshipDetailDao = internshipDetailDao;
	}

	
}
