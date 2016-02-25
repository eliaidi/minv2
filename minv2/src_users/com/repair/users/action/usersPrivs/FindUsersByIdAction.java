package com.repair.users.action.usersPrivs;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.repair.entity.UsersPrivs;
import com.repair.users.service.UsersPrivsService;
import com.repair.util.action.BaseAction;

/**
 * @ClassName: FindUsersByIdAction
 * @Description: TODO(通过用户ID寻找用户)
 * @author 周云韬
 * @version V1.0
 * @date 2015-8-4 上午10:45:48
 */
public class FindUsersByIdAction extends BaseAction {
	
	private UsersPrivsService usersPrivsService;
	private UsersPrivs usersPrivs;
	
	private long usersId;

	//通过ID查找用户
	public void findUsersById() {
		usersPrivs = usersPrivsService.findUsersById(this.usersId);
		session.setAttribute("usersPrivs", usersPrivs);
	}

	//返回到，部门页面
	public String executeDepart() {
		findUsersById();
		return SUCCESS;
	}

	//返回到，班组页面
	public String executeProteam() {
		findUsersById();
		return SUCCESS;
	}

	//返回到，部门班组，（不知是否正确，需要查证？？？）
	public String executeDepartProteam() {
		findUsersById();
		return SUCCESS;
	}

	public void setUserPrivs(UsersPrivs usersPrivs) {
		this.usersPrivs = usersPrivs;
	}

	public void setUsersPrivsService(UsersPrivsService usersPrivsService) {
		this.usersPrivsService = usersPrivsService;
	}

	public long getUsersId() {
		return usersId;
	}

	public void setUsersId(long usersId) {
		this.usersId = usersId;
	}

}
