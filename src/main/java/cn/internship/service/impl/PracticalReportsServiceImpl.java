package cn.internship.service.impl;

import cn.internship.dao.PracticalReportsDao;
import cn.internship.entity.PracticalReports;
import cn.internship.service.PracticalReportsService;

import java.util.List;

/**
 * Created by surprise on 4/9/16.
 */
public class PracticalReportsServiceImpl implements PracticalReportsService {

    private PracticalReportsDao practicalReportsDao;

    public PracticalReports get(Integer id) {
        return practicalReportsDao.get(id);
    }

    public void delete(Integer id) {
        practicalReportsDao.delete(id);
    }

    public void update(PracticalReports practicalReports) {
        practicalReportsDao.update(practicalReports);
    }

    public void save(PracticalReports practicalReports) {
        practicalReportsDao.save(practicalReports);
    }

    public List<PracticalReports> getAll(String studentId) {
        return practicalReportsDao.getAll(studentId);
    }

    public PracticalReportsDao getPracticalReportsDao() {
        return practicalReportsDao;
    }

    public void setPracticalReportsDao(PracticalReportsDao practicalReportsDao) {
        this.practicalReportsDao = practicalReportsDao;
    }
}
