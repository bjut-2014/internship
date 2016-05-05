package cn.internship.service;

import java.util.List;

import cn.internship.entity.RecruitInfo;

/**
 * 招聘信息业务层接口
 * @author MengHan
 *
 */
public interface RecruitInfoService {

	public void save(RecruitInfo recruitInfo);
	
	public void delete(Integer id);
	
	public void update(RecruitInfo recruitInfo);
	
	public RecruitInfo get(Integer id);
	
	public List<RecruitInfo> getAll();
	
	public List<RecruitInfo> getByNum(int num);
	
}
