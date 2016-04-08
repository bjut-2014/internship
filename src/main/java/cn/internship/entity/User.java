package cn.internship.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户登陆表，包括学生、教师、管理员等
 * @author dreamlate
 */
@Entity
@Table(name = "t_user")
public class User {

	// 主键
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	// 用户名，例：学生学号、教师职工号
	@Column(unique = true, length = 14)
	private String username;
	
	// 密码
	@Column(length = 14)
	private String password;
	
	// 权限
	@Column(length = 2)
	private Integer rights;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getRights() {
		return rights;
	}

	public void setRights(Integer rights) {
		this.rights = rights;
	}
	
	
}
