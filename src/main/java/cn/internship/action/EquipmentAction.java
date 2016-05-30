package cn.internship.action;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.mysql.fabric.xmlrpc.base.Data;
import com.opensymphony.xwork2.ActionSupport;

import cn.internship.entity.Equipment;
import cn.internship.entity.EquipmentHistory;
import cn.internship.entity.Teacher;
import cn.internship.service.AdminService;
import cn.internship.service.EquipmentHistoryService;
import cn.internship.service.EquipmentService;
import cn.internship.service.TeacherService;

public class EquipmentAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{

	private EquipmentService equipmentService;
	private EquipmentHistoryService equipmentHistoryService;
	private TeacherService teacherService;
	private AdminService adminService;
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	//设备信息
	private Integer equipmentId;
	private String eno;
	private String ename;
	private String epeople;
	private String elendDate;
	private String ereturnDate;
	private String estate;
	private Integer teacherId;
	
	//设备历史记录信息
	private Integer equipmentHistoryId;
	
	@Override
	public String execute() throws Exception {
		request.setAttribute("navId", 7);
		return super.execute();
	}
	
	//显示老师的设备
	public String showTeacherEquipment(){
		request.setAttribute("navId", 7);
		//自己的设备信息
		Teacher teacher = (Teacher) request.getSession().getAttribute("currentUser");
		List<Equipment> equipments = equipmentService.getByTeacherId(teacher.getTeacherId());
		request.setAttribute("equipments", equipments);
		
		//其他教师的设备信息
		List<Equipment> otherEquipments = equipmentService.getExceptTeacherId(teacher.getTeacherId());
		Set<Integer> tchIds = new HashSet<>();
		for(Equipment e:otherEquipments){
			tchIds.add(e.getTeacherId());
		}
		List<Teacher> tchs = new ArrayList<>();
		Iterator<Integer> it = tchIds.iterator();
		while(it.hasNext()){
			Integer tid = it.next();
			tchs.add(teacherService.get(tid));
		}
		request.setAttribute("tchs", tchs);
		return SUCCESS;
	}
	
	//自定义其他教师-设备数据结构
	class OTchEqu{
		private Integer tchId;
		private Integer equId;
		public Integer getTchId() {
			return tchId;
		}
		public void setTchId(Integer tchId) {
			this.tchId = tchId;
		}
		public Integer getEquId() {
			return equId;
		}
		public void setEquId(Integer equId) {
			this.equId = equId;
		}
	}
	
	//教师添加一条设备信息
	public String tchAddEquipment(){
		request.setAttribute("navId", 7);
		Teacher teacher = (Teacher) request.getSession().getAttribute("currentUser");
		Equipment equipment = new Equipment();
		equipment.setEno(eno);
		equipment.setName(ename);
		equipment.setTeacherId(teacher.getTeacherId());
		equipment.setOwner(teacher.getName());
		equipmentService.save(equipment);
		return SUCCESS;
	}
	
	//教师删除一条设备信息
	public String tchDeleteEquipment(){
		request.setAttribute("navId", 7);
		equipmentService.delete(equipmentId);
		
		//获得该设备的所有历史记录
		List<EquipmentHistory> equipmentHistories = equipmentHistoryService.getHistoryByEuipmentId(equipmentId);
		for(EquipmentHistory e:equipmentHistories){
			e.setIsDeleted(true);
			equipmentHistoryService.update(e);
		}
		return SUCCESS;
	}
	
	//教师删除一条设备历史记录信息
	public String tchDeleteEquipmentHistory(){
		request.setAttribute("navId", 7);
		equipmentService.deleteHistory(equipmentId);
		return SUCCESS;
	}
	
	//显示添加设备的记录
	public String tchShowAddEquipmentHistory(){
		request.setAttribute("navId", 7);
		Equipment equipment = equipmentService.get(equipmentId);
		request.setAttribute("equipment", equipment);
		List<EquipmentHistory> equipmentHistories = equipmentHistoryService.getHistoryByEuipmentId(equipmentId);
		request.setAttribute("equipmentHistories", equipmentHistories);
		return SUCCESS;
	}
	
