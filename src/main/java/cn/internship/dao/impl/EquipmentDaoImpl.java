package cn.internship.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.internship.dao.EquipmentDao;
import cn.internship.entity.Equipment;

/**
 * 设备管理持久层操作
 * @author dreamlate
 *
 */
public class EquipmentDaoImpl extends HibernateDaoSupport implements EquipmentDao {

	//添加一个设备
	@Override
	public void save(Equipment equipment) {
		getHibernateTemplate().save(equipment);
	}

	//获得一个设备
	@Override
	public Equipment get(Integer id) {
		return getHibernateTemplate().get(Equipment.class, id);
	}

	//删除一个设备（不是真的删除，仅是把这个数据标记为历史记录）
	@Override
	public void delete(Integer id) {
		Equipment equipment = get(id);
//		equipment.setIsHistory(true);
		getHibernateTemplate().delete(equipment);
	}
	
	//删除一个设备的历史记录
	@Override
	public void deleteHistory(Integer id) {
		Equipment equipment = get(id);
		getHibernateTemplate().delete(equipment);
	}

	//获得某个教师所拥有的设备
	@Override
	public List<Equipment> getByTeacherId(Integer teacherId) {
		String hql = "from Equipment e where e.teacherId="+teacherId;
		List<Equipment> equipments = (List<Equipment>) getHibernateTemplate().find(hql);
		return equipments;
	}

	//获得所有设备
	@Override
	public List<Equipment> getAll() {
		String hql = "from Equipment e";
		List<Equipment> equipments = (List<Equipment>) getHibernateTemplate().find(hql);
		return equipments;
	}

	//获得某个教师所没有的设备
	@Override
	public List<Equipment> getExceptTeacherId(Integer teacherId) {
		String hql = "from Equipment e where e.teacherId !="+teacherId;
		List<Equipment> equipments = (List<Equipment>) getHibernateTemplate().find(hql);
		return equipments;
	}

	//更新某个设备
	@Override
	public void update(Equipment equipment) {
		getHibernateTemplate().update(equipment);
	}

}
