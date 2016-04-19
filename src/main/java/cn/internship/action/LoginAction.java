package cn.internship.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import cn.internship.entity.Student;
import cn.internship.service.StudentService;

/**
 * 登陆页面的相关请求与相应
 * @author dreamlate
 */
public class LoginAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;

	private StudentService studentService;

	public static String CURRENT_NAME = "";
	public static String CURRENT_NO = "";
	
	// 用户名
	private String username;
	// 密码
	private String password;
	// 验证码
	private String verifyCode;

	@Override
	public String execute() throws Exception {
		HttpSession session = request.getSession();
		// 判断session中是否已经存在用户
		if (session.getAttribute("currentUser") != null) {
			return SUCCESS;
		}
		// 清除登陆验证时提示的错误信息
		this.clearErrorsAndMessages();
		// 验证码错误
		String verifyCode2 = (String) session.getAttribute("verifyCode");
		if (verifyCode == null || "".equals(verifyCode) || !verifyCode.equalsIgnoreCase(verifyCode2)) {
			this.addActionError("输入的验证码不正确，请重新输入！");
			return INPUT;
		}

		// 用户名或者密码为空
		if (username == null || "".equals(username) || password == null || "".equals(password)) {
			this.addActionError("用户名、密码不正确！");
			return INPUT;
		}

		// 判断登陆类型
		//用户类型为学生，验证用户是否存在
		Student student = studentService.login(username, password);
		if(student == null){
			this.addActionError("用户名、密码不正确！");
			return INPUT;
		}
		//将登陆用户存到session中
		session.setAttribute("currentUser", student);
		CURRENT_NAME = student.getName();
		CURRENT_NO = student.getSno();
		return SUCCESS;
	}

	
	//注销
	public String logout(){
		request.getSession().removeAttribute("currentUser");
		return "logout";
	}
	
	// ----------------------------get与set方法--------------------------------------

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

}
