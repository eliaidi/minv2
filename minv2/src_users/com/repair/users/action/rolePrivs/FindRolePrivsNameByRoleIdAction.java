package com.repair.users.action.rolePrivs;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.repair.constant.Constants;
import com.repair.entity.RolePrivs;
import com.repair.users.service.RolePrivsService;
import com.repair.util.action.BaseAction;

/**
* @ClassName: FindRolePrivsNameByRoleIdAction
* @Description: TODO(通过RoleID查找RoleName,显示角色名,AJAX)
* @author lxb
* @version V1.0  
* @date 2015-10-12 下午5:41:11
 */
public class FindRolePrivsNameByRoleIdAction extends BaseAction{
	
	private RolePrivsService rolePrivsService;
	
	//字符串，使用逗号分开的，需要通过(,)分离
	private String ids;
	
	@Override
	public String execute() throws Exception {
		
	    String[] roleId	= ids.split(",");
	    String roleNames = "";
	    
	    for (int i = 0; i < roleId.length; i++) {
	    	RolePrivs role = rolePrivsService.findRolePrivsByIdService(Long.parseLong(roleId[i]));
	    	roleNames +=  role.getRoleName()+",";
	    }
	    
	   response.setContentType(Constants.RESPONSE_HEADER_CONTENT_TYPE_TEXT);
	   pw.write(roleNames);
	    
		return null;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public RolePrivsService getRolePrivsService() {
		return rolePrivsService;
	}

	public void setRolePrivsService(RolePrivsService rolePrivsService) {
		this.rolePrivsService = rolePrivsService;
	}
	
}
