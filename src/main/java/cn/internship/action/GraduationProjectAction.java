package cn.internship.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.json.JSONObject;

import cn.internship.entity.GraduationWeeklyReport;

import cn.internship.entity.Student;

import cn.internship.service.GraduationWeeklyReportService;

import com.opensymphony.xwork2.ActionSupport;

public class GraduationProjectAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private GraduationWeeklyReportService graduationWeeklyReportService;

	// ======================添加模块=======================//
	private String addTitle;
	private String addContent;

	// ======================修改模块=======================//
	private String updateTitle;
	private String updateContent;
	private int updateId;

	public GraduationWeeklyReportService getGraduationWeeklyReportService() {
		return graduationWeeklyReportService;
	}

	public void setGraduationWeeklyReportService(
			GraduationWeeklyReportService graduationWeeklyReportService) {
		this.graduationWeeklyReportService = graduationWeeklyReportService;
	}

	public String getAddTitle() {
		return addTitle;
	}

	public void setAddTitle(String addTitle) {
		this.addTitle = addTitle;
	}

	public String getAddContent() {
		return addContent;
	}

	public void setAddContent(String addContent) {
		this.addContent = addContent;
	}

	public String getUpdateTitle() {
		return updateTitle;
	}

	public void setUpdateTitle(String updateTitle) {
		this.updateTitle = updateTitle;
	}

	public String getUpdateContent() {
		return updateContent;
	}

	public void setUpdateContent(String updateContent) {
		this.updateContent = updateContent;
	}

	public int getUpdateId() {
		return updateId;
	}

	public void setUpdateId(int updateId) {
		this.updateId = updateId;
	}

	public int getDeleteId() {
		return deleteId;
	}

	public void setDeleteId(int deleteId) {
		this.deleteId = deleteId;
	}

	public int getGraduationWeeklyReportId() {
		return graduationWeeklyReportId;
	}

	public void setGraduationWeeklyReportId(int graduationWeeklyReportId) {
		this.graduationWeeklyReportId = graduationWeeklyReportId;
	}

	// ======================删除模块=======================//
	private int deleteId;

	// ======================查找周报id=====================//
	private int graduationWeeklyReportId;

	
	public String execute() throws Exception {
        //获得当前session下的学生
		Student student = (Student) request.getSession().getAttribute("currentUser");
		System.out.println(student);
		//获得指定学生的所有周报
		if( graduationWeeklyReportService.getAllGraduationWeeklyReport(student.getSno())!=null){
			List<GraduationWeeklyReport> list = graduationWeeklyReportService.getAllGraduationWeeklyReport(student.getSno());
	        request.setAttribute("graduationWeeklyReport", list);
		}
		
        return SUCCESS;
        }
	
	//添加周报
	public String add(){
		 //获得当前session下的学生
		Student student = (Student) request.getSession().getAttribute("currentUser");
		//创建实体
		GraduationWeeklyReport graduationWeeklyReport = new GraduationWeeklyReport();
		graduationWeeklyReport.setSno(student.getSno());
		graduationWeeklyReport.setTitle(addTitle);
		graduationWeeklyReport.setContent(addContent);
		graduationWeeklyReport.setDate(new Date(new java.util.Date().getTime()));
		//保存
		graduationWeeklyReportService.saveGraduationWeeklyReport(graduationWeeklyReport);
		return SUCCESS;
	}
	
	//删除周报
	public String delete(){
		graduationWeeklyReportService.deleteGraduationWeeklyReport(deleteId);
		return SUCCESS;
	}
	
	//获取周报
	public String getOneWeeklyReport(){
		GraduationWeeklyReport oneWeeklyReport=graduationWeeklyReportService.getGraduationWeeklyReport(graduationWeeklyReportId);
		request.setAttribute("oneWeeklyReport", oneWeeklyReport);
		return SUCCESS;
	}
	
	
	//查找某一条周报
	public String get() throws Exception {
        GraduationWeeklyReport oneWeeklyReport = graduationWeeklyReportService.getGraduationWeeklyReport(graduationWeeklyReportId);
        request.setAttribute("updateReport", oneWeeklyReport);
       return SUCCESS;
	}
	//更新周报
	public String update(){
		GraduationWeeklyReport graduationWeeklyReport=graduationWeeklyReportService.getGraduationWeeklyReport(graduationWeeklyReportId);
		
		graduationWeeklyReport.setTitle(updateTitle);
		graduationWeeklyReport.setContent(updateContent);
		graduationWeeklyReport.setDate(new Date(new java.util.Date().getTime()));
		graduationWeeklyReportService.updateGraduationWeeklyReport(graduationWeeklyReport);
		
		return SUCCESS;
	}
	
	
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
