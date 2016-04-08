package cn.internship.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import com.opensymphony.xwork2.ActionSupport;
import cn.internship.entity.Student;
import cn.internship.entity.User;
import cn.internship.service.StudentService;
import cn.internship.service.UserService;
import sun.print.resources.serviceui;

/**
 * 登陆验证
 * @author dreamlate
 */
public class LoginAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private StudentService studentService;
	private UserService userService;

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
		
		//验证用户是否存在
		User user = userService.login(username, password);
		if(user == null){
			this.addActionError("用户名、密码不正确！");
			return INPUT;
		}
		//获得用户权限
		int right = user.getRights();
		//权限1为学生
		if(right == 1){
			Student student = studentService.get(user.getUsername());
			if(student == null){
				this.addActionError("用户名、密码不正确！");
				return INPUT;
			}
			session.setAttribute("currentUser", student);
		}
		return SUCCESS;
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

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
