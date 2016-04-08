package cn.internship.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 学生实体类
 * @author dreamlate
 *
 */
@Entity
@Table(name="t_student")
public class Student {

	//主键
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	//学号,不能重复
	@Column(unique=true,length=14)
	private String studentId;
	//密码
	@Column(length=14)
	private String password;
	//权限
	@Column(length=2)
	private Integer rights;
	//学生姓名
	@Column(length=20)
	private String studentName;
	//校内导师
	@Column(length=20)
	private String schoolTeacher;
	//企业导师
	@Column(length=20)
	private String enterpriseTeacher;
	//实习公司
	@Column(length=100)
	private String practiceCompany;
	//学生成绩
	@Column(length=4)
	private Integer studentScore;
	
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
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getSchoolTeacher() {
		return schoolTeacher;
	}
	public void setSchoolTeacher(String schoolTeacher) {
		this.schoolTeacher = schoolTeacher;
	}
	public String getEnterpriseTeacher() {
		return enterpriseTeacher;
	}
	public void setEnterpriseTeacher(String enterpriseTeacher) {
		this.enterpriseTeacher = enterpriseTeacher;
	}
	public String getPracticeCompany() {
		return practiceCompany;
	}
	public void setPracticeCompany(String practiceCompany) {
		this.practiceCompany = practiceCompany;
	}
	public Integer getStudentScore() {
		return studentScore;
	}
	public void setStudentScore(Integer studentScore) {
		this.studentScore = studentScore;
	}
	
	
	
	
}
