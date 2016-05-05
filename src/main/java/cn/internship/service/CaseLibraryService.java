package cn.internship.service;

import java.util.List;

import cn.internship.entity.CaseLibrary;

/**
 * 案例库持久类接口
 * @author MengHan
 */
public interface CaseLibraryService {

	public List<CaseLibrary> getByCId(Integer courseId);
	
	public CaseLibrary get(Integer caseLibraryId);
	
	public void saveCaseLibrary(CaseLibrary caseLibrary);
}
