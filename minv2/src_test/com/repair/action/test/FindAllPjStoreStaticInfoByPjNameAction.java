package com.repair.action.test;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.repair.entity.PjStoreStaticInfo;
import com.repair.service.TestService;

public class FindAllPjStoreStaticInfoByPjNameAction extends ActionSupport{
    private TestService testService;
    
	 @Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		 List<PjStoreStaticInfo> staticInfos=testService.findAllPjStoreStaticInfoByPjName();
		 ServletActionContext.getRequest().setAttribute("staticInfo", staticInfos);
		return Action.SUCCESS;
	}

	public TestService getTestService() {
		return testService;
	}

	public void setTestService(TestService testService) {
		this.testService = testService;
	}
	 
	 
}
