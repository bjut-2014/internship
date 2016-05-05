package cn.internship.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.internship.entity.InternshipDetail;
import cn.internship.entity.Student;
import cn.internship.entity.Teacher;
import cn.internship.entity.WeeklyReport;

import cn.internship.service.InternshipDetailService;
import cn.internship.service.StudentService;
import cn.internship.service.WeeklyReportService;

import com.opensymphony.xwork2.ActionSupport;

public class TeacherWeeklyReportAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	

	private WeeklyReportService weeklyReportService;
	private InternshipDetailService internshipDetailService;
	private StudentService studentService;
	
	//通过学生学号sno查询该学生的所有周报
	private String studentId;
	//通过主键查询周报
	private Integer weeklyReportId;
	
	//显示所有实习的学生
	@Override
	public String execute() throws Exception {
		request.setAttribute("navId", 4);
		//获得当前用户
		Teacher teacher=(Teacher) request.getSession().getAttribute("currentUser");
		//获得当前正在实习的所有学生
		if(internshipDetailService.getAllStudents()!=null){
			List<InternshipDetail> list=internshipDetailService.getAllStudents();
			List<Student> students=new ArrayList<Student>();
			for(InternshipDetail it:list){
				String sno=it.getSno();
				Student st=studentService.get(sno);
				students.add(st);
			}
			if(students!=null){
				request.setAttribute("students", students);
			}
		}
		return super.execute();
	}
	
	//通过学号获取该学生的所有周报
	public String getOneStudentWeeklyReports(){
		request.setAttribute("navId", 4);
		List<WeeklyReport> weeklyReportList=weeklyReportService.getAllWeeklyReport(studentId);
		if(weeklyReportList!=null){
			request.setAttribute("weeklyReportList", weeklyReportList);
		}
		return SUCCESS;
	}
	
	//通过周报Id获取一条周报
	public String queryOneWeeklyReport(){
		request.setAttribute("navId", 4);
		WeeklyReport wr=weeklyReportService.getWeeklyReport(weeklyReportId);
		request.setAttribute("weeklyReport", wr);
		return SUCCESS;
	}
	
	
	
	//========================================getter和setter===================================
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}

	

	public WeeklyReportService getWeeklyReportService() {
		return weeklyReportService;
	}

	public void setWeeklyReportService(WeeklyReportService weeklyReportService) {
		this.weeklyReportService = weeklyReportService;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public Integer getWeeklyReportId() {
		return weeklyReportId;
	}

	public void setWeeklyReportId(Integer weeklyReportId) {
		this.weeklyReportId = weeklyReportId;
	}

	public InternshipDetailService getInternshipDetailService() {
		return internshipDetailService;
	}

	public void setInternshipDetailService(
			InternshipDetailService internshipDetailService) {
		this.internshipDetailService = internshipDetailService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	

}
