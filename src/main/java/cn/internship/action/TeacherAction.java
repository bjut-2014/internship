package cn.internship.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

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
	
	//添加教师的相关信息
	private String tno;
	private String tname;
	private String tsex;
	private String tphone;
	private String temail;
	private String tmajor;
	
	private Integer teacherId;
	
	//导入的教师excel信息
	private File upload;
	
	
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
	
	//个人信息
	public String info(){
		request.setAttribute("navId", 2);
		Teacher teacher = (Teacher) request.getSession().getAttribute("currentUser");
		String tno = teacher.getTno();
		List<Syslog> stuSyslogList = syslogService.getAll(tno);
		request.setAttribute("stuSyslogList", stuSyslogList);
		return SUCCESS;
	} 
	
	//显示所有教师
	public String showTeachers(){
		request.setAttribute("navId", 5);
		List<Teacher> teachers = teacherService.getAll();
		request.setAttribute("teachers", teachers);
		return SUCCESS;
	}
	
	//添加教师
	public String addTeacher(){
		request.setAttribute("navId", 5);
		Teacher teacher = new Teacher();
		teacher.setTno(tno);
		teacher.setName(tname);
		teacher.setPassword(tno);//默认密码与工号一至
		teacher.setEmail(temail);
		teacher.setMajor(tmajor);
		teacher.setPhone(tphone);
		Integer sexNumer = "男".equals(tsex)?1:2;
		teacher.setSex(sexNumer);
		teacherService.saveTeacher(teacher);
		return SUCCESS;
	}
	
	//删除教师
	public String deleteTeacher(){
		teacherService.deleteTeacher(teacherId);
		return SUCCESS;
	}
	
	//读取批量导入教师信息
	public String uploadTchExcel(){
		List<Teacher> teachers = new ArrayList<Teacher>();
		Workbook book = null;
		if(upload!=null){
			try {
				book = Workbook.getWorkbook(upload);
				Sheet sheet = book.getSheet(0);
				int rows = sheet.getRows();
				int columns = sheet.getColumns();
				//格式不符合要求
				if(columns!=6){
					return SUCCESS;
				}
				for(int m=1;m<rows;m++){
	//				for(int n=0;n<columns;n++){
	//					Cell cell = sheet.getCell(n,m);
	//					String result = cell.getContents();
	//					System.out.print(result+",");
	//				}
					Teacher teacher = new Teacher();
					//1
					Cell cell = sheet.getCell(0,m);
					String result = cell.getContents();
					teacher.setTno(result);
					teacher.setPassword(result);
					//2
					cell = sheet.getCell(1,m);
					result = cell.getContents();
					teacher.setName(result);
					//3
					cell = sheet.getCell(2,m);
					result = cell.getContents();
					int sex = "男".equals(result)?1:2;
					teacher.setSex(sex);
					//4
					cell = sheet.getCell(3,m);
					result = cell.getContents();
					teacher.setPhone(result);
					//5
					cell = sheet.getCell(4,m);
					result = cell.getContents();
					teacher.setEmail(result);
					//6
					cell = sheet.getCell(5,m);
					result = cell.getContents();
					teacher.setMajor(result);
					
					teachers.add(teacher);
				}
			} catch (BiffException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		request.getSession().setAttribute("teachers", teachers);
		return SUCCESS;
	}
	
	//批量保存
	public String importTch(){
		ArrayList<Teacher> teachers = (ArrayList<Teacher>) request.getSession().getAttribute("teachers");
		if(teachers!=null){
			for(Teacher teacher:teachers){
				teacherService.saveTeacher(teacher);
			}
		}
		request.getSession().setAttribute("teachers", null);
		return SUCCESS;
	}
	
	//显示教师修改页面
	public String showUpdateTeacher(){
		Teacher teacher = teacherService.get(teacherId);
		request.setAttribute("teacher", teacher);
		return SUCCESS;
	}
	
	//修改教师信息
	public String updateTeacher(){
		Teacher teacher = teacherService.get(teacherId);
		teacher.setTno(tno);
		teacher.setName(tname);
		int sex = "男".equals(tsex) ? 1:2;
		teacher.setSex(sex);
		teacher.setEmail(temail);
		teacher.setMajor(tmajor);
		teacher.setPhone(tphone);
		teacherService.updateTeacher(teacher);
		return SUCCESS;
	}
	
	//-----------------get与set方法--------------------------------
	
	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

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

	public String getTno() {
		return tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	

	public String getTsex() {
		return tsex;
	}

	public void setTsex(String tsex) {
		this.tsex = tsex;
	}

	public String getTphone() {
		return tphone;
	}

	public void setTphone(String tphone) {
		this.tphone = tphone;
	}

	public String getTemail() {
		return temail;
	}

	public void setTemail(String temail) {
		this.temail = temail;
	}

	public String getTmajor() {
		return tmajor;
	}

	public void setTmajor(String tmajor) {
		this.tmajor = tmajor;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}


	
	

}
