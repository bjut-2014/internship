package cn.internship.service.impl;

import java.util.List;

import cn.internship.dao.NoticeBoardDao;
import cn.internship.entity.NoticeBoard;
import cn.internship.service.NoticeBoardService;

/**
 * 公告类业务层操作
 * @author MengHan
 *
 */
public class NoticeBoardServiceImpl implements NoticeBoardService{

	private NoticeBoardDao noticeBoardDao;
	
	@Override
	public void save(NoticeBoard noticeBoard) {
		noticeBoardDao.add(noticeBoard);
	}

	@Override
	public void delete(Integer id) {
		noticeBoardDao.delete(id);
	}

	@Override
	public NoticeBoard get(Integer id) {
		return noticeBoardDao.get(id);
	}

	@Override
	public void update(NoticeBoard noticeBoard) {
		noticeBoardDao.edit(noticeBoard);
	}

	@Override
	public List<NoticeBoard> getAll() {
		return noticeBoardDao.getAll();
	}

	@Override
	public List<NoticeBoard> getByNum(int num) {
		return noticeBoardDao.getByNum(num);
	}

	public NoticeBoardDao getNoticeBoardDao() {
		return noticeBoardDao;
	}

	public void setNoticeBoardDao(NoticeBoardDao noticeBoardDao) {
		this.noticeBoardDao = noticeBoardDao;
	}

	
	
}
