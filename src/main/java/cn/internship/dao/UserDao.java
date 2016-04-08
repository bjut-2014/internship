package cn.internship.dao;

import cn.internship.entity.User;

/**
 * 用户登陆持久层接口
 * @author dreamlate
 */
public interface UserDao {

	//用户登陆
	public User login(String username,String password);
	
}
