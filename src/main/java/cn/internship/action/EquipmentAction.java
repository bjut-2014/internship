package cn.internship.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import cn.internship.service.EquipmentService;

public class EquipmentAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{

	private EquipmentService equipmentService;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	@Override
	public String execute() throws Exception {
		return super.execute();
	}
	
	
	//----------------------------------get与set------------------------------------------
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public EquipmentService getEquipmentService() {
		return equipmentService;
	}

	public void setEquipmentService(EquipmentService equipmentService) {
		this.equipmentService = equipmentService;
	}

}
