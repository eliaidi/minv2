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
 * ClassName: UpdateByIdAction
 * @Package com.repair.users.action.rolePrivs
 * @Description: TODO(角色表(ROLEPRIVS)，通过ID修改的action)
 * @author lxb
 * @datetime 2015-8-5 上午 8:30
 */
public class UpdateRolePrivsByIdAction extends BaseAction implements ModelDriven<RolePrivs> {

	private RolePrivs rolePrivs;
	private RolePrivsService rolePrivsService;
	
	private RolePrivs role = new RolePrivs();

	@Override
	public String execute() throws Exception {
		
		rolePrivsService.updateRolePrivsByIdService(role);
		session.setAttribute("message", Constants.COMMON_MESSAGE_UPDATE_SUC);
		return Action.SUCCESS;
	}

	public void setRolePrivsService(RolePrivsService rolePrivsService) {
		this.rolePrivsService = rolePrivsService;
	}

	public RolePrivs getModel() {
		return this.role;
	}

}
