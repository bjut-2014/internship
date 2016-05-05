package cn.internship.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * 招聘信息实体类
 * @author MengHan
 *
 */
@Entity
@Table(name="recruit_info")
public class RecruitInfo {

	//主键
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer recruitInfoId;
	//标题
	private String title;
	//时间
	private Date date;
	//内容
	@Type(type="text")
	private String content;
	public Integer getRecruitInfoId() {
		return recruitInfoId;
	}
	public void setRecruitInfoId(Integer recruitInfoId) {
		this.recruitInfoId = recruitInfoId;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
