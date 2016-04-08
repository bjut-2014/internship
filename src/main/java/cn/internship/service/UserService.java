package cn.internship.service;

import cn.internship.entity.User;

/**
 * 用户业务层接口
 * @author dreamlate
 */
public interface UserService {

	//登陆
	public User login(String username,String password);
	
	//修改用户密码
	public void updatePwd(User user);
	
	//根据用户名获得用户
	public User findUserByUsername(String username);
}
