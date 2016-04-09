package cn.internship.service.impl;

import cn.internship.dao.PracticalReportsDao;
import cn.internship.entity.PracticalReports;
import cn.internship.service.PracticalReportsService;

/**
 * Created by surprise on 4/9/16.
 */
public class PracticalReportsServiceImpl implements PracticalReportsService {
    private PracticalReportsDao practicalReportsDao;

    public PracticalReports getPracticalReports(String studentId) {
        return practicalReportsDao.getPracticalReports(studnetId);
    }
}
