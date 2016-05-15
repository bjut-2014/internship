package cn.internship.service.impl;

import cn.internship.dao.AdminDao;
import cn.internship.entity.Admin;
import cn.internship.service.AdminService;

/**
 * 管理员业务层操作
 * @author dreamlate
 *
 */
public class AdminServiceImpl implements AdminService{

	private AdminDao adminDao;
	
	//登陆
	@Override
	public Admin login(String username,String password) {
		return adminDao.get(username, password);
	}

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public void logout(){
		//方法体为空，主要为了aop框架能检测到注销事件
	}

	public Admin get(Integer adminId) {
		return adminDao.get(adminId);
	}

	public void updatePwd(Admin admin) {
		adminDao.updateAdmin(admin);
	}
}
