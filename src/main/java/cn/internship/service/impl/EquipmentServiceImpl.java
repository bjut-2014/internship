package cn.internship.service.impl;

import java.util.List;

import cn.internship.dao.EquipmentDao;
import cn.internship.entity.Equipment;
import cn.internship.service.EquipmentService;

/**
 * 设备业务层操作
 * @author dreamlate
 *
 */
public class EquipmentServiceImpl implements EquipmentService{

	private EquipmentDao equipmentDao;
	
	@Override
	public void save(Equipment equipment) {
		equipmentDao.save(equipment);
	}

	@Override
	public Equipment get(Integer id) {
		return equipmentDao.get(id);
	}

	@Override
	public void delete(Integer id) {
		equipmentDao.delete(id);
	}

	@Override
	public List<Equipment> getByTeacherId(Integer teacherId) {
		return equipmentDao.getByTeacherId(teacherId);
	}

	@Override
	public List<Equipment> getAll() {
		return equipmentDao.getAll();
	}

	@Override
	public List<Equipment> getExceptTeacherId(Integer teacherId) {
		return equipmentDao.getExceptTeacherId(teacherId);
	}

	@Override
	public void update(Equipment equipment) {
		equipmentDao.update(equipment);
	}

	//------------------------------------get与set-----------------------------------------------------
	
	public EquipmentDao getEquipmentDao() {
		return equipmentDao;
	}

	public void setEquipmentDao(EquipmentDao equipmentDao) {
		this.equipmentDao = equipmentDao;
	}

}