	//添加设备的记录
	public String tchAddEquipmentHistory() throws ParseException{
		request.setAttribute("navId", 7);
		Equipment equipment = equipmentService.get(equipmentId);
		equipment.setPeople(epeople);
		SimpleDateFormat sdf =   new SimpleDateFormat("yyyy/mm/dd");
		java.util.Date elendDate1 = sdf.parse(elendDate);
		java.util.Date ereturnDate1 = sdf.parse(elendDate);
		equipment.setLendDate(new Date(elendDate1.getTime()));
		equipment.setReturnDate(new Date(ereturnDate1.getTime()));
		equipment.setState(estate);
		equipmentService.update(equipment);
		
		//添加设备的历史记录
		EquipmentHistory equipmentHistory = new EquipmentHistory();
		equipmentHistory.setEno(equipment.getEno());
		equipmentHistory.setName(equipment.getName());
		equipmentHistory.setEquipmentId(equipmentId);
		equipmentHistory.setLendDate(new Date(elendDate1.getTime()));
		equipmentHistory.setReturnDate(new Date(ereturnDate1.getTime()));
		equipmentHistory.setState(estate);
		equipmentHistory.setPeople(epeople);
		equipmentHistory.setOwner(equipment.getOwner());
		equipmentHistory.setOwnerId(equipment.getTeacherId());
		equipmentHistory.setIsDeleted(false);
		equipmentHistoryService.add(equipmentHistory);
		return SUCCESS;
	}
	
	public String showOtherTeacherEquipment(){
		request.setAttribute("navId", 7);
		List<Equipment> otherTeacherEquipments = equipmentService.getByTeacherId(teacherId); 
		request.setAttribute("otherTeacherEquipments", otherTeacherEquipments);
		return SUCCESS;
	}
	
	//管理员页面显示所有设备信息
	public String showAdminEquipments(){
		request.setAttribute("navId", 9);
		List<Equipment> adminEquipments = equipmentService.getAll();
		request.setAttribute("adminEquipments", adminEquipments);
		return SUCCESS;
	}
	//管理员页面，显示添加设备信息页面
	public String showAdminAddEquipment(){
		request.setAttribute("navId", 9);
		List<Teacher> teachers = teacherService.getAll();
		request.setAttribute("teachers", teachers);
		return SUCCESS;
	}
	//管理员页面，添加设备信息
	public String adminAddEquipment(){
		request.setAttribute("navId", 9);
		Equipment equipment = new Equipment();
		equipment.setEno(eno);
		equipment.setName(ename);
		equipment.setTeacherId(teacherId);
		equipment.setOwner(teacherService.get(teacherId).getName());
		equipmentService.save(equipment);
		return SUCCESS;
	}
	
	//管理员页面，添加设备记录页面
	public String showAdminAddEquipmentHistory(){
		request.setAttribute("navId", 9);
		Equipment equipment = equipmentService.get(equipmentId);
		List<EquipmentHistory> equipmentHistories = equipmentHistoryService.getHistoryByEuipmentId(equipmentId);
		request.setAttribute("equipment", equipment);
		request.setAttribute("equipmentHistories", equipmentHistories);
		return SUCCESS;
	}
	
