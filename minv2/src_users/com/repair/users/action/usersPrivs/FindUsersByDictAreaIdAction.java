package com.repair.users.action.usersPrivs;

import com.opensymphony.xwork2.ActionSupport;
import com.repair.entity.UsersPrivs;
import com.repair.users.service.UsersPrivsService;
import com.repair.util.action.BaseAction;

/** 
* @ClassName: FindUsersByDictAreaIdAction
* @Description: TODO(通过机务段ID寻找用户)
* @author 周云韬
* @version V1.0  
* @date 2015-8-4 上午10:45:48
 */
public class FindUsersByDictAreaIdAction extends BaseAction {
	
	private UsersPrivsService usersPrivsService; 
	private UsersPrivs userPrivs;

//	@Override
//	public String execute() throws Exception {
//		System.out.println("findByDictAreaId execute.......");
//		List<UsersPrivs> list=usersPrivsService.findUsersByDictAreaId(this.userPrivs.getDictArea().getId());
//		
//		for (UsersPrivs usersPrivs : list) {
//			System.out.println(usersPrivs.getUserName()+"----"+usersPrivs.getPassword());
//			
//		}
//    	return null;
//	}
	public String executeDepart() {
		
		return SUCCESS;
	}
	public String executeProteam() {
      
		return SUCCESS;
	}
	public String executeDepartProteam() {
		
		return SUCCESS;
	}
	
	
	public void setUserPrivs(UsersPrivs userPrivs) {
		this.userPrivs = userPrivs;
	}
	public void setUsersPrivsService(UsersPrivsService usersPrivsService) {
		this.usersPrivsService = usersPrivsService;
	}
}
