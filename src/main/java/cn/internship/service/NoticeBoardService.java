package cn.internship.service;

import java.util.List;

import cn.internship.entity.NoticeBoard;

/**
 * 公告栏业务层接口
 * @author MengHan
 *
 */
public interface NoticeBoardService {

	public void save(NoticeBoard noticeBoard);
	
	public void delete(Integer id);
	
	public NoticeBoard get(Integer id);
	
	public void update(NoticeBoard noticeBoard);
	
	public List<NoticeBoard> getAll();
	
	public List<NoticeBoard> getByNum(int num);
	
}
