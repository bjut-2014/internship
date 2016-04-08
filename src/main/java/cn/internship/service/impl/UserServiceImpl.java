package cn.internship.service.impl;

import cn.internship.dao.UserDao;
import cn.internship.entity.User;
import cn.internship.service.UserService;

/**
 * 用户业务层操作，登陆验证
 * @author dreamlate
 */
public class UserServiceImpl implements UserService{

	private UserDao userDao;
	
	//登陆
	public User login(String username, String password) {
		return userDao.login(username, password);
	}

	
	//-------------------------------------------set与get方法-------------------------------------------------

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
