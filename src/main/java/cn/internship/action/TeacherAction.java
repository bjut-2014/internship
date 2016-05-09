package cn.internship.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.internship.entity.CarouselFigure;
import cn.internship.entity.NoticeBoard;
import cn.internship.entity.RecruitInfo;
import cn.internship.entity.Syslog;
import cn.internship.entity.Teacher;
import cn.internship.service.CarouselFigureService;
import cn.internship.service.NoticeBoardService;
import cn.internship.service.RecruitInfoService;
import cn.internship.service.SyslogService;
import cn.internship.service.TeacherService;

import com.opensymphony.xwork2.ActionSupport;

public class TeacherAction  extends ActionSupport implements ServletRequestAware, ServletResponseAware{

	private NoticeBoardService noticeBoardService;
	private RecruitInfoService recruitInfoService;
	private CarouselFigureService carouselFigureService;
	private TeacherService teacherService;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private SyslogService syslogService;
	
	@Override
	public String execute() throws Exception {
		request.setAttribute("navId", 2);
		List<NoticeBoard> noticeBoards = noticeBoardService.getAll();
		List<RecruitInfo> recruitInfos = recruitInfoService.getAll();
		List<CarouselFigure> carouselFigures = carouselFigureService.getAll();

		request.setAttribute("noticeBoards", noticeBoards);
		request.setAttribute("recruitInfos", recruitInfos);
		request.setAttribute("carouselFigures", carouselFigures);

		return SUCCESS;
	}
	
	//学生个人信息
	public String info(){
		request.setAttribute("navId", 2);
		Teacher teacher = (Teacher) request.getSession().getAttribute("currentUser");
		String tno = teacher.getTno();
		List<Syslog> stuSyslogList = syslogService.getAll(tno);
		request.setAttribute("stuSyslogList", stuSyslogList);
		return SUCCESS;
	} 
	
	//-----------------get与set方法--------------------------------
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public SyslogService getSyslogService() {
		return syslogService;
	}

	public void setSyslogService(SyslogService syslogService) {
		this.syslogService = syslogService;
	}

	public NoticeBoardService getNoticeBoardService() {
		return noticeBoardService;
	}

	public void setNoticeBoardService(NoticeBoardService noticeBoardService) {
		this.noticeBoardService = noticeBoardService;
	}

	public RecruitInfoService getRecruitInfoService() {
		return recruitInfoService;
	}

	public void setRecruitInfoService(RecruitInfoService recruitInfoService) {
		this.recruitInfoService = recruitInfoService;
	}

	public CarouselFigureService getCarouselFigureService() {
		return carouselFigureService;
	}

	public void setCarouselFigureService(CarouselFigureService carouselFigureService) {
		this.carouselFigureService = carouselFigureService;
	}
	
	

}
