package cn.internship.dao;

import java.util.List;

import cn.internship.entity.Equipment;

/**
 * 设备持久层接口
 * @author dreamlate
 *
 */
public interface EquipmentDao {

	public void save(Equipment equipment);
	
	public Equipment get(Integer id);
	
	public void delete(Integer id);
	
	public List<Equipment> getByTeacherId(Integer teacherId);
	
	public List<Equipment> getAll();
	
	public List<Equipment> getExceptTeacherId(Integer teacherId);
	
	public void update(Equipment equipment);
}
