package com.repair.users.action.usersPrivs;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.repair.constant.Constants;
import com.repair.entity.RolePrivs;
import com.repair.entity.UsersPrivs;
import com.repair.users.service.RolePrivsService;
import com.repair.users.service.UsersPrivsService;
import com.repair.util.action.BaseAction;
import com.repair.util.page.PageModel;

/**
* @ClassName: FindUsersByDictDepartIdAction
* @Description: TODO(通过部门ID寻找用户)
* @author 周云韬
* @version V1.0  
* @date 2015-8-4 上午10:45:48
 */
public class FindUsersByDictDepartIdAction extends BaseAction {
	
	private UsersPrivsService usersPrivsService; 
	private RolePrivsService rolePrivsService;
	
	private UsersPrivs userPrivs = new UsersPrivs();
	
	private long departId;
	private String flag;
	
	@Override
	public String execute() throws Exception {
		
		PageModel<UsersPrivs> pm=usersPrivsService.findUsersByDictDepartId(departId);
		
		if(Constants.list.equals(flag)){
			
			request.setAttribute("pm", pm);
			List<RolePrivs> roleList=rolePrivsService.findRolePrivsAllService();
			request.setAttribute("roleList", roleList);
			
			return SUCCESS;
			
		}else{
			
			pw.write(pm.getDatas().size()+"");
	    	return null;
		}
	}

	public void setUserPrivs(UsersPrivs userPrivs) {
		this.userPrivs = userPrivs;
	}
	public void setUsersPrivsService(UsersPrivsService usersPrivsService) {
		this.usersPrivsService = usersPrivsService;
	}

	public void setDepartId(long departId) {
		this.departId = departId;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public void setRolePrivsService(RolePrivsService rolePrivsService) {
		this.rolePrivsService = rolePrivsService;
	}
	
}
