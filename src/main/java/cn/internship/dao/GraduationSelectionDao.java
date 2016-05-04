package cn.internship.dao;

import java.util.List;

import cn.internship.entity.GraduationProSele;


public interface GraduationSelectionDao {

	//根据教师编号获取毕设选题信息
	public List<GraduationProSele> getSelectInfoByTno(String tno);
}
