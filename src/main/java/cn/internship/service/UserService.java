package cn.internship.service;

import cn.internship.entity.User;

/**
 * 用户业务层接口
 * @author dreamlate
 */
public interface UserService {

	//登陆
	public User login(String username,String password);
	
}
