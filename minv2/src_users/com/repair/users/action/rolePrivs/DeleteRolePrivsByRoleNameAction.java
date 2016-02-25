package com.repair.users.action.rolePrivs;

import com.opensymphony.xwork2.ActionSupport;
import com.repair.entity.RolePrivs;
import com.repair.users.service.RolePrivsService;
import com.repair.util.action.BaseAction;

/**
 * ClassName: DeleteByRoleNameAction
 * @Package com.repair.users.action.rolePrivs
 * @Description: TODO(角色表(ROLEPRIVS)，通过roleName删除的action)
 * @author lxb
 * @datetime 2015-8-5 上午 8:30
 */
public class DeleteRolePrivsByRoleNameAction extends BaseAction{
	
	private RolePrivs rolePrivs;
    private RolePrivsService rolePrivsService;
    
    @Override
    public String execute() throws Exception {
	   	return SUCCESS;
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
    
}
