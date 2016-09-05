package com.netease.course.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.netease.course.dao.CommonDao;

public class CommonDaoImpl<T> extends HibernateDaoSupport implements CommonDao<T> {
	
	@Resource(name="sessionFactory")
	public void setFactory(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@Override
	public void save(T entity) {
		getHibernateTemplate().save(entity);
	}

}
