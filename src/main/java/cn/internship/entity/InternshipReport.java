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
 * 实习报告实体类
 * 
 * @author Sunny
 *
 */
@Entity
@Table(name = "internship_report")
public class InternshipReport {
	// 主键
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	// 学生学号
	@Column(length = 24)
	private String sno;

	// 实习报告标题
	@Column(length = 100)
	private String title;

	// 实习报告提交时间
	private Date date;

	//实习报告提交路径
	@Column(length=100)
	private String path;

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "InternshipReport [id=" + id + ", sno=" + sno + ", title="
				+ title + ", date=" + date + ", path=" + path + "]";
	}

	
	

}
