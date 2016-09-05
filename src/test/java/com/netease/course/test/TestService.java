package com.netease.course.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.netease.course.domain.ElecTest;
import com.netease.course.service.ElecTestService;

public class TestService extends BaseTest {

	@Resource(name = ElecTestService.ELEC_TEST_SERVICE_NAME)
	private ElecTestService elecTestServiceImpl;

	@Test
	public void testSave() {
		ElecTest elecTest = new ElecTest();
		elecTest.setTestName("测试Hibernate名称");
		elecTest.setTestDate(new Date());
		elecTest.setTestRemark("测试Hibernate备注");
		elecTestServiceImpl.save(elecTest);
	}

}
