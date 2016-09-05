package com.netease.course.web.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.netease.course.domain.ElecTest;
import com.netease.course.service.ElecTestService;

@Controller(value="elecTestAction")
@Scope(value="prototype")
public class ElecTestAction extends BaseAction<ElecTest> {

	private static final long serialVersionUID = 1L;

	private ElecTest elecTest = getModel();

	@Resource(name = ElecTestService.ELEC_TEST_SERVICE_NAME)
	private ElecTestService elecTestServiceImpl;

	/**
	 * 保存
	 * 
	 * @return
	 */
	public String save() {
		elecTestServiceImpl.save(elecTest);
		return "save";
	}

}
