package cn.internship.entity;

import javax.persistence.*;

/**
 * 管理员实体类
 * @author dreamlate
 *
 */
@Entity
@Table(name="admin")
public class Admin {

	//主键
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer adminId;
	//用户名
	private String username;
	//密码
	private String password;
	//用户类型
	private Integer userType;
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	
}
