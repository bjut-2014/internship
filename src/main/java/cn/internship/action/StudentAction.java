package cn.internship.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import cn.internship.entity.Student;
import cn.internship.entity.Syslog;
import cn.internship.service.StudentService;
import cn.internship.service.SyslogService;

/**
 * 学生相关请求及相应
 * @author dreamlate
 */
public class StudentAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{

	private StudentService studentService;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private SyslogService syslogService;
	
	
	@Override
	public String execute() throws Exception {
		return super.execute();
	}

	//学生个人信息
	public String info(){
		Student student = (Student) request.getSession().getAttribute("currentUser");
		String sno = student.getSno();
		List<Syslog> stuSyslogList = syslogService.getAll(sno);
		request.setAttribute("stuSyslogList", stuSyslogList);
		return SUCCESS;
	}
	
	//----------------------------get与set方法--------------------------------------
	
	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

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

	
}
