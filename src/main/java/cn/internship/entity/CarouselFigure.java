package cn.internship.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * 轮播图实体类
 * @author MengHan
 *
 */
@Entity
@Table(name="carousel_figure")
public class CarouselFigure {

	//主键
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer carouselFigureId;
	//标题
	private String title;
	//时间
	private Date date;
	//内容
	@Type(type="text")
	private String content;
	//图片名
	private String pictureName;
	//图片路径
	private String path;
	public Integer getCarouselFigureId() {
		return carouselFigureId;
	}
	public void setCarouselFigureId(Integer carouselFigureId) {
		this.carouselFigureId = carouselFigureId;
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
	public String getPictureName() {
		return pictureName;
	}
	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
