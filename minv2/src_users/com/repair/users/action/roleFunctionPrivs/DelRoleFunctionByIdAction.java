package com.repair.users.action.roleFunctionPrivs;

import com.opensymphony.xwork2.ActionSupport;
import com.repair.entity.RoleFunctionPrivs;
import com.repair.users.service.RoleFunctionPrivsService;
import com.repair.util.action.BaseAction;

/** 
* @ClassName: DelRoleFunctionByIdAction
* @Description: TODO(通过角色菜单Id删除角色菜单)
* @author 周云韬
* @version V1.0  
* @date 2015-8-4 下午8:43:33
*/
public class DelRoleFunctionByIdAction extends BaseAction{
	
	private RoleFunctionPrivsService roleFunctionPrivsService;
	private RoleFunctionPrivs roleFunctionPrivs;
	
	@Override
	public String execute() throws Exception {
		RoleFunctionPrivs roleFun=roleFunctionPrivsService.findById(roleFunctionPrivs.getId());
		if(roleFun != null){
			roleFunctionPrivsService.delete(roleFun);
		}
		
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
