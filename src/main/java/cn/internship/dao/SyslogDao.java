package cn.internship.dao;

import java.util.List;

import cn.internship.entity.Syslog;

/**
 * 系统日志持久层接口
 * @author dreamlate
 */
public interface SyslogDao {

	public Syslog get(Integer id);
	
	public void add(Syslog syslog);
	
	public void delete(Integer id);
	
	public void delete(Syslog syslog);
	
	public List<Syslog> getAll();
	
	public List<Syslog> getAll(String no);
	
	
}
