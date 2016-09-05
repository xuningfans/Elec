package com.netease.course.dao.impl;

import org.springframework.stereotype.Repository;

import com.netease.course.dao.ElecTestDao;
import com.netease.course.domain.ElecTest;

@Repository(ElecTestDao.ELEC_TEST_DAO_NAME)
public class ElecTestDaoImpl extends CommonDaoImpl<ElecTest> implements ElecTestDao {

}
