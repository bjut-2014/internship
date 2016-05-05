package cn.internship.service;

import java.util.List;

import cn.internship.entity.InternshipDetail;
public interface InternshipDetailService {

	
	public InternshipDetail getInternshipDetailBySno(String sno);

	//获取所有学生的实习信息
	public List<InternshipDetail> getAllStudents();
}
