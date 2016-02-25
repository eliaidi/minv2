package com.repair.users.action.functionPrivs;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.entity.RolePrivs;
import com.repair.users.service.RolePrivsService;
import com.repair.util.action.BaseAction;

/** 
* @ClassName: FindFunctinPrivsAllAction
* @Description: TODO(获取所有功能菜单)
* @author 周云韬
* @version V1.0  
* @date 2015-9-24 上午8:29:32
*/
public class FindFunctinPrivsAllAction extends BaseAction implements ModelDriven<RolePrivs> {

	private RolePrivsService rolePrivsService;
	
	private RolePrivs role = new RolePrivs();
	
	@Override
	public String execute() throws Exception {
		RolePrivs rolePrivs=rolePrivsService.findRolePrivsByIdService(role.getId());
		request.setAttribute("role", rolePrivs);
		return  Action.SUCCESS;
	}

	public RolePrivs getModel() {
		return this.role;
	}

	public void setRolePrivsService(RolePrivsService rolePrivsService) {
		this.rolePrivsService = rolePrivsService;
	}

}
