package com.netease.course.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.netease.course.dao.ElecTestDao;
import com.netease.course.domain.ElecTest;

public class TestDao extends BaseTest {

	@Resource(name = ElecTestDao.ELEC_TEST_DAO_NAME)
	private ElecTestDao elecTestDaoImpl;

	@Test
	public void testSave() {
		ElecTest elecTest = new ElecTest();
		elecTest.setTestName("测试Hibernate名称");
		elecTest.setTestDate(new Date());
		elecTest.setTestRemark("测试Hibernate备注");
		elecTestDaoImpl.save(elecTest);
	}

}
