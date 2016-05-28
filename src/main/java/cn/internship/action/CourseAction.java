package cn.internship.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import cn.internship.service.HomeworkService;
import cn.internship.service.StudentService;
import cn.internship.service.TeacherService;

/**
 * 课程页面的相关请求与操作
 * @author dreamlate
 */
public class CourseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{

	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private CourseService courseService;
	private HomeworkService homeworkService;
	private TeacherService teacherService;
	private CaseLibraryService caseLibraryService;
	private StudentService studentService;
	
	//所选的课程主键ID，用来查找相关的案例库
	private Integer courseId;
	//添加课程的相关信息
	private String ctitle;
	private String ctime;
	private String caddress;
	private Integer cteacher;
	@Override
	public String execute() throws Exception {
		request.setAttribute("navId", 3);
		//获得当前session下的学生
		Student student = (Student) request.getSession().getAttribute("currentUser");
		Integer studentId = student.getStudentId();
		//获得当前学生所选的课程
		List<Course> courseList = courseService.getBySno(studentId);
		int n = courseList.size();
		//教师姓名
		List<String> teacherNameList = new ArrayList<String>(courseList.size());
		//成绩
		List<Integer> stuScoreList = new ArrayList<Integer>(courseList.size());
		//作业
		List<Homework> homeworkList = new ArrayList<Homework>(courseList.size());
		
		for(int i=0;i<n;i++){
			Teacher tchTemp = courseList.get(i).getTeacher();
			String tchName = tchTemp==null?null:tchTemp.getName();
			Course courseTemp = courseList.get(i);
			Integer courseId = courseTemp==null?null:courseTemp.getCourseId();
			Integer sScore = courseService.getCourseScore(studentId, courseId);
			Homework homework = homeworkService.get(studentId, courseId);
			teacherNameList.add(tchName);
			stuScoreList.add(sScore);
			homeworkList.add(homework);
		}
		
		List<ComprehensiveCourseInfo> comprehensiveCourseInfoList = new ArrayList<CourseAction.ComprehensiveCourseInfo>();
		for(int i=0;i<n;i++){
			ComprehensiveCourseInfo comprehensiveCourseInfo = new ComprehensiveCourseInfo();
			comprehensiveCourseInfo.setTeacherName(teacherNameList.get(i));
			comprehensiveCourseInfo.setStuScore(stuScoreList.get(i));
			comprehensiveCourseInfo.setCourse(courseList.get(i));
			comprehensiveCourseInfo.setHomework(homeworkList.get(i));
			comprehensiveCourseInfoList.add(comprehensiveCourseInfo);
		}
		
		request.setAttribute("comprehensiveCourseInfoList", comprehensiveCourseInfoList);
		return super.execute();
	}
	
	//自定义的数据结构，整合课程、教师、分数的信息
	private class ComprehensiveCourseInfo{
		private Course course;
		private String teacherName;
		private Integer stuScore;
		private Homework homework;
		public Course getCourse() {
			return course;
		}
		public void setCourse(Course course) {
			this.course = course;
		}
		public String getTeacherName() {
			return teacherName;
		}
		public void setTeacherName(String teacherName) {
			this.teacherName = teacherName;
		}
		public Integer getStuScore() {
			return stuScore;
		}
		public void setStuScore(Integer stuScore) {
			this.stuScore = stuScore;
		}
		public Homework getHomework() {
			return homework;
		}
		public void setHomework(Homework homework) {
			this.homework = homework;
		}
		
	}
	
	
	//当前教师教授的课程
	public String tchCourse(){
		request.setAttribute("navId", 3);
		//获得当前session下的老师
		Teacher teacher = (Teacher) request.getSession().getAttribute("currentUser");
		Integer teacherId = teacher.getTeacherId();
		List<Course> tchCourseList = courseService.getByTno(teacherId);
		request.setAttribute("tchCourseList", tchCourseList);
		return SUCCESS;
	}
	
	//当前课程的案例库
	public String showCaseLibraries(){
		request.setAttribute("navId", 3);
//		Integer courseId = Integer.parseInt(request.getParameter("courseId"));
		Course course = courseService.get(courseId);
		Set<CaseLibrary> caseLibraries = course.getCaseLibraries();
//		List<CaseLibrary> caseLibraries = caseLibraryService.getByCId(courseId);
		request.setAttribute("caseLibraries", caseLibraries);
		request.setAttribute("courseId", courseId);
		return SUCCESS;
	}
	
	
	//管理员操作课程页面
	public String showAdminCourse(){
		request.setAttribute("navId", 3);
		List<Course> courses = courseService.getAll();
		request.setAttribute("courses", courses);
		return SUCCESS;
	}
	
	//管理员添加课程
	public String addCourse(){
		request.setAttribute("navId", 3);
		Course course = new Course();
		course.setName(ctitle);
		course.setCoursePlace(caddress);
		course.setCourseDate(ctime);
		if(cteacher!=null){
			course.setTeacher(teacherService.get(cteacher));
		}
		List<Student> students = studentService.getAllStudents();
		if(students!=null){
			Set<Student> studentSets = new HashSet<Student>();
			for(Student s:students){
				studentSets.add(s);
			}
			//添加一门课关联所有学生
			course.setStudents(studentSets);
		}
		courseService.saveCourse(course);
		return SUCCESS;
	}
	
	//显示管理员添加课程页面
	public String showAdminAddCourse(){
		request.setAttribute("navId", 3);
		List<Teacher> teachers = teacherService.getAll();
		request.setAttribute("teachers", teachers);
		return SUCCESS;
	}
	
	//删除课程
	public String deleteCourse(){
		request.setAttribute("navId", 3);
		courseService.deleteCourse(courseId);
		return SUCCESS;
	}
	
	
	//显示修改课程页面
	public String showUpdateCourse(){
		request.setAttribute("navId", 3);
		Course course = courseService.get(courseId);
		request.setAttribute("course", course);
		request.setAttribute("teachers", teacherService.getAll());
		return SUCCESS;
	}
	
	//修改课程信息
	public String updateCourse(){
		request.setAttribute("navId", 3);
		Course course = courseService.get(courseId);
		course.setName(ctitle);
		course.setCourseDate(ctime);
		course.setCoursePlace(caddress);
		course.setTeacher(teacherService.get(cteacher));
		courseService.updateCourse(course);
		return SUCCESS;
	}
	
	//-------------------------------------------------get与set方法-------------------------------------------
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	public HomeworkService getHomeworkService() {
		return homeworkService;
	}

	public void setHomeworkService(HomeworkService homeworkService) {
		this.homeworkService = homeworkService;
	}


	public TeacherService getTeacherService() {
		return teacherService;
	}


	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public CaseLibraryService getCaseLibraryService() {
		return caseLibraryService;
	}

	public void setCaseLibraryService(CaseLibraryService caseLibraryService) {
		this.caseLibraryService = caseLibraryService;
	}

	public String getCtitle() {
		return ctitle;
	}

	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getCaddress() {
		return caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	public Integer getCteacher() {
		return cteacher;
	}

	public void setCteacher(Integer cteacher) {
		this.cteacher = cteacher;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	
	
	
}
