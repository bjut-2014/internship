package cn.internship.action;

import java.io.File;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import cn.internship.entity.CaseLibrary;
import cn.internship.entity.Course;
import cn.internship.entity.Homework;
import cn.internship.entity.Student;
import cn.internship.entity.Teacher;
import cn.internship.service.CaseLibraryService;
import cn.internship.service.CourseService;

/**
 * 案例库的相关请求与操作
 * @author dreamlate
 */
public class CaseLibraryAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{

	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private CaseLibraryService caseLibraryService;
	private CourseService courseService;
	
	//待上传文件的各种信息
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	//选的课程的ID
	private Integer courseId;
	
	@Override
	public String execute() throws Exception {
		//当前的用户
		Teacher teacher = (Teacher) request.getSession().getAttribute("currentUser");
		//当前的课程
		Course course = courseService.get(courseId);
		request.setAttribute("courseId",courseId );
		//需要保存的路径
		String folderPath = "/upload/caselibrary/"+course.getName()+"/";
		//文件实际路径
		String realPath = ServletActionContext.getServletContext().getRealPath(folderPath);
		System.out.println(folderPath);
		System.out.println(realPath);
		//上传文件
		if(upload!=null){
			File saveFile = new File(new File(realPath),uploadFileName);
			if(!saveFile.getParentFile().exists()){
				saveFile.getParentFile().mkdirs();
			}
			FileUtils.copyFile(upload, saveFile);
			
			CaseLibrary caseLibrary = new CaseLibrary();
			caseLibrary.setDate(new Date(new java.util.Date().getTime()));
			caseLibrary.setName(uploadFileName);
			caseLibrary.setFilePath(folderPath);
			caseLibrary.setCourse(course);
			caseLibraryService.saveCaseLibrary(caseLibrary);
			return super.execute();
		}
		return INPUT;
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


	public File getUpload() {
		return upload;
	}


	public void setUpload(File upload) {
		this.upload = upload;
	}


	public String getUploadContentType() {
		return uploadContentType;
	}


	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}


	public String getUploadFileName() {
		return uploadFileName;
	}


	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}


	public Integer getCourseId() {
		return courseId;
	}


	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}


	public CourseService getCourseService() {
		return courseService;
	}


	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	
	
	
}
