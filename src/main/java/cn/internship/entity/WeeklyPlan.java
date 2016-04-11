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
 * 学生周报实体类
 * @author dreamlate
 */
@Entity
@Table(name="stu_weeklyplan")
public class WeeklyPlan {

	//主键
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	//学生学号，依赖学号查找周报
	@Column(length=14)
	private String studentId;
	//周报标题
	@Column(length=40)
	private String weeklyplanTitle;
	//周报日期
	private Date weeklyplanDate;
	//周报内容
	@Type(type="text")
	private String weeklyplanContent;
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
	public String getWeeklyplanTitle() {
		return weeklyplanTitle;
	}
	public void setWeeklyplanTitle(String weeklyplanTitle) {
		this.weeklyplanTitle = weeklyplanTitle;
	}
	public Date getWeeklyplanDate() {
		return weeklyplanDate;
	}
	public void setWeeklyplanDate(Date weeklyplanDate) {
		this.weeklyplanDate = weeklyplanDate;
	}
	public String getWeeklyplanContent() {
		return weeklyplanContent;
	}
	public void setWeeklyplanContent(String weeklyplanContent) {
		this.weeklyplanContent = weeklyplanContent;
	}
	
	
	
}
