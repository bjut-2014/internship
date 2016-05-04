package cn.internship.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * 学生周报实体类
 * 
 * @author Sunny
 *
 */

@Entity
@Table(name = "weekly_report")
public class WeeklyReport {
	// 主键
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	// 学生学号，依赖学号查找周报
	@Column(length = 24)
	private String sno;
	// 周报标题
	@Column(length = 100)
	private String title;
	// 周报日期
	private Date date;
	// 周报内容
	@Column(length=1024)
	@Type(type="text")
	private String content;
	
	//===============================setter和getter方法===============================//
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "WeeklyReport [id=" + id + ", sno=" + sno + ", title=" + title
				+ ", date=" + date + ", content=" + content + "]";
	}
	
	

}
