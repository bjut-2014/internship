package cn.internship.dao;

import java.util.List;

import cn.internship.entity.GraduationProSele;


public interface GraduationSelectionDao {

	//根据教师编号获取毕设选题信息
	public List<GraduationProSele> getSelectInfoByTno(String tno);
	
	//根据学生学号获取毕设选题信息
	public GraduationProSele getSelectInfoBtSno(String sno);
	
	//获取所有的毕设选题信息
	public List<GraduationProSele> getAllSelectInfo();
	
	//通过Id获取某一毕设选题信息
	public GraduationProSele getOneSelectInfoById(Integer id);
	
	//添加毕设选题信息
	public void addSelectInfo(GraduationProSele graduationProSele);
	
	//更新毕设选题信息
	public void updateSelectInfo(GraduationProSele graduationProSele);
	
	//根据主键删除毕设选题信息
	public void deleteSelectInfo(Integer deleteId);
}
