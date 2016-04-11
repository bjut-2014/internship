package cn.internship.dao;

import cn.internship.entity.User;

/**
 * 用户登陆持久层接口
 * @author dreamlate
 */
public interface UserDao {

	//用户登陆
	public User login(String username,String password);
	
	//根据用户名查找用户
	public User findUserByUsername(String username);
	
	//更新用户信息
	public void updateUser(User user);
}