	//管理员页面，添加设备记录(修改设备信息)
	public String adminAddEquipmentHistory() throws ParseException{
		request.setAttribute("navId", 9);
		Equipment equipment = equipmentService.get(equipmentId);
		SimpleDateFormat sdf =   new SimpleDateFormat("yyyy/mm/dd");
		java.util.Date elendDate1 = sdf.parse(elendDate);
		java.util.Date ereturnDate1 = sdf.parse(elendDate);
		equipment.setLendDate(new Date(elendDate1.getTime()));
		equipment.setReturnDate(new Date(ereturnDate1.getTime()));
		equipment.setState(estate);
		equipment.setPeople(epeople);
		equipmentService.update(equipment);
		
		//添加设备的历史记录
		EquipmentHistory equipmentHistory = new EquipmentHistory();
		equipmentHistory.setEno(eno);
		equipmentHistory.setName(ename);
		equipmentHistory.setEquipmentId(equipmentId);
		equipmentHistory.setLendDate(new Date(elendDate1.getTime()));
		equipmentHistory.setReturnDate(new Date(ereturnDate1.getTime()));
		equipmentHistory.setState(estate);
		equipmentHistory.setPeople(epeople);
		equipmentHistory.setOwner(teacherService.get(teacherId).getName());
		equipmentHistory.setOwnerId(teacherService.get(teacherId).getTeacherId());
		equipmentHistory.setIsDeleted(false);
		equipmentHistoryService.add(equipmentHistory);
		return SUCCESS;
	}
	
	//管理员删除一条设备信息
	public String adminDeleteEquipment(){
		request.setAttribute("navId", 9);
		Equipment equipment = equipmentService.get(equipmentId);
		equipmentService.delete(equipmentId);
		
		//获得该设备的所有历史记录
		List<EquipmentHistory> equipmentHistories = equipmentHistoryService.getHistoryByEuipmentId(equipmentId);
		for(EquipmentHistory e:equipmentHistories){
			e.setIsDeleted(true);
			equipmentHistoryService.update(e);
		}
		return SUCCESS;
	}
	
	//打印所有历史记录
	public String showEquipmentHistory(){
		request.setAttribute("navId", 9);
		List<EquipmentHistory> equipmentHistories = equipmentHistoryService.getAllHistoryByEuipmentIdIsDelete();
		request.setAttribute("equipmentHistories", equipmentHistories);
		return SUCCESS;
	}
	
	//删除设备历史记录
	public String adminDeleteEquipmentHistory(){
		equipmentHistoryService.delete(equipmentHistoryId);
		return SUCCESS;
	}
	
	//打印教师设备的所有记录
	public String showTchEquipmentHistory(){
		request.setAttribute("navId", 7);
		Teacher teacher = (Teacher) request.getSession().getAttribute("currentUser");
		List<EquipmentHistory> equipmentHistories = equipmentHistoryService.getAllHistotyByTeacherId(teacher.getTeacherId());
		request.setAttribute("equipmentHistories", equipmentHistories);
		return SUCCESS;
	}
	
	//----------------------------------get与set------------------------------------------
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public EquipmentService getEquipmentService() {
		return equipmentService;
	}

	public void setEquipmentService(EquipmentService equipmentService) {
		this.equipmentService = equipmentService;
	}


	public TeacherService getTeacherService() {
		return teacherService;
	}


	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}


	public AdminService getAdminService() {
		return adminService;
	}


	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public String getEno() {
		return eno;
	}

	public void setEno(String eno) {
		this.eno = eno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Integer getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(Integer equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getEpeople() {
		return epeople;
	}

	public void setEpeople(String epeople) {
		this.epeople = epeople;
	}

	

	public String getElendDate() {
		return elendDate;
	}

	public void setElendDate(String elendDate) {
		this.elendDate = elendDate;
	}

	public String getEreturnDate() {
		return ereturnDate;
	}

	public void setEreturnDate(String ereturnDate) {
		this.ereturnDate = ereturnDate;
	}

	public String getEstate() {
		return estate;
	}

	public void setEstate(String estate) {
		this.estate = estate;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public EquipmentHistoryService getEquipmentHistoryService() {
		return equipmentHistoryService;
	}

	public void setEquipmentHistoryService(
			EquipmentHistoryService equipmentHistoryService) {
		this.equipmentHistoryService = equipmentHistoryService;
	}

	public Integer getEquipmentHistoryId() {
		return equipmentHistoryId;
	}

	public void setEquipmentHistoryId(Integer equipmentHistoryId) {
		this.equipmentHistoryId = equipmentHistoryId;
	}


}
