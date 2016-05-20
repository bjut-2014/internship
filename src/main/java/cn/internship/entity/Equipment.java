package cn.internship.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 设备实体类
 * @author dreamlate
 *
 */
@Entity
@Table(name="equipment")
public class Equipment {

	//主键
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer equipmentId;
	//编号
	private String eno;
	//名称
	private String name;
	//拥有者
	private String owner;
	//状态
	private String state;
	//借出时间
	private Date lendDate;
	//归还时间
	private Date returnDate;
	//借用人
	private String people;
	//教师主键
	private Integer teacherId;
	//是否在历史记录里面
	private Boolean isHistory;
	
	public Integer getEquipmentId() {
		return equipmentId;
	}
	public void setEquipmentId(Integer equipmentId) {
		this.equipmentId = equipmentId;
	}
	public String getEno() {
		return eno;
	}
	public void setEno(String eno) {
		this.eno = eno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getLendDate() {
		return lendDate;
	}
	public void setLendDate(Date lendDate) {
		this.lendDate = lendDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public Boolean getIsHistory() {
		return isHistory;
	}
	public void setIsHistory(Boolean isHistory) {
		this.isHistory = isHistory;
	}
	
}
