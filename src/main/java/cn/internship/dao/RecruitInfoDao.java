package cn.internship.dao;

import java.util.List;

import cn.internship.entity.RecruitInfo;

/**
 * 招聘信息持久层接口
 * @author MengHan
 *
 */
public interface RecruitInfoDao {

	public void add(RecruitInfo recruitInfo);
	
	public void delete(Integer id);
	
	public void update(RecruitInfo recruitInfo);
	
	public RecruitInfo get(Integer id);
	
	public List<RecruitInfo> getAll();
	
	public List<RecruitInfo> getByNum(int num);
}
