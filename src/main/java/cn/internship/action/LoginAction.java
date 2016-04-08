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
 * 登陆验证
 * @author dreamlate
 */
public class LoginAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private StudentService studentService;

	// 用户名
	private String username;
	// 密码
	private String password;
	// 验证码
	private String checkCode;

	
	/**
	 * 登陆验证，区分学生、教师和管理员三种权限
	 * 验证成功后，跳转至相应的页面
	 */
	public String loginValidate(){
		HttpSession session = request.getSession();
		//判断session中是否已经存在用户
		if(session.getAttribute("currentUser")!=null){
			return SUCCESS;
		}
		//清除登陆验证时提示的错误信息
		this.clearErrorsAndMessages();
		//验证码错误
		String checkCode2 = (String) session.getAttribute("checkCode");
		if(checkCode==null||"".equals(checkCode)||!checkCode.equals(checkCode2)){
			this.addActionError("输入的验证码不正确，请重新输入！");
			return INPUT;
		}
		//用户名或者密码错误
		if(username==null||"".equals(username)
		||password==null||"".equals(password)){
			this.addActionError("用户名、密码不正确！");
			return INPUT;
		}
		//判断用户类型
		char userType = username.charAt(0);
		//类型为学生
		if(userType == 'S'){
			Student student = studentService.login(username, password);
			if(student == null){
				this.addActionError("用户名、密码不正确！");
				return INPUT;
			}
			//将登陆成功的学生存入session
			session.setAttribute("currentUser", student);
			return SUCCESS;
		}
		return INPUT;
	}

	
	//注销
	public String  logout(){
		request.getSession().removeAttribute("currentUser");
		return "logout";
	}
	
	
	//-------------------------------------------set与get方法-------------------------------------------------
	
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

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
