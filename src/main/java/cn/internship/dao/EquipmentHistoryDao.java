package cn.internship.dao;

import java.util.List;

import cn.internship.entity.EquipmentHistory;

public interface EquipmentHistoryDao {

	public List<EquipmentHistory> getHistoryByEuipmentId(Integer equipmentId);
	
	public List<EquipmentHistory> getHistoryByEuipmentIdIsDelete(Integer equipmentId);
	
	public List<EquipmentHistory> getAllHistoryByEuipmentId();
	
	public List<EquipmentHistory> getAllHistoryByEuipmentIdIsDelete();
	
	public void add(EquipmentHistory equipmentHistory);
	
	public void delete(Integer id);
	
	public void update(EquipmentHistory equipmentHistory);
	
	public List<EquipmentHistory> getAllHistotyByTeacherId(Integer teacherId);
	
}
