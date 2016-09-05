package com.netease.course.service;

import com.netease.course.domain.ElecTest;

public interface ElecTestService {
	
	public static final String ELEC_TEST_SERVICE_NAME = "com.netease.course.service.impl.ElecTestServiceImpl";
	
	void save(ElecTest elecTest);

}
