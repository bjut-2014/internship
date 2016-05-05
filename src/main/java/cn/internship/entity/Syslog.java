package cn.internship.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 系统日志
 * @author dreamlate
 */
@Entity
@Table(name="syslog")
public class Syslog {

	//主键
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer syslogId;
	//编号：学生学号，教师职工号
	@Column(length=24)
	private String no;
	//姓名
	@Column(length=24)
	private String name;
	//时间
	private Date date;
	//行为
	@Column(length=100)
	private String behavior;
<<<<<<< HEAD
	
=======
>>>>>>> dfe223da577b72dd75833ec49746564a09c36b1a

	public Integer getSyslogId() {
		return syslogId;
	}
	public void setSyslogId(Integer syslogId) {
		this.syslogId = syslogId;
	}

	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getBehavior() {
		return behavior;
	}
	public void setBehavior(String behavior) {
		this.behavior = behavior;
	}
	
	
	
}
