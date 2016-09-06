package com.netease.course.dao;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 基类Dao，负责封装同样增删改查
 * 
 * @author xuning
 *
 * @param <T>
 */
public interface CommonDao<T> {

	/**
	 * 保存对象到数据库
	 * 
	 * @param entity
	 *            需要保存的实体类
	 */
	void save(T entity);

	/**
	 * 更新
	 * 
	 * @param entity
	 *            需要更新的实体类
	 */
	public void update(T entity);

	/**
	 * 保存或更新
	 * 
	 * @param entity
	 *            需要保存或更新的实体类
	 */
	public void saveOrUpdate(T entity);

	/**
	 * 使用主键ID，查询对象
	 * 
	 * @param id
	 *            需要查找对象的id
	 * @return 查找对象的实体类
	 */
	public T findObjectByID(Serializable id);

	/**
	 * 使用主键ID，删除对象（删除一个或者多个对象）
	 * 
	 * @param ids
	 *            需要主键id或主键id数组
	 */
	public void deleteObjectByIDs(Serializable... ids);

	/**
	 * 使用封装对象的集合，批量删除对象
	 * 
	 * @param list
	 *            需要删除的对象集合
	 */
	public void deleteObjectByCollection(List<T> list);

	/**
	 * 指定查询条件，查询结果集（不分页）
	 * 
	 * @param condition
	 *            查询条件
	 * @param params
	 *            查询参数
	 * @param orderby
	 *            排序字段,必须使用LinkedHashMap保证顺序
	 * @return 结果集合
	 */
	List<T> findCollectionByConditionNoPage(String condition, final Object[] params, LinkedHashMap<String, String> orderby);

}
