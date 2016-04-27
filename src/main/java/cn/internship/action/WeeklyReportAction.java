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

import cn.internship.entity.InternshipDetail;
import cn.internship.entity.Student;
import cn.internship.entity.WeeklyReport;
import cn.internship.service.InternshipDetailService;
import cn.internship.service.WeeklyReportService;

import com.opensymphony.xwork2.ActionSupport;

public class WeeklyReportAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private WeeklyReportService weeklyReportService;
	private InternshipDetailService internshipDetailService;
	
	//======================添加模块=======================//
	private String addTitle;
	private String addContent;
	
	//======================修改模块=======================//
	private String updateTitle;
	private String updateContent;
	private int updateId;
	
	//======================删除模块=======================//
	private int deleteId;
	
	//======================查找周报id=====================//
	private int weeklyReportId;
	
	
	public String execute() throws Exception {
        //获得当前session下的学生
		Student student = (Student) request.getSession().getAttribute("currentUser");
		//获得指定学生的所有周报
		List<WeeklyReport> list = weeklyReportService.getAll(student.getSno());
        request.setAttribute("weeklyplan", list);
        //获得指定学生的实习信息
        InternshipDetail it=internshipDetailService.getInternshipDetailBySno(student.getSno());
		request.setAttribute("internshipdetail", it);
        return super.execute();
    }
	
	//添加周报
	public String add(){
		 //获得当前session下的学生
		Student student = (Student) request.getSession().getAttribute("currentUser");
		//创建实体
		WeeklyReport weeklyReport = new WeeklyReport();
		weeklyReport.setSno(student.getSno());
		weeklyReport.setTitle(addTitle);
		weeklyReport.setContent(addContent);
		weeklyReport.setDate(new Date(new java.util.Date().getTime()));
		//保存
		weeklyReportService.save(weeklyReport);
		return SUCCESS;
	}
	
	//删除周报
	public String delete(int deleteId){
		weeklyReportService.delete(deleteId);
		return SUCCESS;
	}
	
	//获取周报
	public String getOneWeeklyReport(){
		WeeklyReport oneWeeklyReport=weeklyReportService.get(weeklyReportId);
		request.setAttribute("oneWeeklyReport", oneWeeklyReport);
		return SUCCESS;
	}
	
	
	//查找某一条周报
	public String get() throws Exception {
        WeeklyReport oneWeeklyReport = weeklyReportService.get(weeklyReportId);
        JSONObject jo = new JSONObject();

        jo.put("id", oneWeeklyReport.getId());
        jo.put("weeklyplanTitle", oneWeeklyReport.getTitle());
        jo.put("weeklyplanContent", oneWeeklyReport.getContent());
        jo.put("weeklyplanDate", oneWeeklyReport.getDate());

        try {
            response.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();
            out.println(jo);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
       return SUCCESS;
	}
	//更新周报
	public String update(){
		WeeklyReport weeklyReport=weeklyReportService.get(weeklyReportId);
		
		JSONObject jo = new JSONObject();
		weeklyReport.setTitle(updateTitle);
		weeklyReport.setContent(updateContent);
		weeklyReport.setDate(new Date(new java.util.Date().getTime()));
		weeklyReportService.save(weeklyReport);
		
		try {
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.println(jo);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//====================================================================================//
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
	public WeeklyReportService getWeeklyReportService() {
		return weeklyReportService;
	}
	public void setWeeklyReportService(WeeklyReportService weeklyReportService) {
		this.weeklyReportService = weeklyReportService;
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
	public int getWeeklyReportId() {
		return weeklyReportId;
	}
	public void setWeeklyReportId(int weeklyReportId) {
		this.weeklyReportId = weeklyReportId;
	}

	public InternshipDetailService getInternshipDetailService() {
		return internshipDetailService;
	}

	public void setInternshipDetailService(
			InternshipDetailService internshipDetailService) {
		this.internshipDetailService = internshipDetailService;
	}
	
	
}
