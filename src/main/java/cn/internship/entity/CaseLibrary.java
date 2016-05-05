package cn.internship.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="case_library")
public class CaseLibrary {
	//主键
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer caseLibraryId;
	//案例库名称
	private String name;
	//上传时间
	private Date date;
	//上传路径
	private String filePath;
	//对应的课程
	@ManyToOne(targetEntity=Course.class)
	@JoinColumn(name="courseId",referencedColumnName="courseId",nullable=false)
	private Course course;
	//教师案例库
	private Boolean tchCaseLibrary;
	//学生案例库
	private Boolean stuCaseLibrary;
	public Integer getCaseLibraryId() {
		return caseLibraryId;
	}
	public void setCaseLibraryId(Integer caseLibraryId) {
		this.caseLibraryId = caseLibraryId;
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
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Boolean getTchCaseLibrary() {
		return tchCaseLibrary;
	}
	public void setTchCaseLibrary(Boolean tchCaseLibrary) {
		this.tchCaseLibrary = tchCaseLibrary;
	}
	public Boolean getStuCaseLibrary() {
		return stuCaseLibrary;
	}
	public void setStuCaseLibrary(Boolean stuCaseLibrary) {
		this.stuCaseLibrary = stuCaseLibrary;
	}
}