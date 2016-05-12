package cn.internship.action;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.internship.entity.Admin;
import cn.internship.entity.CarouselFigure;
import cn.internship.entity.NoticeBoard;
import cn.internship.entity.RecruitInfo;
import cn.internship.service.AdminService;
import cn.internship.service.CarouselFigureService;
import cn.internship.service.NoticeBoardService;
import cn.internship.service.RecruitInfoService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 招聘、公告、轮播图的相关请求与操作
 * 
 * @author MengHan
 *
 */
public class AdminAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;

	private NoticeBoardService noticeBoardService;
	private RecruitInfoService recruitInfoService;
	private CarouselFigureService carouselFigureService;
	private AdminService adminService;

	// 公告栏相关信息
	private Integer noticeBoardId;
	private String noticeBoardTitle;
	private String noticeBoardContent;
	// 招聘相关信息
	private Integer recruitInfoId;
	private String recruitInfoTitle;
	private String recruitInfoContent;
	// 轮播图相关信息
	private Integer carouselFigureId;
	private String carouselFigureTitle;
	private String carouselFigureContent;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	
	
	@Override
	public String execute() throws Exception {
		request.setAttribute("navId", 2);
		List<NoticeBoard> noticeBoards = noticeBoardService.getAll();
		List<RecruitInfo> recruitInfos = recruitInfoService.getAll();
		List<CarouselFigure> carouselFigures = carouselFigureService.getAll();

		request.setAttribute("noticeBoards", noticeBoards);
		request.setAttribute("recruitInfos", recruitInfos);
		request.setAttribute("carouselFigures", carouselFigures);

		return SUCCESS;
	}

	

	// 添加一条公告信息
	public String addNoticeBoard() {
		NoticeBoard noticeBoard = new NoticeBoard();
		noticeBoard.setTitle(noticeBoardTitle);
		noticeBoard.setContent(noticeBoardContent);
		noticeBoard.setDate(new Date(new java.util.Date().getTime()));
		noticeBoardService.save(noticeBoard);
		return SUCCESS;
	}

	// 删除一条公告信息
	public String deleteNoticeBoard() {
		noticeBoardService.delete(noticeBoardId);
		return SUCCESS;
	}

	// 修改一条公告信息
	public String updateNoticeBoard() {
		NoticeBoard noticeBoard = noticeBoardService.get(noticeBoardId);
		noticeBoard.setTitle(noticeBoardTitle);
		noticeBoard.setContent(noticeBoardContent);
		noticeBoard.setDate(new Date(new java.util.Date().getTime()));
		noticeBoardService.update(noticeBoard);
		return SUCCESS;
	}

	// 添加一条招聘信息
	public String addRecruitInfo() {
		RecruitInfo recruitInfo = new RecruitInfo();
		recruitInfo.setTitle(recruitInfoTitle);
		recruitInfo.setContent(recruitInfoContent);
		recruitInfo.setDate(new Date(new java.util.Date().getTime()));
		recruitInfoService.save(recruitInfo);
		return SUCCESS;
	}

	// 删除一条招聘信息
	public String deleteRecruitInfo() {
		recruitInfoService.delete(recruitInfoId);
		return SUCCESS;
	}

	// 修改一条招聘信息
	public String updateRecruitInfo() {
		RecruitInfo recruitInfo = recruitInfoService.get(recruitInfoId);
		recruitInfo.setTitle(recruitInfoTitle);
		recruitInfo.setContent(recruitInfoContent);
		recruitInfo.setDate(new Date(new java.util.Date().getTime()));
		recruitInfoService.update(recruitInfo);
		return SUCCESS;
	}

	// 添加一条轮播图信息
	public String addCarouselFigure() throws IOException {
		// 需要保存的路径
		String folderPath = "/upload/carouselFigure/";
		// 文件实际路径
		String realPath = ServletActionContext.getServletContext().getRealPath(folderPath);
		if (upload != null) {
			File saveFile = new File(new File(realPath), uploadFileName);
			if (!saveFile.getParentFile().exists()) {
				saveFile.getParentFile().mkdirs();
			}
			FileUtils.copyFile(upload, saveFile);
		}
		CarouselFigure carouselFigure = new CarouselFigure();
		carouselFigure.setPictureName(uploadFileName);
		carouselFigure.setPath(folderPath);
		carouselFigure.setTitle(carouselFigureTitle);
		carouselFigure.setContent(carouselFigureContent);
		carouselFigure.setDate(new Date(new java.util.Date().getTime()));
		carouselFigureService.add(carouselFigure);
		return SUCCESS;
	}

	// 删除一条轮播图信息
	public String deleteCarouselFigure() {
		carouselFigureService.delete(carouselFigureId);
		return SUCCESS;
	}

	// 修改一条轮播图信息
	public String updateCarouselFigure() {
		CarouselFigure carouselFigure = carouselFigureService.get(carouselFigureId);
		carouselFigure.setTitle(carouselFigureTitle);
		carouselFigure.setContent(carouselFigureContent);
		carouselFigure.setDate(new Date(new java.util.Date().getTime()));
		carouselFigureService.update(carouselFigure);
		return SUCCESS;
	}

	// --------------------------------------------------get与set--------------------------------------------------------

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public NoticeBoardService getNoticeBoardService() {
		return noticeBoardService;
	}

	public void setNoticeBoardService(NoticeBoardService noticeBoardService) {
		this.noticeBoardService = noticeBoardService;
	}

	public RecruitInfoService getRecruitInfoService() {
		return recruitInfoService;
	}

	public void setRecruitInfoService(RecruitInfoService recruitInfoService) {
		this.recruitInfoService = recruitInfoService;
	}

	public CarouselFigureService getCarouselFigureService() {
		return carouselFigureService;
	}

	public void setCarouselFigureService(CarouselFigureService carouselFigureService) {
		this.carouselFigureService = carouselFigureService;
	}

	public String getNoticeBoardTitle() {
		return noticeBoardTitle;
	}

	public void setNoticeBoardTitle(String noticeBoardTitle) {
		this.noticeBoardTitle = noticeBoardTitle;
	}

	public String getNoticeBoardContent() {
		return noticeBoardContent;
	}

	public void setNoticeBoardContent(String noticeBoardContent) {
		this.noticeBoardContent = noticeBoardContent;
	}

	public String getRecruitInfoTitle() {
		return recruitInfoTitle;
	}

	public void setRecruitInfoTitle(String recruitInfoTitle) {
		this.recruitInfoTitle = recruitInfoTitle;
	}

	public String getRecruitInfoContent() {
		return recruitInfoContent;
	}

	public void setRecruitInfoContent(String recruitInfoContent) {
		this.recruitInfoContent = recruitInfoContent;
	}

	public String getCarouselFigureTitle() {
		return carouselFigureTitle;
	}

	public void setCarouselFigureTitle(String carouselFigureTitle) {
		this.carouselFigureTitle = carouselFigureTitle;
	}

	public String getCarouselFigureContent() {
		return carouselFigureContent;
	}

	public void setCarouselFigureContent(String carouselFigureContent) {
		this.carouselFigureContent = carouselFigureContent;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public Integer getNoticeBoardId() {
		return noticeBoardId;
	}

	public void setNoticeBoardId(Integer noticeBoardId) {
		this.noticeBoardId = noticeBoardId;
	}

	public Integer getRecruitInfoId() {
		return recruitInfoId;
	}

	public void setRecruitInfoId(Integer recruitInfoId) {
		this.recruitInfoId = recruitInfoId;
	}

	public Integer getCarouselFigureId() {
		return carouselFigureId;
	}

	public void setCarouselFigureId(Integer carouselFigureId) {
		this.carouselFigureId = carouselFigureId;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}


}
