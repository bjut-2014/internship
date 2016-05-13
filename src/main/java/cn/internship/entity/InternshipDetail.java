package cn.internship.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 实习信息实体类
 * 
 * @author Sunny
 *
 */

@Entity
@Table(name="internship_detail")
public class InternshipDetail {

	// 主键
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	// 学生学号
	@Column(unique = true, length = 24)
	private String sno;

	// 实习时间
	private Date date;

	// 实习公司名称
	@Column(length = 100)
	private String company_name;


	// 实习公司地点
	@Column(length = 100)
	private String company_address;

	//校外导师
	@Column(length=100)
	private String company_teacher;
	
	//实习分数
	private Integer score;

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getCompany_address() {
		return company_address;
	}

	public void setCompany_address(String company_address) {
		this.company_address = company_address;
	}

	public String getCompany_teacher() {
		return company_teacher;
	}

	public void setCompany_teacher(String company_teacher) {
		this.company_teacher = company_teacher;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "InternshipDetail [id=" + id + ", sno=" + sno + ", date=" + date
				+ ", company_name=" + company_name + ", company_address="
				+ company_address + ", company_teacher=" + company_teacher
				+ ", score=" + score + "]";
	}
	
	
}
