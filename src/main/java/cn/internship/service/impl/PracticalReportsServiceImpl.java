package cn.internship.service.impl;

import cn.internship.dao.PracticalReportsDao;
import cn.internship.entity.PracticalReports;
import cn.internship.service.PracticalReportsService;

import java.util.List;

/**
 * 实训报告业务层操作 Created by surprise on 4/9/16.
 */
public class PracticalReportsServiceImpl implements PracticalReportsService {

	private PracticalReportsDao practicalReportsDao;

	// 获得指定实训报告
	public PracticalReports get(Integer id) {
		return practicalReportsDao.get(id);
	}

	// 删除指定实训报告
	public void delete(Integer id) {
		practicalReportsDao.delete(id);
	}

	// 更新指定实训报告
	public void update(PracticalReports practicalReports) {
		practicalReportsDao.update(practicalReports);
	}

	// 保存实训报告
	public void save(PracticalReports practicalReports) {
		practicalReportsDao.save(practicalReports);
	}

	// 获得所有实训报告
	public List<PracticalReports> getAll(String studentId) {
		return practicalReportsDao.getAll(studentId);
	}

	public PracticalReportsDao getPracticalReportsDao() {
		return practicalReportsDao;
	}

	public void setPracticalReportsDao(PracticalReportsDao practicalReportsDao) {
		this.practicalReportsDao = practicalReportsDao;
	}

}
