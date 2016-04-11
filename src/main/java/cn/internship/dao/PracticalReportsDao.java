package cn.internship.dao;

import cn.internship.entity.PracticalReports;

import java.util.List;

/**
 * 实训报告持久层接口
 * Created by surprise on 4/9/16.
 */
public interface PracticalReportsDao {
	//根据主键查找实训报告
    public PracticalReports get(Integer id);

    //根据主键删除实训报告
    public void delete(Integer id);

    //更新实训报告
    public void update(PracticalReports practicalReports);

    //保存实训报告
    public void save(PracticalReports practicalReports);

    //获得所有实训报告
    public List<PracticalReports> getAll(String studentId);
}
