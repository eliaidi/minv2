package com.repair.users.action.usersPrivs;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.constant.Constants;
import com.repair.entity.UsersPrivs;
import com.repair.users.service.UsersPrivsService;
import com.repair.util.action.BaseAction;

/** 
* @ClassName: UsersLoginAction
* @Description: TODO(用户登录-->通过工号和密码)
* @author 周云韬
* @version V1.0  
* @date 2015-8-10 上午10:43:43
 */
public class UsersLoginAction extends BaseAction implements ModelDriven<UsersPrivs>{
	
	//用户类的service
	private UsersPrivsService usersPrivsService; 
	
	private UsersPrivs usersPrivs=new UsersPrivs();

	@Override
	public String execute() throws Exception {
		
		UsersPrivs user=usersPrivsService.findUsersByJobNumAndPassword(usersPrivs.getJobNum(), usersPrivs.getPassword());
		
		if(user != null){
			session.setAttribute(Constants.LOGIN_USER, user);
			return Action.SUCCESS;
		}else {
			return Action.LOGIN;
		}
		
	}
	
	public UsersPrivs getModel() {
		return this.usersPrivs;
	}
	
	public void setUsersPrivsService(UsersPrivsService usersPrivsService) {
		this.usersPrivsService = usersPrivsService;
	}
	
}
