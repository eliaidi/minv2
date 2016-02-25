package com.repair.users.action.rolePrivs;

import java.util.List;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.entity.RoleFunctionPrivs;
import com.repair.entity.RolePrivs;
import com.repair.entity.UsersRolePrivs;
import com.repair.users.service.RoleFunctionPrivsService;
import com.repair.users.service.RolePrivsService;
import com.repair.util.action.BaseAction;

/**
 * ClassName: DeleteByIdAction
 * @Package com.repair.users.action.rolePrivs
 * @Description: TODO(角色表(ROLEPRIVS)，通过ID删除的action)
 * @author lxb
 * @datetime 2015-8-5 上午 8:30
 */
public class DeleteRolePrivsByIdAction extends BaseAction implements ModelDriven<RolePrivs> {

	private RolePrivs rolePrivs;
	private RolePrivsService rolePrivsService;
	private RoleFunctionPrivsService roleFunctionPrivsService;
	
	private RolePrivs role = new RolePrivs();;

	@Override
	public String execute() throws Exception {

		//删除用户角色功能表
		List<UsersRolePrivs> usersRolePrivs= rolePrivsService.findUserRolePrivsByRoleId(role.getId());
		for (UsersRolePrivs urp: usersRolePrivs) {
			rolePrivsService.deleteUsersRolePrivsByRoleId(urp.getId());
		}
		
		//删除角色功能表
		List<RoleFunctionPrivs> roleFunctionPrivs=roleFunctionPrivsService.findRoleFuncs(role.getId());
		for (RoleFunctionPrivs rfp : roleFunctionPrivs) {
			roleFunctionPrivsService.delete(rfp);
		}
		
		//删除角色表
		rolePrivsService.deleteRolePrivsByIdService(role.getId());
		//ServletActionContext.getRequest().getSession().setAttribute("message", "删除角色成功");
		return Action.SUCCESS;
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

	public RolePrivs getModel() {
		// TODO Auto-generated method stub
		return this.role;
	}

	public void setRoleFunctionPrivsService( RoleFunctionPrivsService roleFunctionPrivsService) {
		this.roleFunctionPrivsService = roleFunctionPrivsService;
	}
	
}
