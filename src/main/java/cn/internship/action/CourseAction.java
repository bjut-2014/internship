package cn.internship.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import com.opensymphony.xwork2.ActionSupport;

import cn.internship.entity.Course;
import cn.internship.entity.Student;
import cn.internship.service.CourseService;

/**
 * 课程页面的相关请求与操作
 * @author dreamlate
 */
public class CourseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{

	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private CourseService courseService;
	
	
	@Override
	public String execute() throws Exception {
		Student student = (Student) request.getSession().getAttribute("currentUser");
		Integer studentId = student.getStudentId();
		List<Course> courseList = courseService.getBySno(studentId);
		request.setAttribute("courseList", courseList);
		return super.execute();
	}
	
	//-------------------------------------------------get与set方法-------------------------------------------
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	
	
}
