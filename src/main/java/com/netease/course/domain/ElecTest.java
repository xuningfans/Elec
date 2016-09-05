package com.netease.course.domain;

import java.io.Serializable;
import java.util.Date;

public class ElecTest implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer testID; // 主键ID
	private String testName; // 测试名称
	private Date testDate; // 测试日期
	private String testRemark; // 测试备注

	public Integer getTestID() {
		return testID;
	}

	public void setTestID(Integer testID) {
		this.testID = testID;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	public String getTestRemark() {
		return testRemark;
	}

	public void setTestRemark(String testRemark) {
		this.testRemark = testRemark;
	}

}
