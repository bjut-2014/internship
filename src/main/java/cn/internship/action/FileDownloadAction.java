package cn.internship.action;



import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

//文件下载
public class FileDownloadAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	private String fileName;

	
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	//返回一个输入流，作为一个客户端来说是一个输入流，但对于服务器端是一个 输出流
	public InputStream getDownloadFile() throws Exception
	{
		
	
		   this.fileName = "weekly_report111.doc" ;
		   //获取资源路径
	   InputStream in= ServletActionContext.getServletContext().getResourceAsStream("\\InternshipReport\\weekly_report.doc") ;
		System.out.println(in);
	   return in;
		
	}
	
	@Override
	public String execute() throws Exception {
	
		return SUCCESS;
	}

}
