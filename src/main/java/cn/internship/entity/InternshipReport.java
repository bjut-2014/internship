package cn.internship.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * 实习报告持久类
 * @author MengHan
 */
@Entity
@Table(name="stu_internshipreport")
public class InternshipReport {
	
	//主键
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	//学生学号
	@Column(unique=true,length=14)
	private String studentId;
	
	//实习报告标题
	@Column(length=40)
	private String internshipreportTitle;
	
	//实习报告开始时间
	private Date internshipBeginTime;
	
	//实习报告结束时间
	private Date internshipEndTime;
	
	//实习单位
	@Column(length=40)
	private String internshipCompany;
	
	//实习部门
	@Column(length=40)
	private String internshipDepartment;
	
	//实习地点
	@Column(length=40)
	private String internshipPlace;
	
	//实习总结
	@Type(type="text")
	private String internshipSummary;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getInternshipreportTitle() {
		return internshipreportTitle;
	}

	public void setInternshipreportTitle(String internshipreportTitle) {
		this.internshipreportTitle = internshipreportTitle;
	}

	public Date getInternshipBeginTime() {
		return internshipBeginTime;
	}

	public void setInternshipBeginTime(Date internshipBeginTime) {
		this.internshipBeginTime = internshipBeginTime;
	}

	public Date getInternshipEndTime() {
		return internshipEndTime;
	}

	public void setInternshipEndTime(Date internshipEndTime) {
		this.internshipEndTime = internshipEndTime;
	}

	public String getInternshipCompany() {
		return internshipCompany;
	}

	public void setInternshipCompany(String internshipCompany) {
		this.internshipCompany = internshipCompany;
	}

	public String getInternshipDepartment() {
		return internshipDepartment;
	}

	public void setInternshipDepartment(String internshipDepartment) {
		this.internshipDepartment = internshipDepartment;
	}

	public String getInternshipPlace() {
		return internshipPlace;
	}

	public void setInternshipPlace(String internshipPlace) {
		this.internshipPlace = internshipPlace;
	}

	public String getInternshipSummary() {
		return internshipSummary;
	}

	public void setInternshipSummary(String internshipSummary) {
		this.internshipSummary = internshipSummary;
	}

	
}
