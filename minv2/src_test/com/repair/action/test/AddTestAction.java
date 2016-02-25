package com.repair.action.test;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.repair.entity.DictionaryBase;
import com.repair.entity.Test;
import com.repair.service.TestService;



/**
 * ClassName: InsertTestAction 
 * @Package com.repair.action.test
 * @Description: 插入test实体数据
 * @author andy
 * @datetime Jul 15, 2015 4:21:08 PM
 */
public class AddTestAction extends ActionSupport {
	private Test test;
	private TestService testService;
	
	@Override
	public String execute() throws Exception {
		System.out.println(test.getName()+":"+test.getPassword());
		testService.addTest(test);
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
