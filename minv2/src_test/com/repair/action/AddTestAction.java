package com.repair.action;

import com.opensymphony.xwork2.ActionSupport;
import com.repair.entity.Test;
import com.repair.service.TestService;

public class AddTestAction extends ActionSupport {
	private Test test;
	private TestService testService;
	
	@Override
	public String execute() throws Exception {
		System.out.println("提交-"+test.getName()+"-用户数据");
		this.testService.addTest(test);
		return SUCCESS;
	}

	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}

	public TestService getTestService() {
		return testService;
	}

	public void setTestService(TestService testService) {
		this.testService = testService;
	}
}
