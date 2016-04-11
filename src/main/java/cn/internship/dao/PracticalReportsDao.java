package cn.internship.dao;

import cn.internship.entity.PracticalReports;

import java.util.List;

/**
 * Created by surprise on 4/9/16.
 */
public interface PracticalReportsDao {
    public PracticalReports get(Integer id);

    public void delete(Integer id);

    public void update(PracticalReports practicalReports);

    public void save(PracticalReports practicalReports);

    public List<PracticalReports> getAll(String studentId);
}
