package com.netease.course.dao;

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
	 * @param entity
	 */
	void save(T entity);
	
}
