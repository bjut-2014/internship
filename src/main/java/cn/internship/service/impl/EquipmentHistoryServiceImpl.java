package cn.internship.service.impl;

import java.util.List;

import cn.internship.dao.EquipmentHistoryDao;
import cn.internship.entity.EquipmentHistory;
import cn.internship.service.EquipmentHistoryService;

public class EquipmentHistoryServiceImpl implements EquipmentHistoryService {

	private EquipmentHistoryDao equipmentHistoryDao;
	
	//获得设备的历史记录，未删除的
	@Override
	public List<EquipmentHistory> getHistoryByEuipmentId(Integer equipmentId) {
		return equipmentHistoryDao.getHistoryByEuipmentId(equipmentId);
	}

	//获得设备的历史记录，已经删除的
	@Override
	public List<EquipmentHistory> getHistoryByEuipmentIdIsDelete(
			Integer equipmentId) {
		return equipmentHistoryDao.getHistoryByEuipmentIdIsDelete(equipmentId);
	}

	//获得所有设备的历史记录，未删除的
	@Override
	public List<EquipmentHistory> getAllHistoryByEuipmentId() {
		return equipmentHistoryDao.getAllHistoryByEuipmentId();
	}

	//获得所有设备的历史记录，已经删除的
	@Override
	public List<EquipmentHistory> getAllHistoryByEuipmentIdIsDelete() {
		return equipmentHistoryDao.getAllHistoryByEuipmentIdIsDelete();
	}

	//添加一条设备的历史记录
	@Override
	public void add(EquipmentHistory equipmentHistory) {
		equipmentHistoryDao.add(equipmentHistory);
	}
	
	//----------------------------get与set-------------------------

	public EquipmentHistoryDao getEquipmentHistoryDao() {
		return equipmentHistoryDao;
	}

	public void setEquipmentHistoryDao(EquipmentHistoryDao equipmentHistoryDao) {
		this.equipmentHistoryDao = equipmentHistoryDao;
	}
	
	

}
