package com.repair.users.action.roleFunctionPrivs;

import com.opensymphony.xwork2.ActionSupport;
import com.repair.entity.RoleFunctionPrivs;
import com.repair.users.service.RoleFunctionPrivsService;
import com.repair.util.action.BaseAction;

/**
* @ClassName: DelRoleFunctionByRolePrivsIdAction
* @Description: TODO(通过角色Id删除角色菜单)
* @author 周云韬
* @version V1.0  
* @date 2015-8-4 下午8:43:33
*/
public class DelRoleFunctionByRolePrivsIdAction extends BaseAction{
	
	private RoleFunctionPrivsService roleFunctionPrivsService;
	private RoleFunctionPrivs roleFunctionPrivs;
	
	@Override
	public String execute() throws Exception {
		roleFunctionPrivsService.delRoleFunctionByRole_privs_id(roleFunctionPrivs.getRolePrivs().getId());
		return null;
	}
	
	public void setRoleFunctionPrivs(RoleFunctionPrivs roleFunctionPrivs) {
		this.roleFunctionPrivs = roleFunctionPrivs;
	}

	public void setRoleFunctionPrivsService(
			RoleFunctionPrivsService roleFunctionPrivsService) {
		this.roleFunctionPrivsService = roleFunctionPrivsService;
	}
	
}
