package internship;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

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
	
}
