package internship;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.internship.entity.GraduationProSele;
import cn.internship.entity.InternshipDetail;
import cn.internship.entity.Student;
import cn.internship.entity.WeeklyReport;
import cn.internship.service.GraduationSelectionService;
import cn.internship.service.InternshipDetailService;
import cn.internship.service.StudentService;
import cn.internship.service.WeeklyReportService;
import cn.internship.dao.WeeklyReportDao;
import cn.internship.dao.impl.WeeklyReportDaoImpl;
import cn.internship.entity.GraduationWeeklyReport;
import cn.internship.entity.InternshipReport;
import cn.internship.entity.Student;
import cn.internship.entity.WeeklyReport;
import cn.internship.service.GraduationWeeklyReportService;
import cn.internship.service.InternshipDetailService;
import cn.internship.service.InternshipReportService;
import cn.internship.service.WeeklyReportService;
import cn.internship.service.impl.WeeklyReportServiceImpl;

public class TestUtil implements ServletRequestAware{

	private HttpServletRequest request;
	@Test
	public void testList(){
		List<String> list = new ArrayList<String>();
		System.out.println(list.size());
	}
	
	@Test
	public void testTime(){
		System.out.println(new Date().getTime());
	}
	
	@Test
	public void queryAllStudents(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		InternshipDetailService is = (InternshipDetailService) context.getBean("internshipDetailService");
		StudentService ss=(StudentService) context.getBean("studentService");
		
		List<InternshipDetail> list=is.getAllStudents();
		
		List<Student> students=new ArrayList<Student>();
		for(InternshipDetail it:list){
			String sno=it.getSno();
			Student st=ss.get(sno);
			System.out.println(st);
			students.add(st);
		}
	}
	
	@Test
	public void queryAllWeeklyReports(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		WeeklyReportService ws = (WeeklyReportService) context.getBean("weeklyReportService");
		List<WeeklyReport> list=ws.getAllWeeklyReport("S0001");
		for(WeeklyReport wst:list){
			System.out.println(wst.toString());
		}
	}
	
	@Test
	public void queryOneWeeklyReport(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		WeeklyReportService ws = (WeeklyReportService) context.getBean("weeklyReportService");
		WeeklyReport wsr=ws.getWeeklyReport(1);
		System.out.println(wsr.toString());
	}
	
	@Test
	public void getAllGraduatedStudents(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		GraduationSelectionService gss = (GraduationSelectionService) context.getBean("graduationSelectionService");
		StudentService studentService=(StudentService) context.getBean("studentService");
		List<GraduationProSele> list=gss.getSelectInfoByTno("t0001");
		for(GraduationProSele ss:list){
			System.out.println(ss);
		}
		List<Student> students=new ArrayList<Student>();
		//获得当前教师所带的毕设学生
		for(GraduationProSele st:list){
			String sno=st.getSno();
			Student stt=studentService.get(sno);
			System.out.println(stt);
			students.add(stt);
			System.out.println(students);
		}
		
	}
	public void testAddWeeklyReport(){

		WeeklyReport weeklyReport = new WeeklyReport();
		//weeklyReport.setId(4);
		weeklyReport.setSno("S0003");
		weeklyReport.setTitle("Jennifer's first weekltReport");
		weeklyReport.setContent("123456");
		weeklyReport.setDate(new Date(new java.util.Date().getTime()));
		System.out.println(weeklyReport);
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		WeeklyReportService wrs = (WeeklyReportService) context.getBean("weeklyReportService");
		wrs.saveWeeklyReport(weeklyReport);
	}
	
	@Test
	public void queryWeekltReport(){
//		WeeklyReportDao wr=new WeeklyReportDaoImpl();
//		WeeklyReport weeklyReport=wr.get(3);
//		System.out.println(weeklyReport);
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		WeeklyReportService wrs = (WeeklyReportService) context.getBean("weeklyReportService");
		WeeklyReport weeklyReport=wrs.getWeeklyReport(3);
		System.out.println(weeklyReport);
		
	}
	
	@Test
	public void deleteWeeklyReport(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		WeeklyReportService wrs = (WeeklyReportService) context.getBean("weeklyReportService");
		wrs.deleteWeeklyReport(1);
	}
	
	@Test
	public void getInternshipDetail(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		InternshipDetailService ids = (InternshipDetailService) context.getBean("internshipDetailService");
		System.out.println(ids.getInternshipDetailBySno("S0001"));
	}
	
	@Test
	public void saveInternshipReportTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		InternshipReportService irs = (InternshipReportService) context.getBean("internshipReportService");
		InternshipReport internshipReport = new InternshipReport();
		
		internshipReport.setSno("S0003");
		internshipReport.setTitle("Jennifer's Internship Report");
		internshipReport.setPath("D:\\apache-tomcat-8.0.33\\webapps\\myUploadFilePro\\InternshipReport\\周报_第五周  王云竹.doc");
		internshipReport.setDate(new Date(new java.util.Date().getTime()));
		
		irs.saveInternshipReport(internshipReport);
	}
	

	@Test
	public void testAddGraduateWeeklyReport(){

		GraduationWeeklyReport graduationWeeklyReport = new GraduationWeeklyReport();
		
		graduationWeeklyReport.setSno("S0003");
		graduationWeeklyReport.setTitle("Jennifer's first weekltReport");
		graduationWeeklyReport.setContent("123456");
		graduationWeeklyReport.setDate(new Date(new java.util.Date().getTime()));
		System.out.println(graduationWeeklyReport);
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		GraduationWeeklyReportService wrs = (GraduationWeeklyReportService) context.getBean("graduationWeeklyReportService");
		wrs.saveGraduationWeeklyReport(graduationWeeklyReport);
	}
	
	
	@Test
	public void queryGraduationWeekltReport(){

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		GraduationWeeklyReportService wrs = (GraduationWeeklyReportService) context.getBean("graduationWeeklyReportService");
		GraduationWeeklyReport graduationWeeklyReport=wrs.getGraduationWeeklyReport(1);
		System.out.println(graduationWeeklyReport);
		
	}
	
	@Test
	public void deleteGraduationWeeklyReport(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		GraduationWeeklyReportService wrs = (GraduationWeeklyReportService) context.getBean("graduationWeeklyReportService");
		wrs.deleteGraduationWeeklyReport(1);
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
}
