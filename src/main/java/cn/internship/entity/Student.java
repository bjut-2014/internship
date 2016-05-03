package cn.internship.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 学生实体类
 * @author dreamlate
 */
@Entity
@Table(name="student")
public class Student {
	//主键
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer studentId;
	//学号
	@Column(length=24,unique=true)
	private String sno;
	//姓名
	@Column(length=24)
	private String name;
	//性别
	private Integer sex;
	//年级
	private Integer grade;
	//班级
	@Column(length=24)
	private String classes;
	//电话
	@Column(length=24)
	private String phone;
	//电子邮件
	@Column(length=100)
	private String email;
	//密码
	@Column(length=100)
	private String password;
	//用户类型：该实体为学生
	private Integer userType;
	//学生选择的课程集合
	@ManyToMany(targetEntity=Course.class)
	@JoinTable(name="student_course",
						joinColumns=@JoinColumn(name="studentId",referencedColumnName="studentId"),
						inverseJoinColumns=@JoinColumn(name="courseId",referencedColumnName="courseId"))
	private Set<Course> courses = new HashSet<>();
	
	
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	
	
}