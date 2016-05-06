package cn.internship.dao;

import java.util.List;
import cn.internship.entity.InternshipDetail;

public interface InternshipDetailDao {

	//根据学号获取某一学生的实习信息
	public InternshipDetail get(String sno);
	
	//根据主键获取某一学生的实习信息
	public InternshipDetail get(Integer id);

	//获取所有学生的实习信息
	public List<InternshipDetail> getAllStudents();
	
	//添加实习信息
	public void addInternshipDetail(InternshipDetail it);
	
	//修改实习信息
	public void updateInternshipDetail(InternshipDetail it);
	
	//通过主键删除实习信息
	public void deleteInternshipDetail(Integer deleteId);
}
