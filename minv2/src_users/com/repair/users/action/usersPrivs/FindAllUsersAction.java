package com.repair.users.action.usersPrivs;

import java.util.List;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.repair.constant.Constants;
import com.repair.entity.RolePrivs;
import com.repair.entity.UsersPrivs;
import com.repair.users.service.RolePrivsService;
import com.repair.users.service.UsersPrivsService;
import com.repair.util.action.BaseAction;
import com.repair.util.page.PageModel;

/**
* @ClassName: FindAllUsersAction
* @Description: TODO(获取所有用户)
* @author 周云韬
* @version V1.0  
* @date 2015-8-4 上午10:45:48
 */
public class FindAllUsersAction extends BaseAction {
	
	private UsersPrivsService usersPrivsService;
	private RolePrivsService rolePrivsService;
	
	private UsersPrivs userPrivs = new UsersPrivs();

	//查询部门用户
	public String executeDepart() {
		
		userPrivs.setDepartProteamStatus(Constants.DEPART_STATU);
		PageModel<UsersPrivs> pm=usersPrivsService.findUsersList(userPrivs);
		request.setAttribute("pm", pm);
		List<RolePrivs> roleList=rolePrivsService.findRolePrivsAllService();
		request.setAttribute("roleList", roleList);
		
		return SUCCESS;
	}
	
	//查询班主用户
	public String executeProteam() {
		return SUCCESS;
	}
	
	//查询部门班组
	public String executeDepartProteam() {
		return SUCCESS;
	}
	
	public void setUserPrivs(UsersPrivs userPrivs) {
		this.userPrivs = userPrivs;
	}
	public void setUsersPrivsService(UsersPrivsService usersPrivsService) {
		this.usersPrivsService = usersPrivsService;
	}

	public UsersPrivs getUserPrivs() {
		return userPrivs;
	}
	public void setRolePrivsService(RolePrivsService rolePrivsService) {
		this.rolePrivsService = rolePrivsService;
	}
	
}
