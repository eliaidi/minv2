package com.repair.users.action.rolePrivs;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.constant.Constants;
import com.repair.entity.RolePrivs;
import com.repair.users.service.RolePrivsService;
import com.repair.util.action.BaseAction;

/**
 * ClassName: AddAction
 * @Package com.repair.users.action.rolePrivs
 * @Description: TODO(角色表(ROLEPRIVS)，添加的action)
 * @author lxb
 * @datetime 2015-8-5 上午 8:30
 */
public class AddRolePrivsAction extends BaseAction implements ModelDriven<RolePrivs> {

	private RolePrivs rolePrivs;
	private RolePrivsService rolePrivsService;
	
	private RolePrivs role = new RolePrivs();

	public String execute() throws Exception {
		// 发给客户端
		rolePrivsService.addRolePrivsService(this.role);
		session.setAttribute("message", Constants.COMMON_MESSAGE_ADD_SUC);
		return Action.SUCCESS;
	}

	public RolePrivs getRolePrivs() {
		return rolePrivs;
	}

	public void setRolePrivs(RolePrivs rolePrivs) {
		this.rolePrivs = rolePrivs;
	}

	public void setRolePrivsService(RolePrivsService rolePrivsService) {
		this.rolePrivsService = rolePrivsService;
	}

	public RolePrivs getModel() {
		return this.role;
	}

}
