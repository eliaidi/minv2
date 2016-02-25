package com.repair.action;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.repair.entity.UsersPrivs;
import com.repair.service.TestPageService;
import com.repair.util.page.PageModel;

/**
 * @ClassName: TestPageAction
 * @Description: TODO(∑÷“≥≤‚ ‘action)
 * @author tangqian
 * @version V1.0  
 * @date 2015-8-10 …œŒÁ10:25:12
 */

public class TestPageAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private TestPageService testPageService;
	
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		PageModel<UsersPrivs> pm = testPageService.findAllUserList();
		request.setAttribute("pm", pm);
		return SUCCESS;
	}

	public TestPageService getTestPageService() {
		return testPageService;
	}

	public void setTestPageService(TestPageService testPageService) {
		this.testPageService = testPageService;
	}
	
}
