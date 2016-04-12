package cn.internship.action;

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
	
	
	//-----------------------get与set方法------------------------
	
	
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

}
