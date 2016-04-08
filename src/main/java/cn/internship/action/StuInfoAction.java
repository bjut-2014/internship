package cn.internship.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import cn.internship.entity.Student;
import cn.internship.service.StudentService;

/**
 * 学生个人信息页面
 * @author dreamlate
 */
public class StuInfoAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
   
	private HttpServletRequest request;
	private HttpServletResponse response;
	private StudentService studentService;
	
	@Override
    public String execute() throws Exception {
		Student student = (Student) request.getSession().getAttribute("currentUser");
        return super.execute();
    }
	
	//-----------------------------------get与set方法------------------------------------------------

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
}
