package com.repair.users.action.rolePrivs;

import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.entity.RolePrivs;
import com.repair.users.service.RolePrivsService;
import com.repair.util.action.BaseAction;

/**
 * ClassName: FindByIdAction
 * @Package com.repair.users.action.rolePrivs
 * @Description: TODO(角色表(ROLEPRIVS)，通过name查询的action)
 * @author lxb
 * @datetime 2015-8-5 上午 8:30
 */
public class FindRolePrivsByNameAction extends BaseAction implements ModelDriven<RolePrivs> {

	private RolePrivs rolePrivs;
	private RolePrivsService rolePrivsService;
	
	private RolePrivs role = new RolePrivs();

	@Override
	public String execute() throws Exception {
		
		RolePrivs rolePrivs = rolePrivsService.findRolePrivsByNameService(role.getRoleName());

		if (rolePrivs != null) {
			pw.write("exist");
		} else {
			pw.write("not exist");
		}
		return  null;
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
