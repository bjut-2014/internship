package cn.internship.utils;

import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;

import cn.internship.action.LoginAction;
import cn.internship.entity.Syslog;
import cn.internship.service.SyslogService;

public class SyslogUtils{

	private SyslogService syslogService;
	
	public void SystemLog(){}

	public void setSystemLog(String no,String name,Date date, String behavior) {
//		MDC.put("username", username);
//		Logger.getLogger(object.getClass()).info(msg);
		Syslog syslog = new Syslog();
		syslog.setNo(no);
		syslog.setName(name);
		syslog.setDate(date);
		syslog.setBehavior(behavior);
		syslogService.add(syslog);
	}

	/**
	 * 使用spring的aop，为系统的所有增加、删除以及更新操作添加日志记录
	 * @param joinPoint 可以获得被调用的方法的信息
	 */
	public void afterReturnLog(JoinPoint joinPoint) {
		//姓名
		String name = UserInfo.CURRENT_NAME;
		//编号
		String no = UserInfo.CURRENT_NO;
		// 调用的方法名字
		String methodName = joinPoint.getSignature().getName();
		// 调用的类名字
		String className = joinPoint.getTarget().getClass().toString();
		//调用时间
		Date date = new Date();
		//行为
		String behavior = judgeBehavior(methodName);
//		setSystemLog(systemGlobalUser, this, "调用了" + className + "的" + methodName + "方法");
		setSystemLog(no, name, date, behavior);
	}

	public static String judgeBehavior(String methodName){
		String str = "";
		if(methodName.indexOf("login")!=-1){
			str = "登陆了";
		}
		else if(methodName.indexOf("logout")!=-1){
			str = "注销了";
		}else if(methodName.indexOf("saveWeeklyReport")!=-1){
			str="提交了一条实习周报";
		}else if(methodName.indexOf("updateWeeklyReport")!=-1){
			str="更新了一条实习周报";
		}else if(methodName.indexOf("deleteWeeklyReport")!=-1){
			str="删除了一条实习周报";
		}else if(methodName.indexOf("getWeeklyReport")!=-1){
			str="查看了一条实习周报";
		}else if(methodName.indexOf("getGraduationWeeklyReport")!=-1){
			str="查看了一条毕设周报";
		}else if(methodName.indexOf("saveGraduationWeeklyReport")!=-1){
			str="提交了一条毕设周报";
		}else if(methodName.indexOf("updateGraduationWeeklyReport")!=-1){
			str="更新了一条毕设周报";
		}else if(methodName.indexOf("deleteGraduationWeeklyReport")!=-1){
			str="删除了一条毕设周报";
		}else if(methodName.indexOf("saveInternshipReport")!=-1){
			str="上传了实习报告";
		}else if(methodName.indexOf("saveHomework")!=-1){
			str = "上传了作业";
		}
		else{
			str="do nothing";
		}
		return str;
	}
	
	//-----------------------------------get与set方法------------------------------------------------------
	public SyslogService getSyslogService() {
		return syslogService;
	}
	
	public void setSyslogService(SyslogService syslogService) {
		this.syslogService = syslogService;
	}
	
	
	
}
