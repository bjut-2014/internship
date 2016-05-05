package cn.internship.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.internship.entity.GraduationProSele;
import cn.internship.entity.GraduationWeeklyReport;
import cn.internship.entity.Student;
import cn.internship.entity.Teacher;
import cn.internship.entity.WeeklyReport;

import cn.internship.service.GraduationSelectionService;
import cn.internship.service.GraduationWeeklyReportService;
import cn.internship.service.StudentService;
import cn.internship.service.WeeklyReportService;

import com.opensymphony.xwork2.ActionSupport;

public class TeacherGraduationWeeklyReportAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private GraduationSelectionService graduationSelectionService;
	private GraduationWeeklyReportService graduationWeeklyReportService;
	private StudentService studentService;
	
	//通过学生学号sno查询该学生的所有周报
	private String studentId;
	//通过主键查询周报
	private Integer graduationWeeklyReportId;
	
	//显示当前教师所带毕设学生
	@Override
	public String execute() throws Exception {
		//获得当前用户
		Teacher teacher=(Teacher) request.getSession().getAttribute("currentUser");
		List<GraduationProSele> list=graduationSelectionService.getSelectInfoByTno(teacher.getTno());
		List<Student> students=new ArrayList<Student>();
		//获得当前教师所带的毕设学生
		for(GraduationProSele gps:list){
			String sno=gps.getSno();
			Student stw=studentService.get(sno);
			students.add(stw);
		}
		if(students!=null){
			request.setAttribute("students",students);
		}
		return SUCCESS;
	}
	
	//通过学号获取该学生的所有毕设周报
	public String getOneStudentWeeklyReports(){
		List<GraduationWeeklyReport> graduationWeeklyReportList=graduationWeeklyReportService.getAllGraduationWeeklyReport(studentId);
		if(graduationWeeklyReportList!=null){
			request.setAttribute("graduationWeeklyReportList", graduationWeeklyReportList);
		}
		return SUCCESS;
	}
	
	//通过周报Id获取一条周报
	public String queryOneGraduationWeeklyReport(){
		GraduationWeeklyReport gr=graduationWeeklyReportService.getGraduationWeeklyReport(graduationWeeklyReportId);
		request.setAttribute("graduationWeeklyReport", gr);
		return SUCCESS;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}

	public GraduationSelectionService getGraduationSelectionService() {
		return graduationSelectionService;
	}

	public void setGraduationSelectionService(
			GraduationSelectionService graduationSelectionService) {
		this.graduationSelectionService = graduationSelectionService;
	}

	public GraduationWeeklyReportService getGraduationWeeklyReportService() {
		return graduationWeeklyReportService;
	}

	public void setGraduationWeeklyReportService(
			GraduationWeeklyReportService graduationWeeklyReportService) {
		this.graduationWeeklyReportService = graduationWeeklyReportService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public Integer getGraduationWeeklyReportId() {
		return graduationWeeklyReportId;
	}

	public void setGraduationWeeklyReportId(Integer graduationWeeklyReportId) {
		this.graduationWeeklyReportId = graduationWeeklyReportId;
	}
}
	
	
