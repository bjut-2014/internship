package cn.internship.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.internship.entity.Student;
import cn.internship.service.StudentService;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by surprise on 4/29/16.
 */
public class ResetPwdAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

    private HttpServletRequest request;
    private HttpServletResponse response;

    private StudentService studentService;

    //初始密码
    private String password;
    //新密码
    private String newpwd;
    //确认密码
    private String renewpwd;

    @Override
    public String execute() throws Exception {
        return super.execute();
    }

    //修改密码
    public String resetPwd(){
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("currentType").getClass().getName());
//        if (session.getAttribute("currentType") == "3") {
            Student student = (Student) request.getSession().getAttribute("currentUser");
            Student student1 = studentService.get(student.getId());
//        }
        //清除修改密码时提示的错误信息
        this.clearErrorsAndMessages();
        //获得当前用户的密码

        if(password == null || !student1.getPassword().equals(password)){
            this.addActionError("初始密码错误");
            return INPUT;
        }
        if(newpwd == null || "".equals(newpwd) || renewpwd == null || "".equals(renewpwd)){
            this.addActionError("密码不能为空");
            return INPUT;
        }
        if(!newpwd.equals(renewpwd)){
            this.addActionError("两次密码不一至");
            return INPUT;
        }
        //更改密码
        student1.setPassword(newpwd);
        studentService.updatePwd(student1);
        //移除当前session中的student
        request.getSession().removeAttribute("currentUser");
        return SUCCESS;
    }


    //-------------------------------------get与set方法-------------------------------------------

    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewpwd() {
        return newpwd;
    }

    public void setNewpwd(String newpwd) {
        this.newpwd = newpwd;
    }

    public String getRenewpwd() {
        return renewpwd;
    }

    public void setRenewpwd(String renewpwd) {
        this.renewpwd = renewpwd;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
