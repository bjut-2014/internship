package cn.internship.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.internship.entity.Syslog;
import cn.internship.entity.Teacher;
import cn.internship.service.SyslogService;
import cn.internship.service.TeacherService;

import com.opensymphony.xwork2.ActionSupport;

public class TeacherAction  extends ActionSupport implements ServletRequestAware, ServletResponseAware{

	private TeacherService teacherService;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private SyslogService syslogService;
	
	@Override
	public String execute() throws Exception {
		request.setAttribute("navId", 2);
		return super.execute();
	}
	
	//学生个人信息
	public String info(){
		request.setAttribute("navId", 2);
		Teacher teacher = (Teacher) request.getSession().getAttribute("currentUser");
		String tno = teacher.getTno();
		List<Syslog> stuSyslogList = syslogService.getAll(tno);
		request.setAttribute("stuSyslogList", stuSyslogList);
		return SUCCESS;
	} 
	
	//-----------------get与set方法--------------------------------
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public SyslogService getSyslogService() {
		return syslogService;
	}

	public void setSyslogService(SyslogService syslogService) {
		this.syslogService = syslogService;
	}
	
	

}
