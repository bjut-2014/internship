package cn.internship.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import cn.internship.entity.Student;
import cn.internship.entity.User;
import cn.internship.service.UserService;

/**
 * 修改密码页面
 * Created by surprise on 4/6/16.
 */
public class ResetPwdAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private UserService userService;
	
	//初始密码
	private String password;
	//新密码
	private String newpwd;
	//确认密码
	private String renewpwd;
	
    @Override
    public String execute() throws Exception {
        return super.execute();
    }
    
    //修改密码
    public String chpwd(){
    	Student student = (Student) request.getSession().getAttribute("currentUser");
    	//清除修改密码时提示的错误信息
    	this.clearErrorsAndMessages();
    	//获得当前用户的密码
    	User user = userService.findUserByUsername(student.getStudentId());
    	String userPwd = user.getPassword();
    	if(password == null || !userPwd.equals(password)){
    		this.addActionError("初始密码错误");
    		return INPUT;
    	}
    	if(newpwd == null || "".equals(newpwd) || renewpwd == null || "".equals(renewpwd)){
    		this.addActionError("密码不能为空");
    		return INPUT;
    	}
    	if(!newpwd.equals(renewpwd)){
    		this.addActionError("两次密码不一至");
    		return INPUT;
    	}
    	//更改密码
    	user.setPassword(newpwd);
    	userService.updatePwd(user);
    	//移除当前session中的student
    	request.getSession().removeAttribute("currentUser");
    	return SUCCESS;
    }
    
    
    //-------------------------------------get与set方法-------------------------------------------

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewpwd() {
		return newpwd;
	}

	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}

	public String getRenewpwd() {
		return renewpwd;
	}

	public void setRenewpwd(String renewpwd) {
		this.renewpwd = renewpwd;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
    
	
	
}
