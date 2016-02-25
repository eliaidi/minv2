package com.repair.users.action.rolePrivs;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.entity.RolePrivs;
import com.repair.users.service.RolePrivsService;
import com.repair.util.action.BaseAction;

/**
 * ClassName: FindByIdAction
 * 
 * @Package com.repair.users.action.rolePrivs
 * @Description: TODO(通过id查找角色)
 * @author lxb
 * @datetime 2015-8-5 下午 8:30
 */
public class FindRolePrivsByIdAction extends BaseAction implements ModelDriven<RolePrivs> {

	private RolePrivs rolePrivs;
	private RolePrivsService rolePrivsService;
	
	private RolePrivs role = new RolePrivs();
	
	@Override
	public String execute() throws Exception {
		
		RolePrivs rolePrivs = rolePrivsService.findRolePrivsByIdService(role.getId());
		request.setAttribute("role",rolePrivs);
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
