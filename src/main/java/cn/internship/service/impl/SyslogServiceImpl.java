package cn.internship.service.impl;

import java.util.List;

import cn.internship.dao.SyslogDao;
import cn.internship.entity.Syslog;
import cn.internship.service.SyslogService;

/**
 * 系统日志业务层操作
 * @author dreamlate
 */
public class SyslogServiceImpl implements SyslogService{

	private SyslogDao syslogDao;

	//添加日志信息
	@Override
	public void add(Syslog syslog) {
		syslogDao.add(syslog);
	}

	//删除日志信息
	@Override
	public void delete(Integer id) {
		syslogDao.delete(id);
	}

	//获得所有日志信息
	@Override
	public List<Syslog> getAll() {
		return syslogDao.getAll();
	}

	//按编号获得所有日志信息
	@Override
	public List<Syslog> getAll(String no) {
		return syslogDao.getAll(no);
	}
	
	
	//------------------------get与set方法-------------------------------------------------
	
	public SyslogDao getSyslogDao() {
		return syslogDao;
	}

	public void setSyslogDao(SyslogDao syslogDao) {
		this.syslogDao = syslogDao;
	}

	
	
}
