package cn.internship.action;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 文件下载的相关操作
 * @author MengHan
 */
public class FileDownloadAction extends ActionSupport{

	String fileName;
//	String filePath;
	String baseFloder;
	
	public InputStream getDownloadFile() throws Exception {
		System.out.println(fileName);
//		System.out.println(filePath);
		System.out.println(baseFloder);
		//解决文件名乱码
//		fileName = new String(fileName.getBytes(), "ISO8859-1");
		
//		return ServletActionContext.getServletContext().getResourceAsStream(
//				"/S201425057/"+fileName);
		InputStream in = ServletActionContext.getServletContext().getResourceAsStream(
				baseFloder + fileName);
		fileName = new String(fileName.getBytes(), "ISO8859-1");
		return in;
	}
	
	@Override
	public String execute() throws Exception {
		return super.execute();
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

//	public String getFilePath() {
//		return filePath;
//	}
//
//	public void setFilePath(String filePath) {
//		this.filePath = filePath;
//	}

	public String getBaseFloder() {
		return baseFloder;
	}

	public void setBaseFloder(String baseFloder) {
		this.baseFloder = baseFloder;
	}
	
	
	
}
