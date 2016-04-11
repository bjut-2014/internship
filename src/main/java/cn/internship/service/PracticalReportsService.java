package cn.internship.service;

import cn.internship.entity.PracticalReports;

import java.util.List;

/**
 * 实训报告业务层接口
 * Created by surprise on 4/9/16.
 */
public interface PracticalReportsService {
	//获得指定实训报告
    public PracticalReports get(Integer id);

    //删除指定实训报告
    public void delete(Integer id);

    //更新指定实训报告
    public void update(PracticalReports practicalReports);

    //保存实训报告
    public void save(PracticalReports practicalReports);

    //获得所有实训报告
    public List<PracticalReports> getAll(String studentId);
}
