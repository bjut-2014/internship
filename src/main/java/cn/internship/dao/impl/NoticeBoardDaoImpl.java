package cn.internship.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.internship.dao.NoticeBoardDao;
import cn.internship.entity.NoticeBoard;
import cn.internship.entity.Syslog;

/**
 * 公告栏持久层操作
 * @author MengHan
 *
 */
public class NoticeBoardDaoImpl extends HibernateDaoSupport implements NoticeBoardDao {

	//添加公告
	@Override
	public void add(NoticeBoard noticeBoard) {
		getHibernateTemplate().save(noticeBoard);
	}

	//删除公告
	@Override
	public void delete(Integer id) {
		NoticeBoard noticeBoard = get(id);
		getHibernateTemplate().delete(noticeBoard);
	}

	//获得指定公告
	@Override
	public NoticeBoard get(Integer id) {
		return getHibernateTemplate().get(NoticeBoard.class, id);
	}

	//编辑公告
	@Override
	public void edit(NoticeBoard noticeBoard) {
		getHibernateTemplate().saveOrUpdate(noticeBoard);
	}

	//获得所有公告
	@Override
	public List<NoticeBoard> getAll() {
		String hql = "from NoticeBoard";
		List<NoticeBoard> list = (List<NoticeBoard>) getHibernateTemplate().find(hql);
		return list;
	}

	//获得指定条数的公告
	@Override
	public List<NoticeBoard> getByNum(int num) {
		String hql = "from NoticeBoard";
		List<NoticeBoard> list = (List<NoticeBoard>) getHibernateTemplate().find(hql);
		//只取前num条数据
		List<NoticeBoard> newList = null;
		if(list.size()>num){
			newList = list.subList(0, num);
			return newList;
		}
		return list;
	}

}
