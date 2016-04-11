package cn.internship.service;

import cn.internship.entity.PracticalReports;

import java.util.List;

/**
 * Created by surprise on 4/9/16.
 */
public interface PracticalReportsService {
    public PracticalReports get(Integer id);

    public void delete(Integer id);

    public void update(PracticalReports practicalReports);

    public void save(PracticalReports practicalReports);

    public List<PracticalReports> getAll(String studentId);
}
