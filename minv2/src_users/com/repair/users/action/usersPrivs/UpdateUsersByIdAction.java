package com.repair.users.action.usersPrivs;

import java.util.Set;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.constant.Constants;
import com.repair.entity.DictArea;
import com.repair.entity.DictDepart;
import com.repair.entity.DictProteam;
import com.repair.entity.RolePrivs;
import com.repair.entity.UsersPrivs;
import com.repair.entity.UsersRolePrivs;
import com.repair.users.service.DictAreaService;
import com.repair.users.service.DictDepartService;
import com.repair.users.service.DictProteamService;
import com.repair.users.service.RolePrivsService;
import com.repair.users.service.UsersPrivsService;
import com.repair.users.service.UsersRolePrivsService;
import com.repair.util.StringUtil;
import com.repair.util.action.BaseAction;

/**
 * @ClassName: UpdateUsersByIdAction
 * @Description: TODO(通过用户ID修改用户信息)
 * @author 周云韬
 * @version V1.0
 * @date 2015-8-4 上午10:45:48
 */
public class UpdateUsersByIdAction extends BaseAction implements ModelDriven<UsersPrivs> {
	
	private UsersPrivsService usersPrivsService;
	private DictAreaService dictAreaService;
	private DictDepartService dictDepartService;
	private DictProteamService dictProteamService;
	private RolePrivsService rolePrivsService;
	private UsersRolePrivsService usersRolePrivsService;
	
	private UsersPrivs usersPrivs = new UsersPrivs();
	
	private String  roleId;
	private String returnUrl;
	// 一次性修改多个用户班组
	private int[] usersId;
	private int proteamChange;
	private int departChange;
	
	//通过Id修改用户
	public void updateUsersById() {
		
		String[] roleIdSplit = null;
		if(StringUtil.isNotBlank(roleId)){
			roleIdSplit = roleId.split(",");
		}else{
			session.setAttribute("message", "请选择角色");
		}
		try {
			UsersPrivs users = usersPrivsService.findUsersById(this.usersPrivs.getId());
			if (users != null) {
				DictArea dictArea = users.getDictArea() == null ? null: dictAreaService.findById(usersPrivs.getDictArea().getId());
				DictProteam dictProteam = users.getDictProteam() == null ? null: dictProteamService.findById(usersPrivs.getDictProteam().getId());
				DictDepart dictDepart = users.getDictDepart() == null ? null: dictDepartService.findById(usersPrivs.getDictDepart().getId());
				
				Set<UsersRolePrivs> usersRolePrivsSet = users.getUsersRolePrivs();
				
				if(roleIdSplit != null){	
					usersRolePrivsSet.clear();
					
					for (int i = 0; i < roleIdSplit.length; i++) {
						RolePrivs rolePrivs = rolePrivsService.findRolePrivsByIdService(Long.parseLong(roleIdSplit[i]));
						if(rolePrivs!= null){ 
						UsersRolePrivs usersRolePrivs = new UsersRolePrivs();
						usersRolePrivs.setRolePrivs(rolePrivs);
						usersRolePrivs.setUsersPrivs(users);
						usersRolePrivsSet.add(usersRolePrivs);
						}
						  
					}
				}
				
				BeanUtils.copyProperties(users, this.usersPrivs);
				
				users.setDictDepart(dictDepart);
				users.setDictArea(dictArea);
				users.setDictProteam(dictProteam);
				users.setUsersRolePrivs(usersRolePrivsSet);
				
				usersPrivsService.updateUsersById(users);
			}
			if (users == null) {
				if (this.proteamChange != 0) {
					for (int id : usersId) {
						UsersPrivs usersPrivs = usersPrivsService.findUsersById(id);
						
						DictProteam dictProteam = usersPrivs.getDictProteam() == null ? null: dictProteamService.findById(this.proteamChange);
						
						usersPrivs.setDictProteam(dictProteam);
						usersPrivsService.updateUsersById(usersPrivs);
					}
				}
				if (this.departChange != 0) {
					for (int id : usersId) {
						UsersPrivs usersPrivs = usersPrivsService.findUsersById(id);
						
						DictDepart dictDepart = usersPrivs.getDictDepart() == null ? null: dictDepartService.findById(this.departChange);
						
						usersPrivs.setDictDepart(dictDepart);
						usersPrivsService.updateUsersById(usersPrivs);
					}
				}
			}
			session.setAttribute("message", Constants.COMMON_MESSAGE_UPDATE_SUC);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("message", Constants.COMMON_MESSAGE_UPDATE_ERROR);
		}
	}

	public String executeDepart() {
		updateUsersById();
		return Constants.DEPART_ADD_USERS_DIALOG;
	}

	public String executeProteam() {
		updateUsersById();
		return Constants.PROTEAM_ADD_USERS_DIALOG;
	}

	public String executeDepartProteam() {
		updateUsersById();
		return SUCCESS;
	}

	public void setUserPrivs(UsersPrivs usersPrivs) {
		this.usersPrivs = usersPrivs;
	}

	public void setUsersPrivsService(UsersPrivsService usersPrivsService) {
		this.usersPrivsService = usersPrivsService;
	}

	public UsersPrivs getModel() {
		return this.usersPrivs;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setUsersId(int[] usersId) {
		this.usersId = usersId;
	}

	public int[] getUsersId() {
		return usersId;
	}

	public int getProteamChange() {
		return proteamChange;
	}

	public void setProteamChange(int proteamChange) {
		this.proteamChange = proteamChange;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public void setDictAreaService(DictAreaService dictAreaService) {
		this.dictAreaService = dictAreaService;
	}

	public void setDictDepartService(DictDepartService dictDepartService) {
		this.dictDepartService = dictDepartService;
	}

	public void setDictProteamService(DictProteamService dictProteamService) {
		this.dictProteamService = dictProteamService;
	}

	public void setRolePrivsService(RolePrivsService rolePrivsService) {
		this.rolePrivsService = rolePrivsService;
	}

	public UsersRolePrivsService getUsersRolePrivsService() {
		return usersRolePrivsService;
	}

	public void setUsersRolePrivsService(
			UsersRolePrivsService usersRolePrivsService) {
		this.usersRolePrivsService = usersRolePrivsService;
	}

	public int getDepartChange() {
		return departChange;
	}

	public void setDepartChange(int departChange) {
		this.departChange = departChange;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}
