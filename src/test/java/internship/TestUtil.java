package internship;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.internship.entity.Student;
import cn.internship.service.CourseService;

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
}
