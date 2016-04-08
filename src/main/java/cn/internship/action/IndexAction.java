package cn.internship.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import com.opensymphony.xwork2.ActionSupport;
import cn.internship.entity.User;
import cn.internship.service.StudentService;
import cn.internship.service.UserService;

/**
 * 首页
 * @author dreamlate
 */
public class IndexAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	private HttpServletRequest request;
	private HttpServletResponse response;
	
	@Override
	public String execute() throws Exception {
		return super.execute();
	}
	
	
	//-------------------------------------------set与get方法-------------------------------------------------
	
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}


	
}
