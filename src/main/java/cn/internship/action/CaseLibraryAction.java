package cn.internship.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import cn.internship.service.CaseLibraryService;

/**
 * 案例库的相关请求与操作
 * @author dreamlate
 */
public class CaseLibraryAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{

	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private CaseLibraryService caseLibraryService;
	
	@Override
	public String execute() throws Exception {
		return super.execute();
	}

	
	//------------------------get与set方法--------------------------------------
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public CaseLibraryService getCaseLibraryService() {
		return caseLibraryService;
	}

	public void setCaseLibraryService(CaseLibraryService caseLibraryService) {
		this.caseLibraryService = caseLibraryService;
	}
	
	
	
}
