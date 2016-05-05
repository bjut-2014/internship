package cn.internship.dao;

import java.util.List;

import cn.internship.entity.NoticeBoard;

/**
 * 公告栏持久层接口
 * @author MengHan
 *
 */
public interface NoticeBoardDao {

	public void add(NoticeBoard noticeBoard);
	
	public void delete(Integer id);
	
	public NoticeBoard get(Integer id);
	
	public void edit(NoticeBoard noticeBoard);
	
	public List<NoticeBoard> getAll();
	
	public List<NoticeBoard> getByNum(int num);
	
}
