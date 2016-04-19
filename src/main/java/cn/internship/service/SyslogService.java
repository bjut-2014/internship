package cn.internship.service;

import java.util.List;

import cn.internship.entity.Syslog;

/**
 * 系统日志业务层接口
 * @author dreamlate
 */
public interface SyslogService {

	public void add(Syslog syslog);
	
	public void delete(Integer id);
	
	public List<Syslog> getAll();
	
	public List<Syslog> getAll(String no);
	
}
