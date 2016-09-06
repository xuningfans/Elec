package com.netease.course.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.netease.course.dao.CommonDao;
import com.netease.course.utils.TUtils;

public class CommonDaoImpl<T> extends HibernateDaoSupport implements CommonDao<T> {
	
	/**泛型转换，获取真实对象实体*/
	protected Class<?> entityClass = TUtils.getTClass(this.getClass());
	
	/**
	 * 注入session工厂
	 * 
	 * @param sessionFactory
	 */
	@Resource(name = "sessionFactory")
	public void setFactory(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@Override
	public void save(T entity) {
		getHibernateTemplate().save(entity);
	}
	
	@Override
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
	}
	
	@Override
	public void saveOrUpdate(T entity) {
		this.getHibernateTemplate().saveOrUpdate(entity);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public T findObjectByID(Serializable id) {
		return (T) this.getHibernateTemplate().get(entityClass, id);
	}

	@Override
	public void deleteObjectByIDs(Serializable... ids) {
		if(ids!=null && ids.length>0){
			for(Serializable id:ids){
				Object entity = this.findObjectByID(id);
				this.getHibernateTemplate().delete(entity);
			}
		}
	}

	@Override
	public void deleteObjectByCollection(List<T> list) {
		this.getHibernateTemplate().deleteAll(list);
	}

	// * 这里1=1的目的是方便在Service层拼装sql或者hql语句，连接统一使用and
	// * SELECT o FROM ElecText o WHERE 1=1 		#Dao层填写
	// * AND o.textName LIKE '%张%' 					#Service拼装
	// * AND o.textRemark LIKE '%张%' 				#Service拼装
	// * ORDER BY o.textDate ASC,o.textName desc 	#Service拼装
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findCollectionByConditionNoPage(String condition, Object[] params, LinkedHashMap<String, String> orderby) {
		String hql = "SELECT o FROM "+entityClass.getSimpleName()+" WHERE 1=1 ";
		String orderByHql = initOrderByHql(orderby);
		String finalHql = hql + condition + orderByHql;
		// 执行hql语句
		/**方式一：直接使用HibernateTemplate的find()方法，find方法支持执行hql语句*/
		//List<T> find = this.getHibernateTemplate().find(finalHql,params);
		/**方式二：获取SessionFactory，在获取Session*/
		//SessionFactory sessionFactory = getHibernateTemplate().getSessionFactory();
		//Session session = sessionFactory.getCurrentSession();
		//Query query = session.createQuery(finalHql);
		//for (int i = 0; i < params.length; i++) {
		//	Object object = params[i];
		//	query.setParameter(i, object);
		//}
		//List<T> list = query.list();
		
		/** 方式三：使用hibernateTemplate调用回调函数 */
		List<T> list = getHibernateTemplate().execute(new HibernateCallback<List<T>>() {
			@Override
			public List<T> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(finalHql);
				if (params != null && params.length > 0) {
					for (int i = 0; i < params.length; i++) {
						query.setParameter(i, params[i]);
					}
				}
				return query.list();
			}
		});
		
		return list;
	}

	/**
	 * 组装排序语句
	 * 
	 * @param orderby
	 * @return
	 */
	private String initOrderByHql(Map<String, String> orderby) {
		StringBuilder sb = new StringBuilder();
		if (orderby!=null && orderby.size() >0) {
			sb.append(" ORDER BY ");
			for(Entry<String, String> entry : orderby.entrySet()){
				sb.append(entry.getKey()+" "+entry.getValue()+",");
			}
			sb.deleteCharAt(sb.length()-1);
		}
		return sb.toString();
	}
	
}
