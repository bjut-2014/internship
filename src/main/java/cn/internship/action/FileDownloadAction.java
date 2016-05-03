package cn.internship.action;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileDownloadAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String filePath;
	
	
	@Override
	public String execute() throws Exception {
		System.out.println("Action");
		return SUCCESS;
	}
	
	public InputStream getInputStream(){
		return ServletActionContext.getServletContext().getResourceAsStream(filePath);
	}
	

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
}
