package cn.internship.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	
	//主键
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer courseId;
	//课程名字
	private String name;
	//选课的老师
	@ManyToOne(targetEntity=Teacher.class)
	@JoinColumn(name="teacherId",referencedColumnName="teacherId",nullable=false)
	private Teacher teacher;
	//选课的学生集合
	@ManyToMany(targetEntity=Student.class)
	@JoinTable(name="student_course",
						joinColumns=@JoinColumn(name="courseId",referencedColumnName="courseId"),
						inverseJoinColumns=@JoinColumn(name="studentId",referencedColumnName="studentId"))
	private Set<Student> students = new HashSet<>();
	
	//课程对应的案例库
	@OneToMany(targetEntity=CaseLibrary.class,mappedBy="course")
	private Set<CaseLibrary> caseLibraries = new HashSet<CaseLibrary>();
	//上课时间
	private String courseDate;
	//上课地点
	private String coursePlace;
	
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public Set<CaseLibrary> getCaseLibraries() {
		return caseLibraries;
	}
	public void setCaseLibraries(Set<CaseLibrary> caseLibraries) {
		this.caseLibraries = caseLibraries;
	}
	public String getCourseDate() {
		return courseDate;
	}
	public void setCourseDate(String courseDate) {
		this.courseDate = courseDate;
	}
	public String getCoursePlace() {
		return coursePlace;
	}
	public void setCoursePlace(String coursePlace) {
		this.coursePlace = coursePlace;
	}
	
	
}