package cn.internship.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.internship.entity.InternshipDetail;
import cn.internship.service.InternshipDetailService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 管理员模块实习信息页面的相关请求与操作
 * @author Sunny
 *
 */

public class AdminInternshipDetailAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private InternshipDetailService internshipDetailService;
	
	//=================================添加学生实习信息===============================
	private String add_companyAddress;
	private String add_companyName;
	private String add_companyTeacher;
	private Date add_date;
	private Integer add_score;
	private String add_sno;
	
	//=================================修改学生实习信息================================
	private String update_companyAddress;
	private String update_companyName;
	private String update_companyTeacher;
	private Date update_date;
	private Integer update_score;
	private String update_sno;
	
	//=================================通过Id删除实习信息===============================
	private Integer deleteId;
	
	//=================================通过Id查询实习信息===============================
	private Integer internshipDetailId;
	
	
	@Override
	public String execute() throws Exception {
		request.setAttribute("navId", 7);
		List<InternshipDetail> list=internshipDetailService.getAllStudents();
		if(list!=null){
			request.setAttribute("AllInternshipDetails", list);
		}
		return super.execute();
	}
	
	
	//添加实习信息
	public String addInternshipDetail(){
		request.setAttribute("navId", 7);
		InternshipDetail it=new InternshipDetail();
		it.setCompany_address(add_companyAddress);
		it.setCompany_name(add_companyName);
		it.setCompany_teacher(add_companyTeacher);
		it.setDate(add_date);
		it.setScore(add_score);
		it.setSno(add_sno);
		
		internshipDetailService.addInternshipDetail(it);
		
		return SUCCESS;
	}
	
	
	//根据主键获取一条实习信息
	public String getOneInternshipDetail(){
		request.setAttribute("navID", 7);
		InternshipDetail it=internshipDetailService.getInternshipDetailById(internshipDetailId);
		if(it!=null){
			request.setAttribute("oneInternshipDetail", it);
		}
		return SUCCESS;
	}
	
	//更新实习信息之前通过主键获取实习信息
	public String get(){
		request.setAttribute("navId", 7);
		InternshipDetail it=internshipDetailService.getInternshipDetailById(internshipDetailId);
		if(it!=null){
			request.setAttribute("updateOneInternshipDetail", it);
		}
		return SUCCESS;
	}
	
	//更新实习信息
	public String updateInternshipDetail(){
		request.setAttribute("navId", 7);
		InternshipDetail it=internshipDetailService.getInternshipDetailById(internshipDetailId);
		
		it.setCompany_address(update_companyAddress);
		it.setCompany_name(update_companyName);
		it.setCompany_teacher(update_companyTeacher);
		it.setDate(update_date);
		it.setScore(update_score);
		it.setSno(update_sno);
		
		internshipDetailService.updateInternshipDetail(it);
		
		return SUCCESS;
	}
	
	//删除实习信息
	public String deleteInernshipDetail(){
		request.setAttribute("navId", 7);
		internshipDetailService.deleteInternshipDetail(deleteId);
		return SUCCESS;
	}
	
	//=================================getter setter方法===================================
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}

	public InternshipDetailService getInternshipDetailService() {
		return internshipDetailService;
	}

	public void setInternshipDetailService(
			InternshipDetailService internshipDetailService) {
		this.internshipDetailService = internshipDetailService;
	}

	public String getAdd_companyAddress() {
		return add_companyAddress;
	}

	public void setAdd_companyAddress(String add_companyAddress) {
		this.add_companyAddress = add_companyAddress;
	}

	public String getAdd_companyName() {
		return add_companyName;
	}

	public void setAdd_companyName(String add_companyName) {
		this.add_companyName = add_companyName;
	}

	public String getAdd_companyTeacher() {
		return add_companyTeacher;
	}

	public void setAdd_companyTeacher(String add_companyTeacher) {
		this.add_companyTeacher = add_companyTeacher;
	}

	public Date getAdd_date() {
		return add_date;
	}

	public void setAdd_date(Date add_date) {
		this.add_date = add_date;
	}

	public Integer getAdd_score() {
		return add_score;
	}

	public void setAdd_score(Integer add_score) {
		this.add_score = add_score;
	}

	public String getAdd_sno() {
		return add_sno;
	}

	public void setAdd_sno(String add_sno) {
		this.add_sno = add_sno;
	}

	public String getUpdate_companyAddress() {
		return update_companyAddress;
	}

	public void setUpdate_companyAddress(String update_companyAddress) {
		this.update_companyAddress = update_companyAddress;
	}

	public String getUpdate_companyName() {
		return update_companyName;
	}

	public void setUpdate_companyName(String update_companyName) {
		this.update_companyName = update_companyName;
	}

	public String getUpdate_companyTeacher() {
		return update_companyTeacher;
	}

	public void setUpdate_companyTeacher(String update_companyTeacher) {
		this.update_companyTeacher = update_companyTeacher;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public Integer getUpdate_score() {
		return update_score;
	}

	public void setUpdate_score(Integer update_score) {
		this.update_score = update_score;
	}

	public String getUpdate_sno() {
		return update_sno;
	}

	public void setUpdate_sno(String update_sno) {
		this.update_sno = update_sno;
	}

	public Integer getDeleteId() {
		return deleteId;
	}

	public void setDeleteId(Integer deleteId) {
		this.deleteId = deleteId;
	}


	public Integer getInternshipDetailId() {
		return internshipDetailId;
	}


	public void setInternshipDetailId(Integer internshipDetailId) {
		this.internshipDetailId = internshipDetailId;
	}

	

	

	
}
