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
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	
	//主键
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	//课程名字
	private String name;
	//选课的老师
	@ManyToOne(targetEntity=Teacher.class)
	@JoinColumn(name="id",referencedColumnName="teacherId",nullable=false)
	private Teacher teacher;
	//选课的学生集合
	@ManyToMany(targetEntity=Student.class)
	@JoinTable(name="student_course",
						joinColumns=@JoinColumn(name="id",referencedColumnName="courseId"),
						inverseJoinColumns=@JoinColumn(name="id",referencedColumnName="studentId"))
	private Set<Integer> studentId = new HashSet<>();
}
