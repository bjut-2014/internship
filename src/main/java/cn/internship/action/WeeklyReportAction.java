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
import cn.internship.entity.InternshipReport;
import cn.internship.entity.Student;
import cn.internship.entity.WeeklyReport;
import cn.internship.service.InternshipDetailService;
import cn.internship.service.InternshipReportService;
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
	private InternshipReportService internshipReportService;
	
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
		request.setAttribute("navId", 4);
        //获得当前session下的学生
		Student student = (Student) request.getSession().getAttribute("currentUser");
		//获得指定学生的所有周报
		/*
		List<WeeklyReport> list = weeklyReportService.getAllWeeklyReport(student.getSno());
        request.setAttribute("weeklyplan", list);
        */
		/*
		if(weeklyReportService.getAllWeeklyReport(student.getSno())==null){
			request.setAttribute("weeklyplan", "您尚未提交周报！");
		}else{
			List<WeeklyReport> list = weeklyReportService.getAllWeeklyReport(student.getSno());
	        request.setAttribute("weeklyplan", list);
		}
		*/
		if(weeklyReportService.getAllWeeklyReport(student.getSno())!=null){
			List<WeeklyReport> list = weeklyReportService.getAllWeeklyReport(student.getSno());
	        request.setAttribute("weeklyplan", list);
		}
        //获得指定学生的实习信息
		if(internshipDetailService.getInternshipDetailBySno(student.getSno())!=null){
			InternshipDetail it=internshipDetailService.getInternshipDetailBySno(student.getSno());
			request.setAttribute("internshipdetail", it);
		}
        
		//设置上传实习报告状态
		//String result="您尚未提交实习报告！";
		InternshipReport it1=internshipReportService.getInternshipReport(student.getSno());
		System.out.println(it1);
		if(it1==null){
			request.setAttribute("result", "您尚未提交实习报告！");
		}else{
			request.setAttribute("result", "您已提交实习报告，请勿重复提交！");
		}
        return super.execute();
    }
	
	//添加周报
	public String add(){
		request.setAttribute("navId", 4);
		 //获得当前session下的学生
		Student student = (Student) request.getSession().getAttribute("currentUser");
		//创建实体
		WeeklyReport weeklyReport = new WeeklyReport();
		weeklyReport.setSno(student.getSno());
		weeklyReport.setTitle(addTitle);
		weeklyReport.setContent(addContent);
		weeklyReport.setDate(new Date(new java.util.Date().getTime()));
		//保存
		weeklyReportService.saveWeeklyReport(weeklyReport);
		return SUCCESS;
	}
	
	//删除周报
	public String delete(){
		request.setAttribute("navId", 4);
		System.out.println("Action");
		weeklyReportService.deleteWeeklyReport(deleteId);
		return SUCCESS;
	}
	
	//获取周报
	public String getOneWeeklyReport(){
		request.setAttribute("navId", 4);
		WeeklyReport oneWeeklyReport=weeklyReportService.getWeeklyReport(weeklyReportId);
		request.setAttribute("oneWeeklyReport", oneWeeklyReport);
		return SUCCESS;
	}
	
	
	//查找某一条周报
	public String get() throws Exception {
		request.setAttribute("navId", 4);
        WeeklyReport oneWeeklyReport = weeklyReportService.getWeeklyReport(weeklyReportId);
        request.setAttribute("updateReport", oneWeeklyReport);
        /*
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
        */
       return SUCCESS;
	}
	//更新周报
	public String update(){
		request.setAttribute("navId", 4);
		WeeklyReport weeklyReport=weeklyReportService.getWeeklyReport(weeklyReportId);
		
		weeklyReport.setTitle(updateTitle);
		weeklyReport.setContent(updateContent);
		weeklyReport.setDate(new Date(new java.util.Date().getTime()));
		weeklyReportService.updateWeeklyReport(weeklyReport);
		
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
    public InternshipReportService getInternshipReportService() {
        return internshipReportService;
    }

    public void setInternshipReportService(InternshipReportService internshipReportService) {
        this.internshipReportService = internshipReportService;
    }
	
}
