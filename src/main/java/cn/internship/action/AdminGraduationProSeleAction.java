package cn.internship.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.internship.entity.GraduationProSele;
import cn.internship.entity.Student;
import cn.internship.entity.Teacher;
import cn.internship.service.GraduationSelectionService;
import cn.internship.service.StudentService;
import cn.internship.service.TeacherService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 管理员模块毕设选题信息的相关请求与操作
 * @author Sunny
 *
 */
public class AdminGraduationProSeleAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;	
	
	private GraduationSelectionService graduationSelectionService;
	private StudentService studentService;
	private TeacherService teacherService;
	
	//=====================================添加毕设选题信息==================================
	private String addGraduationProTitle;
	private String addSno;
	private String addTno;
	
	//=====================================修改毕设选题信息==================================
	private String updateGraduationProTitle;
	private String updateSno;
	private String updateTno;
	
	//===================================根据主键删除毕设选题信息==============================
	private Integer deleteId;
	
	//===================================根据主键查询毕设选题信息==============================
	private Integer graduationProSeleId;
	
	@Override
	public String execute() throws Exception {
		request.setAttribute("navId", 4);
		
		List<GraduationProSele> list=graduationSelectionService.getAllSelectInfo();
		if(list!=null){
			request.setAttribute("AllSelectInfo", list);
		}
		
		return super.execute();
	}
	
	
	//添加一条毕设选题信息
	public String addSelectInfo(){
		request.setAttribute("navId", 4);
		
//		GraduationProSele gr=new GraduationProSele();
		
		
		//查询添加的学生学号及教师编号是否存在
		System.out.println(addSno);
		System.out.println(addTno);
		Teacher tc=teacherService.get(addTno);
		System.out.println(tc);
		Student st=studentService.get(addSno);
		System.out.println(st);
		
		
		if(st!=null && tc!=null){
			GraduationProSele gr=new GraduationProSele();
			
			gr.setSno(addSno);
			gr.setTno(addTno);
			gr.setGraduationProTitle(addGraduationProTitle);
			graduationSelectionService.addSelectInfo(gr);
			request.setAttribute("add", "addSuccess");
			return SUCCESS;
		}else{
			request.setAttribute("add", "addFail");
			return "addFail";
		}
		
//		gr.setSno(addSno);
//		gr.setTno(addTno);
		
//		graduationSelectionService.addSelectInfo(gr);
		
//		return SUCCESS;
	}
	
	//根据主键获取一条毕设选题信息
	public String getOneSelectInfo(){
		request.setAttribute("navId", 4);
		
		GraduationProSele gr=graduationSelectionService.getOneSelectInfo(graduationProSeleId);
		if(gr!=null){
			request.setAttribute("oneSelectInfo", gr);
		}
		
		return SUCCESS;
	}
	
	//更新之前通过主键获取毕设选题信息
	public String get(){
		request.setAttribute("navId", 4);
		
		GraduationProSele gr=graduationSelectionService.getOneSelectInfo(graduationProSeleId);
		if(gr!=null){
			request.setAttribute("updateSelectInfo", gr);
		}
		
		return SUCCESS;
	}
	
	//更新一条毕设选题信息
	public String updateSelectInfo(){
		request.setAttribute("navId", 4);
		
		GraduationProSele gr=graduationSelectionService.getOneSelectInfo(graduationProSeleId);
		gr.setGraduationProTitle(updateGraduationProTitle);
		gr.setSno(updateSno);
		gr.setTno(updateTno);
		graduationSelectionService.updateSelectInfo(gr);
		
		return SUCCESS;
	}
	
	//根据主键删除一条毕设选题信息
	public String deleteSelectInfo(){
		request.setAttribute("navId", 4);
		graduationSelectionService.deleteSelecInfo(deleteId);
		return SUCCESS;
	}
	
	
	//===============================getter setter方法====================================
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}



	public GraduationSelectionService getGraduationSelectionService() {
		return graduationSelectionService;
	}



	public void setGraduationSelectionService(
			GraduationSelectionService graduationSelectionService) {
		this.graduationSelectionService = graduationSelectionService;
	}



	public String getAddGraduationProTitle() {
		return addGraduationProTitle;
	}



	public void setAddGraduationProTitle(String addGraduationProTitle) {
		this.addGraduationProTitle = addGraduationProTitle;
	}



	public String getAddSno() {
		return addSno;
	}



	public void setAddSno(String addSno) {
		this.addSno = addSno;
	}



	public String getAddTno() {
		return addTno;
	}



	public void setAddTno(String addTno) {
		this.addTno = addTno;
	}



	public String getUpdateGraduationProTitle() {
		return updateGraduationProTitle;
	}



	public void setUpdateGraduationProTitle(String updateGraduationProTitle) {
		this.updateGraduationProTitle = updateGraduationProTitle;
	}



	public String getUpdateSno() {
		return updateSno;
	}



	public void setUpdateSno(String updateSno) {
		this.updateSno = updateSno;
	}



	public String getUpdateTno() {
		return updateTno;
	}



	public void setUpdateTno(String updateTno) {
		this.updateTno = updateTno;
	}



	public Integer getDeleteId() {
		return deleteId;
	}



	public void setDeleteId(Integer deleteId) {
		this.deleteId = deleteId;
	}



	public Integer getGraduationProSeleId() {
		return graduationProSeleId;
	}



	public void setGraduationProSeleId(Integer graduationProSeleId) {
		this.graduationProSeleId = graduationProSeleId;
	}


	public StudentService getStudentService() {
		return studentService;
	}


	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}


	public TeacherService getTeacherService() {
		return teacherService;
	}


	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	
	

}
