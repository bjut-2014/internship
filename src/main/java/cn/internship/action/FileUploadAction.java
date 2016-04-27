package cn.internship.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.internship.entity.InternshipReport;
import cn.internship.entity.Student;
import cn.internship.service.InternshipReportService;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private InternshipReportService ir;
	
	public InternshipReportService getIr() {
		return ir;
	}

	public void setIr(InternshipReportService ir) {
		this.ir = ir;
	}

	//上传实习报告
	private File upload;
	//上传实习报告类型
	private String uploadContentType;
	//实习报告名称
	private String uploadFileName;
	//实习报告保存路径
	private String filePath;
	
	
	private String result;

	
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}



	public String getUploadContextType() {
		return uploadContentType;
	}

	public void setUploadContextType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public String execute() throws IOException{
		System.out.println("Action started");
		//获取当前学生
		//获得当前session下的学生
		Student student = (Student) request.getSession().getAttribute("currentUser");
		InternshipReport internshipReport=new InternshipReport();
		internshipReport.setSno(student.getSno());
		//internshipReport.setSno("S02");
		internshipReport.setDate(new Date(new java.util.Date().getTime()));
		String path=ServletActionContext.getServletContext().getRealPath("/InternshipReport");
		
		System.out.println(path);
		//判断一下该文件夹是否存在,如果不存在则直接创建
		File file=new File(path);
		if(!file.exists()){
			file.mkdir();
		}
		filePath=path+'\\'+uploadFileName;
		FileUtils.copyFile(upload, new File(file,uploadFileName));
		System.out.println(uploadFileName);
		internshipReport.setTitle(uploadFileName);
		internshipReport.setPath(filePath);
		
		request.setAttribute("uploadFileName", uploadFileName);
		
		ir.saveInternshipReport(internshipReport);
		return SUCCESS;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
}
