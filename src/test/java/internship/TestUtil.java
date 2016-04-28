package internship;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.internship.dao.CourseDao;
import cn.internship.entity.Course;
import cn.internship.entity.Student;

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
	public void testTable(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CourseDao courseDao = (CourseDao) context.getBean("courseDao");
//		List<Course> list =  courseDao.getBySno(1);
//		System.out.println(list.size());
//		Course course = list.get(0);
//		System.out.println(course.getName());
		List<Course> list =  courseDao.getByTno(1);
		System.out.println(list.size());
		Course course = list.get(0);
		System.out.println(course.getName());
	}
	
}
