package cn.internship.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.internship.entity.Student;
import cn.internship.service.StudentService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 管理员模块学生信息页面的相关请求与操作
 * @author Sunny
 *
 */
public class AdminStudentAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private StudentService studentService;
	
	//====================================添加学生信息======================================
	private String addClasses;
	private String addEmail;
	private Integer addGrade;
	private String addName;
	private String addPhone;
	private Integer addSex;
	private String addSno;
	
	//====================================更新学生信息======================================
	private String updateClasses;
	private String updateEmail;
	private Integer updateGrade;
	private String updateName;
	private String updatePhone;
	private Integer updateSex;
	private String updateSno;
	
	//====================================删除学生信息======================================
	private Integer deleteId;
	
	//====================================获取学生信息======================================
	private Integer studentId;
	
	@Override
	public String execute() throws Exception {
		request.setAttribute("navId", 4);
		
		List<Student> students=studentService.getAllStudents();
		//HttpSession session=request.getSession();
		try{
			if(students!=null){
				request.setAttribute("students", students);
			}
			
			return super.execute();
		}catch(Exception ex){
			ex.printStackTrace();
			return INPUT;
		}
		
	}
	
	
	//添加学生信息
	public String addStudent(){
		request.setAttribute("navId", 4);
		
		Student st=new Student();
		st.setClasses(addClasses);
		st.setEmail(addEmail);
		st.setGrade(addGrade);
		st.setName(addName);
		st.setPassword(addSno);
		st.setPhone(addPhone);
		st.setSex(addSex);
		st.setSno(addSno);
		st.setUserType(3);
		
		studentService.addStudent(st);
		
		return SUCCESS;
	}
	
	//根据主键获取一条学生信息
	public String getOneStudent(){
		request.setAttribute("navId", 4);
		
		Student st=studentService.get(studentId);
		if(st!=null){
			request.setAttribute("oneStudent", st);
		}
		
		return SUCCESS;
	}
	
	//更新学生信息前通过主键获取当前学生信息
	public String get(){
		request.setAttribute("navId", 4);
		
		Student st=studentService.get(studentId);
		if(st!=null){
			request.setAttribute("updateStudent", st);
			return SUCCESS;
		}else{
			return INPUT;
		}
		
		
	}
	
	//更新学生信息
	public String updateStudent(){
		request.setAttribute("navId", 4);
		
		Student st=studentService.get(studentId);
		st.setClasses(updateClasses);
		st.setEmail(updateEmail);
		st.setGrade(updateGrade);
		st.setName(updateName);
		st.setPassword(updateSno);
		st.setPhone(updatePhone);
		st.setSex(updateSex);
		st.setSno(updateSno);
		st.setUserType(3);
		
		try{
			studentService.updateStudent(st);
			
			return SUCCESS;
		}catch(Exception ex){
			ex.printStackTrace();
			return INPUT;
		}
		
	}
	
	//根据主键删除学生信息
	public String deleteStudent(){
		request.setAttribute("navId", 4);
		studentService.deleteStudent(deleteId);
		return SUCCESS;
	}
	
	
	
	//===============================getter setter方法====================================
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public String getAddClasses() {
		return addClasses;
	}

	public void setAddClasses(String addClasses) {
		this.addClasses = addClasses;
	}

	public String getAddEmail() {
		return addEmail;
	}

	public void setAddEmail(String addEmail) {
		this.addEmail = addEmail;
	}

	public Integer getAddGrade() {
		return addGrade;
	}

	public void setAddGrade(Integer addGrade) {
		this.addGrade = addGrade;
	}

	public String getAddName() {
		return addName;
	}

	public void setAddName(String addName) {
		this.addName = addName;
	}

	public String getAddPhone() {
		return addPhone;
	}

	public void setAddPhone(String addPhone) {
		this.addPhone = addPhone;
	}

	public Integer getAddSex() {
		return addSex;
	}

	public void setAddSex(Integer addSex) {
		this.addSex = addSex;
	}

	public String getAddSno() {
		return addSno;
	}

	public void setAddSno(String addSno) {
		this.addSno = addSno;
	}

	public String getUpdateClasses() {
		return updateClasses;
	}

	public void setUpdateClasses(String updateClasses) {
		this.updateClasses = updateClasses;
	}

	public String getUpdateEmail() {
		return updateEmail;
	}

	public void setUpdateEmail(String updateEmail) {
		this.updateEmail = updateEmail;
	}

	public Integer getUpdateGrade() {
		return updateGrade;
	}

	public void setUpdateGrade(Integer updateGrade) {
		this.updateGrade = updateGrade;
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	public String getUpdatePhone() {
		return updatePhone;
	}

	public void setUpdatePhone(String updatePhone) {
		this.updatePhone = updatePhone;
	}

	public Integer getUpdateSex() {
		return updateSex;
	}

	public void setUpdateSex(Integer updateSex) {
		this.updateSex = updateSex;
	}

	public String getUpdateSno() {
		return updateSno;
	}

	public void setUpdateSno(String updateSno) {
		this.updateSno = updateSno;
	}

	public Integer getDeleteId() {
		return deleteId;
	}

	public void setDeleteId(Integer deleteId) {
		this.deleteId = deleteId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	
	
}
