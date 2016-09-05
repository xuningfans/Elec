package com.netease.course.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.netease.course.dao.ElecTestDao;
import com.netease.course.domain.ElecTest;
import com.netease.course.service.ElecTestService;

@Service(ElecTestService.ELEC_TEST_SERVICE_NAME)
public class ElecTestServiceImpl implements ElecTestService {
	
	@Resource(name = ElecTestDao.ELEC_TEST_DAO_NAME)
	private ElecTestDao elecTestDaoImpl;

	@Override
	public void save(ElecTest elecTest) {
		elecTestDaoImpl.save(elecTest);
	}

}
