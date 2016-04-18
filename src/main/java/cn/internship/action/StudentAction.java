package cn.internship.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import cn.internship.service.StudentService;

/**
 * 学生相关请求及相应
 * @author dreamlate
 */
public class StudentAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{

	private StudentService studentService;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	@Override
	public String execute() throws Exception {
		return super.execute();
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
	
}
