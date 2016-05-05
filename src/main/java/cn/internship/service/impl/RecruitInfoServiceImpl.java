package cn.internship.service.impl;

import java.util.List;

import cn.internship.dao.RecruitInfoDao;
import cn.internship.entity.RecruitInfo;
import cn.internship.service.RecruitInfoService;

/**
 * 招聘信息业务层操作
 * @author MengHan
 *
 */
public class RecruitInfoServiceImpl implements RecruitInfoService{

	private RecruitInfoDao recruitInfoDao;
	
	@Override
	public void save(RecruitInfo recruitInfo) {
		recruitInfoDao.add(recruitInfo);
	}

	@Override
	public void delete(Integer id) {
		recruitInfoDao.delete(id);
	}

	@Override
	public void update(RecruitInfo recruitInfo) {
		recruitInfoDao.update(recruitInfo);
	}

	@Override
	public RecruitInfo get(Integer id) {
		return recruitInfoDao.get(id);
	}

	@Override
	public List<RecruitInfo> getAll() {
		return recruitInfoDao.getAll();
	}

	@Override
	public List<RecruitInfo> getByNum(int num) {
		return recruitInfoDao.getByNum(num);
	}

	public RecruitInfoDao getRecruitInfoDao() {
		return recruitInfoDao;
	}

	public void setRecruitInfoDao(RecruitInfoDao recruitInfoDao) {
		this.recruitInfoDao = recruitInfoDao;
	}
	
	

}
