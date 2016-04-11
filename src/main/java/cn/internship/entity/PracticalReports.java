package cn.internship.entity;

import java.sql.Date;

import javax.persistence.*;
import org.hibernate.annotations.Type;

/**
 * 实训报告实体类
 * Created by surprise on 4/9/16.
 */
@Entity
@Table(name="stu_practical_reports")
public class PracticalReports {
	//主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //学生学号
    @Column(length = 14)
    private String studentId;
    //实训报告标题
    @Column(length = 100)
    private String practicalReportsTitle;
    //实训报告内容
    @Type(type="text")
    private String practicalReportsContent;
    //实训报告时间
    private Date practicalReportsDate;
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
	public String getPracticalReportsTitle() {
		return practicalReportsTitle;
	}
	public void setPracticalReportsTitle(String practicalReportsTitle) {
		this.practicalReportsTitle = practicalReportsTitle;
	}

	public String getPracticalReportsContent() {
		return practicalReportsContent;
	}

	public void setPracticalReportsContent(String practicalReportsContent) {
		this.practicalReportsContent = practicalReportsContent;
	}

	public Date getPracticalReportsDate() {
		return practicalReportsDate;
	}

	public void setPracticalReportsDate(Date practicalReportsDate) {
		this.practicalReportsDate = practicalReportsDate;
	}
}
