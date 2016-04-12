package cn.internship.action;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.internship.entity.InternshipReport;
import cn.internship.entity.Student;
import cn.internship.service.InternshipReportService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 实习报告页面
 * @author MengHan
 */
public class StuInternshipReportsAction extends ActionSupport  implements ServletRequestAware, ServletResponseAware {
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private InternshipReportService internshipReportService;
	
	//实习报告的详细信息
	private String internshipreportTitle;
	private String internshipBeginTime;
	private String intershipEndTime;
	private String internshipCompany;
	private String internshipDepartment;
	private String internshipPlace;
	private String internshipSummary;
	
	@Override
	public String execute() throws Exception {
		//获得当前session下的学生
		Student student = (Student) request.getSession().getAttribute("currentUser");
		InternshipReport internshipReport = internshipReportService.get(student.getStudentId());
		if(internshipReport == null){
			return INPUT;
		}
		request.setAttribute("internshipReport", internshipReport);
		return super.execute();
	}
	
	//写实习报告
	public String add(){
		//获得当前session下的学生
		Student student = (Student) request.getSession().getAttribute("currentUser");
		//将String类型的时间转换成Date类型
		SimpleDateFormat sdf =  new SimpleDateFormat( "yyyy/MM/dd");
		Date beginTime = null;
		Date endTime = null;
		try {
			beginTime = new Date(sdf.parse(internshipBeginTime).getTime());
			endTime = new Date(sdf.parse(intershipEndTime).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//插入实习报告的详细信息
		InternshipReport internshipReport = new InternshipReport();
		internshipReport.setStudentId(student.getStudentId());
		internshipReport.setInternshipreportTitle(internshipreportTitle);
		internshipReport.setInternshipBeginTime(beginTime);
		internshipReport.setInternshipEndTime(endTime);
		internshipReport.setInternshipCompany(internshipCompany);
		internshipReport.setInternshipDepartment(internshipDepartment);
		internshipReport.setInternshipPlace(internshipPlace);
		internshipReport.setInternshipSummary(internshipSummary);
		internshipReportService.save(internshipReport);
		return SUCCESS;
	}
	
	//修改实习报告
	public String update(){
		//获得当前session下的学生
		Student student = (Student) request.getSession().getAttribute("currentUser");
		//获得要修改的实习周报
		InternshipReport internshipReport = internshipReportService.get(student.getStudentId());
		internshipReport.setInternshipreportTitle(internshipreportTitle);
		//将String类型的时间转换成Date类型
		SimpleDateFormat sdf =  new SimpleDateFormat( "yyyy/MM/dd");
		Date beginTime = null;
		Date endTime = null;
		try {
			beginTime = new Date(sdf.parse(internshipBeginTime.toString()).getTime());
			endTime = new Date(sdf.parse(intershipEndTime.toString()).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		internshipReport.setInternshipBeginTime(beginTime);
		internshipReport.setInternshipEndTime(endTime);
		internshipReport.setInternshipCompany(internshipCompany);
		internshipReport.setInternshipDepartment(internshipDepartment);
		internshipReport.setInternshipPlace(internshipPlace);
		internshipReport.setInternshipSummary(internshipSummary);
		internshipReportService.update(internshipReport);
		return SUCCESS;
	}
	
	//获得要修改的实习报告
	public String get(){
		//获得当前session下的学生
		Student student = (Student) request.getSession().getAttribute("currentUser");
		InternshipReport internshipReport = internshipReportService.get(student.getStudentId());
		request.setAttribute("internshipReport", internshipReport);
		return SUCCESS;
	}
	
	//------------------------------------------------get与set方法----------------------------------------------------
	
	
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}


	public InternshipReportService getInternshipReportService() {
		return internshipReportService;
	}


	public void setInternshipReportService(
			InternshipReportService internshipReportService) {
		this.internshipReportService = internshipReportService;
	}

	public String getInternshipreportTitle() {
		return internshipreportTitle;
	}

	public void setInternshipreportTitle(String internshipreportTitle) {
		this.internshipreportTitle = internshipreportTitle;
	}

	public String getInternshipBeginTime() {
		return internshipBeginTime;
	}

	public void setInternshipBeginTime(String internshipBeginTime) {
		this.internshipBeginTime = internshipBeginTime;
	}

	public String getIntershipEndTime() {
		return intershipEndTime;
	}

	public void setIntershipEndTime(String intershipEndTime) {
		this.intershipEndTime = intershipEndTime;
	}

	public String getInternshipCompany() {
		return internshipCompany;
	}

	public void setInternshipCompany(String internshipCompany) {
		this.internshipCompany = internshipCompany;
	}

	public String getInternshipDepartment() {
		return internshipDepartment;
	}

	public void setInternshipDepartment(String internshipDepartment) {
		this.internshipDepartment = internshipDepartment;
	}

	public String getInternshipPlace() {
		return internshipPlace;
	}

	public void setInternshipPlace(String internshipPlace) {
		this.internshipPlace = internshipPlace;
	}

	public String getInternshipSummary() {
		return internshipSummary;
	}

	public void setInternshipSummary(String internshipSummary) {
		this.internshipSummary = internshipSummary;
	}

}
