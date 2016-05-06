package cn.internship.service;

/**
 * 实习信息业务层接口
 * 
 */

import java.util.List;

import cn.internship.entity.InternshipDetail;
public interface InternshipDetailService {

	//通过学号获取实习信息
	public InternshipDetail getInternshipDetailBySno(String sno);
	
	//通过主键获取实习信息
	public InternshipDetail getInternshipDetailById(Integer id);

	//获取所有学生的实习信息
	public List<InternshipDetail> getAllStudents();
	
	//添加实习信息
	public void addInternshipDetail(InternshipDetail it);
	
	//修改一条实习信息
	public void updateInternshipDetail(InternshipDetail it);
	
	//通过主键删除一条实习信息
	public void deleteInternshipDetail(Integer deleteId);
}
