package cn.internship.service;

import cn.internship.entity.Admin;

/**
 * 管理员业务层接口
 * @author dreamlate
 *
 */
public interface AdminService {

	public Admin login(String username,String password);

	public void logout();

	public Admin get(Integer adminId);

	public void updatePwd(Admin admin);
}
