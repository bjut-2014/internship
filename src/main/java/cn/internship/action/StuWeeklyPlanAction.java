package cn.internship.action;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import cn.internship.entity.Student;
import cn.internship.entity.WeeklyPlan;
import cn.internship.service.WeeklyPlanService;
import org.json.JSONArray;

/**
 * 学生周报页面
 * @author dreamlate
 */
public class StuWeeklyPlanAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{
    
	private HttpServletRequest request;
	private HttpServletResponse response;
	private WeeklyPlanService weeklyPlanService;
	
	//添加周报标题
	private String addTitle;
	//添加周报内容
	private String addContent;
	
	//删除周报ID
	private Integer deleteId;

    //查找周报ID
    private Integer weeklyPlanId;
	
	//修改周报标题
	private String updateTitle;
	//修改周报内容
	private String updateContent;
	//修改周报ID
	private Integer updateId;

    @Override
    public String execute() throws Exception {
        //获得当前session下的学生
		Student student = (Student) request.getSession().getAttribute("currentUser");
		//获得指定学生的所有周报
		List<WeeklyPlan> list = weeklyPlanService.getAll(student.getStudentId());
        request.setAttribute("weeklyplan", list);
		return super.execute();
    }

	//查找某一条周报
	public String get() throws Exception {
//		WeeklyPlan oneWeeklyPlan = weeklyPlanService.get(weeklyPlanId);
//		request.setAttribute("oneWeeklyplan", oneWeeklyPlan);
//		return super.execute();
        String weeklyPlanId = request.getParameter("weeklyPlanId");
        JSONArray jsonArray = new JSONArray();

        return SUCCESS;
	}

	//添加周报
	public String add(){
		 //获得当前session下的学生
		Student student = (Student) request.getSession().getAttribute("currentUser");
		//创建实体
		WeeklyPlan weeklyPlan = new WeeklyPlan();
		weeklyPlan.setStudentId(student.getStudentId());
		weeklyPlan.setWeeklyplanTitle(addTitle);
		weeklyPlan.setWeeklyplanContent(addContent);
		weeklyPlan.setWeeklyplanDate(new Date(new java.util.Date().getTime()));
		//保存
		weeklyPlanService.save(weeklyPlan);
		return SUCCESS;
	}
	
	//删除周报
	public String delete(){
		weeklyPlanService.delete(deleteId);
		return SUCCESS;
	}
	
	//修改周报
	public String update(){
		WeeklyPlan weeklyPlan = weeklyPlanService.get(updateId);
		weeklyPlan.setWeeklyplanTitle(updateTitle);
		weeklyPlan.setWeeklyplanContent(updateContent);
		weeklyPlan.setWeeklyplanDate(new Date(new java.util.Date().getTime()));
		weeklyPlanService.update(weeklyPlan);
		return SUCCESS;
	}
	
	//----------------------------get与set放----------------------------
	
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}


	public WeeklyPlanService getWeeklyPlanService() {
		return weeklyPlanService;
	}


	public void setWeeklyPlanService(WeeklyPlanService weeklyPlanService) {
		this.weeklyPlanService = weeklyPlanService;
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

	public Integer getDeleteId() {
		return deleteId;
	}

	public void setDeleteId(Integer deleteId) {
		this.deleteId = deleteId;
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

	public Integer getUpdateId() {
		return updateId;
	}

	public void setUpdateId(Integer updateId) {
		this.updateId = updateId;
	}

    public Integer getWeeklyPlanId() {
        return weeklyPlanId;
    }

    public void setWeeklyPlanId(Integer weeklyPlanId) {
        this.weeklyPlanId = weeklyPlanId;
    }
}
