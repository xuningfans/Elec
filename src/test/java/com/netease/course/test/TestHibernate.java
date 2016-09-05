package com.netease.course.test;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import com.netease.course.domain.ElecTest;

public class TestHibernate {
	
	@Test
	public void save() {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		ElecTest elecTest = new ElecTest();
		elecTest.setTestName("测试Hibernate名称");
		elecTest.setTestDate(new Date());
		elecTest.setTestRemark("测试Hibernate备注");
		session.save(elecTest);
		
		transaction.commit();
		session.close();
	}
}
