package cn.internship.dao;

import java.util.List;
import cn.internship.entity.InternshipDetail;

public interface InternshipDetailDao {

	public InternshipDetail get(String sno);

	//获取所有学生的实习信息
	public List<InternshipDetail> getAllStudents();
}
