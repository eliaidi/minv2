package com.repair.users.action.rolePrivs;

import java.util.List;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.repair.constant.Constants;
import com.repair.entity.RolePrivs;
import com.repair.users.service.RolePrivsService;
import com.repair.util.StringUtil;
import com.repair.util.action.BaseAction;

/**
 * @ClassName: FindRolePrivsInUsersAction
 * @Description: TODO(在用户界面查询所有角色)
 * @author lxb
 * @version V1.0  
 * @date 2015-8-31 上午10:37:45
 */
public class FindRolePrivsInUsersAction extends BaseAction {

	private RolePrivs rolePrivs;
	private RolePrivsService rolePrivsService;
	private String roleInUsersList;

	//查找所有的角色在用户页面
	public void findRolePrivsInUsers() {

		List<RolePrivs> list = rolePrivsService.findRolePrivsAllService();

		request.setAttribute("roleInUsers", list);

		if (StringUtil.isNotBlank(roleInUsersList)) {
			request.setAttribute("roleInUsersList",roleInUsersList);
		}

	}

	//返回，选择角色，在班组
	public String executeProteam() {
		findRolePrivsInUsers();
		return Constants.SELECT_ROLES_IN_USERS_DIALOG_PROTEAM;
	}

	//返回，选择角色，在部门（这里不知道是否正确，待查证？？？）
	public String executeDepart() {
		findRolePrivsInUsers();
		return Constants.SELECT_ROLES_IN_USERS_DIALOG_PROTEAM;
	}

	public RolePrivs getRolePrivs() {
		return rolePrivs;
	}

	public void setRolePrivs(RolePrivs rolePrivs) {
		this.rolePrivs = rolePrivs;
	}

	public RolePrivsService getRolePrivsService() {
		return rolePrivsService;
	}

	public void setRolePrivsService(RolePrivsService rolePrivsService) {
		this.rolePrivsService = rolePrivsService;
	}

	public String getRoleInUsersList() {
		return roleInUsersList;
	}

	public void setRoleInUsersList(String roleInUsersList) {
		this.roleInUsersList = roleInUsersList;
	}

}
