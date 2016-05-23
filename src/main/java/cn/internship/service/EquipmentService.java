package cn.internship.service;

import java.util.List;

import cn.internship.entity.Equipment;

/**
 * 设备业务层接口
 * @author dreamlate
 *
 */
public interface EquipmentService {

public void save(Equipment equipment);
	
	public Equipment get(Integer id);
	
	public void delete(Integer id);
	
	public void deleteHistory(Integer id);
	
	public List<Equipment> getByTeacherId(Integer teacherId);
	
	public List<Equipment> getAll();
	
	public List<Equipment> getExceptTeacherId(Integer teacherId);
	
	public void update(Equipment equipment);
	
}
