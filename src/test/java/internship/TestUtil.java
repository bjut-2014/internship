package internship;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.internship.entity.GraduationProSele;
import cn.internship.entity.Student;
import cn.internship.entity.WeeklyReport;
import cn.internship.service.CourseService;
import cn.internship.service.GraduationSelectionService;
import cn.internship.service.StudentService;
import cn.internship.service.WeeklyReportService;

public class TestUtil {

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
		CourseService cs = (CourseService) context.getBean("courseService");
		List<Student> list=cs.getStudentsByCourseId(1);
		for(Student st:list){
			System.out.println(st.getSno());
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
}
