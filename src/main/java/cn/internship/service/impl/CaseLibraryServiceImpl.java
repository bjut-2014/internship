package cn.internship.service.impl;

import java.util.List;

import cn.internship.dao.CaseLibraryDao;
import cn.internship.entity.CaseLibrary;
import cn.internship.service.CaseLibraryService;

/**
 * 案例库持久层操作
 * @author MengHan
 */
public class CaseLibraryServiceImpl implements CaseLibraryService{

	private CaseLibraryDao caseLibraryDao;
	
	//通过课程主键获得当前课程所有案例库
	@Override
	public List<CaseLibrary> getByCId(Integer courseId) {
		return caseLibraryDao.getByCId(courseId);
	}

	//获得指定案例库
	@Override
	public CaseLibrary get(Integer caseLibraryId) {
		return caseLibraryDao.get(caseLibraryId);
	}


	//-----------------get与set方法-------------------------
	
	public CaseLibraryDao getCaseLibraryDao() {
		return caseLibraryDao;
	}
	
	public void setCaseLibraryDao(CaseLibraryDao caseLibraryDao) {
		this.caseLibraryDao = caseLibraryDao;
	}
	
}
