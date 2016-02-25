package com.repair.users.action.usersPrivs;

import java.io.IOException;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.repair.constant.Constants;
import com.repair.entity.UsersPrivs;
import com.repair.users.service.UsersPrivsService;
import com.repair.util.action.BaseAction;

/**
 * @ClassName: FindUsersByNameAction
 * @Description: TODO(通过用户名字寻找用户)
 * @author 周云韬
 * @version V1.0
 * @date 2015-8-4 上午10:45:48
 */
public class FindUsersByNameAction extends BaseAction {
	
	private UsersPrivsService usersPrivsService;
	
	private UsersPrivs userPrivs;
	
	private String userName;

	public void findUsersByName() {

		// 局部刷新新增用户页面
		userPrivs = usersPrivsService.findUsersByName(this.userName);
		response.setContentType(Constants.RESPONSE_HEADER_CONTENT_TYPE_TEXT);

		if ("".equals(this.userName)) {
			pw.write(Constants.USERS_NAME_NOT_NULL);
		}
		if (userPrivs != null) {
			pw.write(Constants.USERS_NAME_IN);
		}

	}

	public String executeDepart() {
		findUsersByName();
		return null;
	}

	public String executeProteam() {
		findUsersByName();
		return null;
	}

	public String executeDepartProteam() {
		findUsersByName();
		return null;
	}

	public void setUsersPrivsService(UsersPrivsService usersPrivsService) {
		this.usersPrivsService = usersPrivsService;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
