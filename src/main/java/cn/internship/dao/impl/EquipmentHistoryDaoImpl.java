package cn.internship.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.internship.dao.EquipmentHistoryDao;
import cn.internship.entity.EquipmentHistory;

public class EquipmentHistoryDaoImpl extends HibernateDaoSupport implements EquipmentHistoryDao{

	//获得设备的历史记录，未删除的
	@Override
	public List<EquipmentHistory> getHistoryByEuipmentId(Integer equipmentId) {
		String hql = "from EquipmentHistory e where e.isDeleted=false and e.equipmentId="+equipmentId;
		List<EquipmentHistory> equipmentHistories = (List<EquipmentHistory>) getHibernateTemplate().find(hql);
		return equipmentHistories;
	}

	//获得设备的历史记录，已经删除的
	@Override
	public List<EquipmentHistory> getHistoryByEuipmentIdIsDelete(Integer equipmentId) {
		String hql = "from EquipmentHistory e where e.isDeleted=true and e.equipmentId="+equipmentId;
		List<EquipmentHistory> equipmentHistories = (List<EquipmentHistory>) getHibernateTemplate().find(hql);
		return equipmentHistories;
	}
	
	//获得所有设备的历史记录，未删除的
	@Override
	public List<EquipmentHistory> getAllHistoryByEuipmentId() {
		String hql = "from EquipmentHistory e where e.isDeleted=false";
		List<EquipmentHistory> equipmentHistories = (List<EquipmentHistory>) getHibernateTemplate().find(hql);
		return equipmentHistories;
	}

	//获得所有设备的历史记录，已经删除的
	@Override
	public List<EquipmentHistory> getAllHistoryByEuipmentIdIsDelete() {
		String hql = "from EquipmentHistory e where e.isDeleted=true";
		List<EquipmentHistory> equipmentHistories = (List<EquipmentHistory>) getHibernateTemplate().find(hql);
		return equipmentHistories;
	}

	//添加一条设备的历史记录
	@Override
	public void add(EquipmentHistory equipmentHistory) {
		getHibernateTemplate().save(equipmentHistory);
	}

}
