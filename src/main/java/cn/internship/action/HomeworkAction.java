package cn.internship.action;

import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.internship.entity.Homework;
import cn.internship.entity.Student;
import cn.internship.service.CourseService;
import cn.internship.service.HomeworkService;
import cn.internship.service.StudentService;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;

import org.json.JSONObject;

/**
 * 上传作业的相关请求与操作
 * @author MengHan
 */
public class HomeworkAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{

	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private HomeworkService homeworkService;
	private StudentService studentService;
	private CourseService courseService;
	
	//待上传文件的各种信息
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	
	//选的课程的ID
	private Integer courseId;
	
	//打分信息
	private String sno;
	private Integer cno;
	private Integer score;
	
	@Override
	public String execute() throws Exception {
		request.setAttribute("navId", 3);
		//当前的用户
		Student student = (Student) request.getSession().getAttribute("currentUser");
		//需要保存的路径
//		String folderPath = File.separator+"upload"+File.separator + student.getSno()+ File.separator ;
		String folderPath = "/upload/homework/"+student.getSno()+"/";
		//文件实际路径
		String realPath = ServletActionContext.getServletContext().getRealPath("/upload/homework/"+student.getSno()+"/");
//		System.out.println(folderPath);
//		System.out.println(realPath);
		JSONObject jo = new JSONObject();
		//上传文件
		if(upload!=null){
			File saveFile = new File(new File(realPath),uploadFileName);
			if(!saveFile.getParentFile().exists()){
				saveFile.getParentFile().mkdirs();
			}
			FileUtils.copyFile(upload, saveFile);
			
			Homework homework = new Homework();
			homework.setDate(new Date(new java.util.Date().getTime()));
			homework.setPath(folderPath);
			homework.setStudentId(student.getStudentId());
			homework.setCourseId(courseId);
			homework.setTitle(uploadFileName);
			homeworkService.saveHomework(homework);
			try {
				response.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				out.println(jo);
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return super.execute();
		}
		return INPUT;
	}
	
	
	//罗列指定课程下的所有作业
	public String listHomeworkByCourse(){
		request.setAttribute("navId", 3);
		List<Homework> homeworks = homeworkService.getByCourse(courseId);
		int n = homeworks.size();
		List<String> snoList = new ArrayList<String>(n);
		List<String> snameList = new ArrayList<String>(n);
		List<Integer> scoreList = new ArrayList<Integer>();
		
		for(int i=0;i<n;i++){
			int cId = homeworks.get(i).getCourseId();
			int studentId = homeworks.get(i).getStudentId();
			int sc;
			try {
				sc = courseService.getCourseScore(studentId, cId);
			} catch (Exception e) {
				sc = -1;
			}
			Student student = studentService.get(studentId);
			snoList.add(student.getSno());
			snameList.add(student.getName());
			scoreList.add(sc);
		}
		List<ComprehensiveHomeworkInfo> comprehensiveHomeworkInfos = new ArrayList<HomeworkAction.ComprehensiveHomeworkInfo>(n);
		for(int i=0;i<n;i++){
			ComprehensiveHomeworkInfo comprehensiveHomeworkInfo = new ComprehensiveHomeworkInfo();
			comprehensiveHomeworkInfo.setHomework(homeworks.get(i));
			comprehensiveHomeworkInfo.setName(snameList.get(i));
			comprehensiveHomeworkInfo.setNo(snoList.get(i));
			comprehensiveHomeworkInfo.setScore(scoreList.get(i));
			comprehensiveHomeworkInfos.add(comprehensiveHomeworkInfo);
		}
		
		request.setAttribute("comprehensiveHomeworkInfos", comprehensiveHomeworkInfos);
		return SUCCESS;
	}
	
	//给课程打分
	public String setCourseScore(){
		courseService.setCourseScore(studentService.get(sno).getStudentId(), cno, score);
		return SUCCESS;
	}
	
	private class ComprehensiveHomeworkInfo{
		private Homework homework;
		private String name;
		private String no;
		private Integer score;
		public Homework getHomework() {
			return homework;
		}
		public void setHomework(Homework homework) {
			this.homework = homework;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getNo() {
			return no;
		}
		public void setNo(String no) {
			this.no = no;
		}
		public Integer getScore() {
			return score;
		}
		public void setScore(Integer score) {
			this.score = score;
		}
		
		
	}
	
	//-----------------------get与set方法-------------------------
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}


	public HomeworkService getHomeworkService() {
		return homeworkService;
	}


	public void setHomeworkService(HomeworkService homeworkService) {
		this.homeworkService = homeworkService;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		System.out.println(uploadContentType);
		this.uploadContentType = uploadContentType;
		
		
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		System.out.println(uploadFileName);
		this.uploadFileName = uploadFileName;
		
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}


	public Integer getCourseId() {
		return courseId;
	}


	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}


	public File getUpload() {
		return upload;
	}


	public void setUpload(File upload) {
		this.upload = upload;
	}



	public String getSno() {
		return sno;
	}


	public void setSno(String sno) {
		this.sno = sno;
	}


	public Integer getCno() {
		return cno;
	}


	public void setCno(Integer cno) {
		this.cno = cno;
	}


	public Integer getScore() {
		return score;
	}


	public void setScore(Integer score) {
		this.score = score;
	}


	public CourseService getCourseService() {
		return courseService;
	}


	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	
	
	
}
