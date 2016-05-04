package cn.internship.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 毕设选课实体类
 * @author Sunny
 *
 */

@Entity
@Table(name="graduation_pro_sele")
public class GraduationProSele {

		//主键
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;
		//学号
		@Column(length=24,unique=true)
		private String sno;
		//教师编号
		@Column(length=24)
		private String tno;
		//毕设课题
		@Column(length=1000)
		private String GraduationProTitle;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getSno() {
			return sno;
		}
		public void setSno(String sno) {
			this.sno = sno;
		}
		public String getTno() {
			return tno;
		}
		public void setTno(String tno) {
			this.tno = tno;
		}
		public String getGraduationProTitle() {
			return GraduationProTitle;
		}
		public void setGraduationProTitle(String graduationProTitle) {
			GraduationProTitle = graduationProTitle;
		}
		@Override
		public String toString() {
			return "GraduationProSele [id=" + id + ", sno=" + sno + ", tno="
					+ tno + ", GraduationProTitle=" + GraduationProTitle + "]";
		}
		
		
}
