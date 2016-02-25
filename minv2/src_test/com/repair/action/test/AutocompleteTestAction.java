/**   
* @Title: autocompleteTest.java
* @Package com.repair.action.test
* @Description: TODO(用一句话描述该文件做什么)
* @author tangqian  
* @version V1.0  
* @date 2015-9-2 上午11:22:03 
*/


package com.repair.action.test;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.repair.entity.UsersPrivs;
import com.repair.users.service.UsersPrivsService;

/**
 * @ClassName: autocompleteTest
 * @Description: TODO(智能联想功能动态获取数据测试action)
 * @author dell
 * @version V1.0  
 * @date 2015-9-2 上午11:22:03
 */

public class AutocompleteTestAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private UsersPrivsService usersPrivsService;
	
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<UsersPrivs> userList = usersPrivsService.findAllUsers();
		String userNames = "";
		for (UsersPrivs usersPrivs : userList) {
			userNames += usersPrivs.getUserName()+",";
		}
		request.setAttribute("userNames", userNames);
		
		return SUCCESS;
	}
	public void setUsersPrivsService(UsersPrivsService usersPrivsService) {
		this.usersPrivsService = usersPrivsService;
	}
	
}
