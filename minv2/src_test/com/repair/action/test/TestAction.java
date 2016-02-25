package com.repair.action.test;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.constant.Constants;
import com.repair.entity.Test;
import com.repair.pjFix.dto.PjStoreDynamicInfoSearchDto;
import com.repair.pjFix.service.PjStoreDynamicInfoService;
import com.repair.service.TestService;

public class TestAction extends ActionSupport implements ModelDriven<Test>{
	
	private Test test=new Test();
	private TestService testService;
	
	private PjStoreDynamicInfoService pjSDInfoForPjFixService;
	
	@Override
	public String execute() throws Exception {
		ServletActionContext.getRequest().setAttribute("sp", testService.findAllTest(test));
		
		PjStoreDynamicInfoSearchDto dto=new PjStoreDynamicInfoSearchDto();
		dto.setRoleType(Constants.ROLE_TYPE_COMMIT_LEAD);
		dto.setFixItemQueryFlag(0);
		dto.setPjSSInfoId(21L);
		System.out.println(pjSDInfoForPjFixService.
				queryPjStoreDynamicInfo(dto).getTotalCount());
		return super.execute();
	}

	
	
	
	public void setPjSDInfoForPjFixService(
			PjStoreDynamicInfoService pjSDInfoForPjFixService) {
		this.pjSDInfoForPjFixService = pjSDInfoForPjFixService;
	}




	public void setTestService(TestService testService) {
		this.testService = testService;
	}

	
	
	
	public Test getModel() {
		return this.test;
	}
	
	
	
	
}
