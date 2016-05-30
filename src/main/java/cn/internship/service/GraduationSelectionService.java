package cn.internship.service;

import java.util.List;

import cn.internship.entity.*;
public interface GraduationSelectionService {

	//根据教师编号获取相应的毕设信息
	public List<GraduationProSele> getSelectInfoByTno(String tno);
	
	//获取所有的毕设信息
	public List<GraduationProSele> getAllSelectInfo();
	
	//根据主键获取一条毕设选题信息
	public GraduationProSele getOneSelectInfo(Integer id);
	
	//添加一条毕设选题信息
	public void addSelectInfo(GraduationProSele gr);
	
	//更新一条毕设选题信息
	public void updateSelectInfo(GraduationProSele gr);
	
	//根据主键删除一条毕设选题信息
	public void deleteSelecInfo(Integer deleteId);
	
	//根据学生学号获取相应的毕设信息
	public GraduationProSele getSelectInfoBySno(String sno);
}
