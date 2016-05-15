package cn.internship.dao;

import cn.internship.entity.Admin;

/**
 * 管理员持久层接口
 * @author dreamlate
 *
 */
public interface AdminDao {

	public Admin get(Integer adminId);
	
	public Admin get(String username,String password);

	public void updateAdmin(Admin admin);
	
}
