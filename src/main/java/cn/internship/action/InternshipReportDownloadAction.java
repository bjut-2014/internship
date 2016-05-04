package cn.internship.action;



import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import cn.internship.entity.InternshipReport;
import cn.internship.service.InternshipReportService;
import cn.internship.service.impl.InternshipReportServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

//文件下载
public class InternshipReportDownloadAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	private String fileName;

	private InternshipReportService internshipReportService;
	
	//根据学号查询实习报告信息
	private String studentId;
	
	//返回一个输入流，作为一个客户端来说是一个输入流，但对于服务器端是一个 输出流
	public InputStream getDownloadFile() throws Exception
	{
		
		
		try{
			InternshipReport ir=internshipReportService.getInternshipReport(studentId);
			//设置保存文件名
			this.fileName = ir.getTitle();
			fileName = new String(fileName.getBytes(), "ISO8859-1");
			//获取资源路径
			String path=ir.getPath();
		    InputStream in= ServletActionContext.getServletContext().getResourceAsStream(path) ;
			System.out.println(in);
		    return in;
		
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		
		}
			
			
		
		
	}
	
	@Override
	public String execute() throws Exception {
	
		InternshipReport ir=internshipReportService.getInternshipReport(studentId);
		System.out.println(ir);
		if(ir!=null){
			return SUCCESS;
		}else{
			return "FileNotFound";
		}
		
	}

	
	
	//=========================================getter/setter方法===============================
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public InternshipReportService getInternshipReportService() {
		return internshipReportService;
	}

	public void setInternshipReportService(
			InternshipReportService internshipReportService) {
		this.internshipReportService = internshipReportService;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	

}
