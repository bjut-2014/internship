package cn.internship.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.internship.entity.Student;
import cn.internship.entity.Teacher;
import cn.internship.entity.WeeklyReport;
import cn.internship.service.CourseService;
import cn.internship.service.WeeklyReportService;

import com.opensymphony.xwork2.ActionSupport;

public class TeacherWeeklyReportAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private CourseService courseService;
	private WeeklyReportService weeklyReportService;
	
	//通过学生学号sno查询该学生的所有周报
	private String studentId;
	//通过主键查询周报
	private Integer weeklyReportId;
	
	//显示所有实习的学生
	@Override
	public String execute() throws Exception {
		//获得当前用户
		Teacher teacher=(Teacher) request.getSession().getAttribute("currentUser");
		//获得当前正在实习的所有学生,暂时假定实训课程的课程Id为1
		if(courseService.getStudentsByCourseId(1)!=null){
			List<Student> students=courseService.getStudentsByCourseId(1);
			request.setAttribute("students", students);
		}
		return super.execute();
	}
	
	public String getOneStudentWeeklyReports(){
		List<WeeklyReport> weeklyReportList=weeklyReportService.getAllWeeklyReport(studentId);
		if(weeklyReportList!=null){
			request.setAttribute("weeklyReportList", weeklyReportList);
		}
		return SUCCESS;
	}
	
	public String queryOneWeeklyReport(){
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

	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
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
	
	

}
