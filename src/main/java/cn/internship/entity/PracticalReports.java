package cn.internship.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by surprise on 4/9/16.
 */
@Entity
@Table(name="practical_reports")
public class PracticalReports {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, length = 14)
    private String studentId;
    @Column(length = 100)
    private String practicalReportsTitle;
    @Column(length = 1024)
    private String prcaticalReportsContent;
    private Date prcaticalReportsDate;

    public Integer getId() {
        return id;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getPracticalReportsTitle() {
        return practicalReportsTitle;
    }

    public String getPrcaticalReportsContent() {
        return prcaticalReportsContent;
    }

    public Date getPrcaticalReportsDate() {
        return prcaticalReportsDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setPracticalReportsTitle(String practicalReportsTitle) {
        this.practicalReportsTitle = practicalReportsTitle;
    }

    public void setPrcaticalReportsContent(String prcaticalReportsContent) {
        this.prcaticalReportsContent = prcaticalReportsContent;
    }

    public void setPrcaticalReportsDate(Date prcaticalReportsDate) {
        this.prcaticalReportsDate = prcaticalReportsDate;
    }
}
