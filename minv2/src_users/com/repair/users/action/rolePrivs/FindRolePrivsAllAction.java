package com.repair.users.action.rolePrivs;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.repair.entity.RolePrivs;
import com.repair.users.service.RolePrivsService;
import com.repair.util.action.BaseAction;
import com.repair.util.page.PageModel;

/**
 * ClassName: FindAllAction
 * @Package com.repair.users.action.rolePrivs
 * @Description: TODO(角色表(ROLEPRIVS)，(分页)查询所有的action)
 * @author lxb
 * @datetime 2015-8-5 上午 8:30
 */
public class FindRolePrivsAllAction extends BaseAction {

	private RolePrivs rolePrivs;
	private RolePrivsService rolePrivsService;

	public String execute() throws Exception {
		PageModel<RolePrivs> pm = rolePrivsService.findRolePrivsList();
		request.setAttribute("Role", pm);
		return Action.SUCCESS;
	}

	public void setRolePrivsService(RolePrivsService rolePrivsService) {
		this.rolePrivsService = rolePrivsService;
	}

	public RolePrivs getRolePrivs() {
		return rolePrivs;
	}

	public void setRolePrivs(RolePrivs rolePrivs) {
		this.rolePrivs = rolePrivs;
	}
	
}
