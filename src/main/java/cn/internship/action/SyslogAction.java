package cn.internship.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import cn.internship.entity.Student;
import cn.internship.entity.Syslog;
import cn.internship.entity.Teacher;
import cn.internship.service.StudentService;
import cn.internship.service.SyslogService;

/**
 * 系统日志的相关请求与相应
 * 
 * @author dreamlate
 */
public class SyslogAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private SyslogService syslogService;
	private StudentService studentService;

	//获得所有日志信息
	@Override
	public String execute() throws Exception {
		//获得所有日志信息
		List<Syslog> list = syslogService.getAll();
		request.setAttribute("syslogList", list);
		return super.execute();
	}
	
	//获得某个学生的日志信息
	public String stuSyslog(){
		
		Student student = (Student) request.getSession().getAttribute("currentUser");
		List<Syslog> stuList = syslogService.getAll(student.getSno());
		request.setAttribute("stuSyslogList", stuList);
	
		return SUCCESS;
	}
	
	//-----------------------------------------get与set方法-----------------------------------------------
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public SyslogService getSyslogService() {
		return syslogService;
	}

	public void setSyslogService(SyslogService syslogService) {
		this.syslogService = syslogService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	
}
