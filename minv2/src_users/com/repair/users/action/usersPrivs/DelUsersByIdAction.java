package com.repair.users.action.usersPrivs;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.constant.Constants;
import com.repair.entity.UsersPrivs;
import com.repair.users.service.UsersPrivsService;
import com.repair.util.action.BaseAction;

/**
 * @ClassName: DelUsersByIdAction
 * @Description: TODO(通过用户ID删除用户)
 * @author 周云韬
 * @version V1.0
 * @date 2015-8-4 上午10:45:48
 */
public class DelUsersByIdAction extends BaseAction implements ModelDriven<UsersPrivs> {
	
	private UsersPrivsService usersPrivsService;
	
	private UsersPrivs usersPrivs = new UsersPrivs();

	// 删除用户成功 用户管理子页面的URL
	private String returnUrl;
	// 用户ID数组，一次性删除多个用户
	private int[] usersId;

	public void delUsersById() {
 		try {
			for (int id : usersId) {
				usersPrivs = usersPrivsService.findUsersById(id);
				if(usersPrivs!=null){
					usersPrivsService.delUsersById(id);
				}
			}

			session.setAttribute("message", Constants.COMMON_MESSAGE_DELETE_SUC);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("message", Constants.COMMON_MESSAGE_DELETE_ERROR);
		}
	}

	//删除用户，返回到，部门子页面
	public String executeDepart() {
		delUsersById();
		return Constants.DEPART_PROTEAM_MANAGE_CHILD_IFRAME;
	}

	//删除用户，返回到，班组子页面
	public String executeProteam() {
		delUsersById();
		return Constants.PROTEAM_PROTEAM_MANAGE_CHILD_IFRAME;
	}

	//删除用户，返回到，部门班组（不知是否正确，需查证？？？）
	public String executeDepartProteam() {
		delUsersById();
		return SUCCESS;
	}

	public void setUsersPrivsService(UsersPrivsService usersPrivsService) {
		this.usersPrivsService = usersPrivsService;
	}

	public void setUsersId(int[] usersId) {
		this.usersId = usersId;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public UsersPrivs getModel() {
		// TODO Auto-generated method stub
		return this.usersPrivs;
	}

}
