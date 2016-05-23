package cn.internship.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import cn.internship.entity.Admin;
import cn.internship.service.AdminService;

/**
 * 管理员登陆的相关请求与操作
 * @author dreamlate
 *
 */
public class AdminLoginAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;

	private AdminService adminService;

	// 登陆相关信息
	private String username;
	private String password;
	private String verifyCode;

	//登陆
	@Override
	public String execute() throws Exception {
		HttpSession session = request.getSession();
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
			this.addActionError("用户名或密码为空！");
			return INPUT;
		}

		Admin admin = adminService.login(username, password);

		// 密码错误
		if (admin == null) {
			this.addActionError("用户名或密码不正确！");
			return INPUT;
		}
		// 将登陆用户存到session中
		session.setAttribute("currentUser", admin);
		session.setAttribute("userType", 1);
		return SUCCESS;
	}

	//注销
	public String logout() {
		request.getSession().removeAttribute("currentUser");
		adminService.logout();
		return "adminLogout";
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
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
