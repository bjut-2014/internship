package cn.internship.dao.impl;

import java.io.Serializable;
import java.util.List;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import cn.internship.dao.BaseDao;

/**
 *	公共持久层操作函数，泛型T传入要操作的实体层类 
 * @author dreamlate
 * @param <T>
 */
public class BaseDaoHibernate4<T> extends HibernateDaoSupport implements BaseDao<T>
{
	// 根据ID加载实体
	public T get(Class<T> entityClazz , Serializable id)
	{
		return (T)getHibernateTemplate().get(entityClazz , id);
	}
	// 保存实体
	public Serializable save(T entity)
	{
		return getHibernateTemplate().save(entity);
	}
	// 更新实体
	public void update(T entity)
	{
		getHibernateTemplate().saveOrUpdate(entity);
	}
	// 删除实体
	public void delete(T entity)
	{
		getHibernateTemplate().delete(entity);
	}
	// 根据ID删除实体
	public void delete(Class<T> entityClazz , Serializable id)
	{
		getHibernateTemplate().delete(get(entityClazz , id));
	}
	// 获取所有实体
	public List<T> findAll(Class<T> entityClazz)
	{
		return find("select * from "
			+ entityClazz.getSimpleName());
	}
	// 获取实体总数
	public long findCount(Class<T> entityClazz)
	{
		List l = find("select count(*) from "
			+ entityClazz.getSimpleName());
		// 查询得到的实体总数
		return l.size();
	}

	// 根据HQL语句查询实体
	protected List<T> find(String hql)
	{
		return (List<T>)getHibernateTemplate().find(hql);
	}
//	// 根据带占位符参数HQL语句查询实体
//	protected List<T> find(String hql , Object... params)
//	{
//		// 创建查询
//		Query query = getSessionFactory().getCurrentSession()
//			.createQuery(hql);
//		// 为包含占位符的HQL语句设置参数
//		for(int i = 0 , len = params.length ; i < len ; i++)
//		{
//			query.setParameter(i + "" , params[i]);
//		}
//		return (List<T>)query.list();
//	}
//	/**
//	 * 使用hql 语句进行分页查询操作
//	 * @param hql 需要查询的hql语句
//	 * @param pageNo 查询第pageNo页的记录
//	 * @param pageSize 每页需要显示的记录数
//	 * @return 当前页的所有记录
//	 */
//	@SuppressWarnings("unchecked")
//	protected List<T> findByPage(String hql,
//		 int pageNo, int pageSize)
//	{
//		// 创建查询
//		return getSessionFactory().getCurrentSession()
//			.createQuery(hql)
//			// 执行分页
//			.setFirstResult((pageNo - 1) * pageSize)
//			.setMaxResults(pageSize)
//			.list();
//	}
//	/**
//	 * 使用hql 语句进行分页查询操作
//	 * @param hql 需要查询的hql语句
//	 * @param params 如果hql带占位符参数，params用于传入占位符参数
//	 * @param pageNo 查询第pageNo页的记录
//	 * @param pageSize 每页需要显示的记录数
//	 * @return 当前页的所有记录
//	 */
//	@SuppressWarnings("unchecked")
//	protected List<T> findByPage(String hql , int pageNo, int pageSize
//		, Object... params)
//	{
//		// 创建查询
//		Query query = getSessionFactory().getCurrentSession()
//			.createQuery(hql);
//		// 为包含占位符的HQL语句设置参数
//		for(int i = 0 , len = params.length ; i < len ; i++)
//		{
//			query.setParameter(i + "" , params[i]);
//		}
//		// 执行分页，并返回查询结果
//		return query.setFirstResult((pageNo - 1) * pageSize)
//			.setMaxResults(pageSize)
//			.list();
//	}
}
