package com.repair.users.action.usersPrivs;

import java.util.HashSet;
import java.util.Set;
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
import com.repair.util.action.BaseAction;

/** 
 * @ClassName: AddUsersAction
 * @Description: TODO(添加数据 (Users_privs)，返回到，班组，部门子页面)
 * @author lxb
 * @version V1.0
 * @date 2015-8-13 下午10:26:14
 */
public class AddUsersAction extends BaseAction implements ModelDriven<UsersPrivs> {
	
	private UsersPrivsService usersPrivsService;
	private DictAreaService dictAreaService;
	private DictDepartService dictDepartService;
	private DictProteamService dictProteamService;
	private RolePrivsService rolePrivsService;
	private UsersRolePrivsService usersRolePrivsService;
	
	private UsersPrivs usersPrivs = new UsersPrivs();
	
	private String roleId;

	// 通用方法
	public void addUsers() {
		// 分割从页面传来的roleId
		String[] roleIdSplit = roleId.split(",");
		try {

			DictArea dictArea = dictAreaService.findById(usersPrivs.getDictArea().getId());
			DictProteam dictProteam = dictProteamService.findById(usersPrivs.getDictProteam().getId());
			DictDepart dictDepart = dictDepartService.findById(usersPrivs.getDictDepart().getId());
			
			Set<UsersRolePrivs> usersRoleSet = new HashSet<UsersRolePrivs>();
			
			for (int i = 0; i < roleIdSplit.length; i++) {
				RolePrivs role = rolePrivsService.findRolePrivsByNameService(roleId);
				if (role != null) {
					UsersRolePrivs usersRolePrivs = new UsersRolePrivs();
					
					usersRolePrivs.setRolePrivs(role);
					usersRolePrivs.setUsersPrivs(usersPrivs);
					usersRoleSet.add(usersRolePrivs);
				}
			}
			
			usersPrivs.setUsersRolePrivs(usersRoleSet);
			usersPrivs.setDictDepart(dictDepart);
			usersPrivs.setDictProteam(dictProteam);
			usersPrivs.setDictArea(dictArea);
			usersPrivsService.addUsers(usersPrivs);

			session.setAttribute("message", Constants.COMMON_MESSAGE_ADD_SUC);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("message", Constants.COMMON_MESSAGE_ADD_ERROR);
		}
	}

	//添加用户，返回到，部门子页面
	public String executeDepart() {
		addUsers();
		return Constants.DEPART_PROTEAM_MANAGE_CHILD_IFRAME;
	}

	//添加用户，返回到，班组子页面
	public String executeProteam() {
		addUsers();
		return Constants.PROTEAM_PROTEAM_MANAGE_CHILD_IFRAME;
	}

	//添加用户，返回到，部门班组（不知是否正确，需查证？？？）
	public String executeDepartProteam() {
		addUsers();
		return SUCCESS;
	}

	public DictAreaService getDictAreaService() {
		return dictAreaService;
	}

	public void setDictAreaService(DictAreaService dictAreaService) {
		this.dictAreaService = dictAreaService;
	}

	public DictDepartService getDictDepartService() {
		return dictDepartService;
	}

	public void setDictDepartService(DictDepartService dictDepartService) {
		this.dictDepartService = dictDepartService;
	}

	public DictProteamService getDictProteamService() {
		return dictProteamService;
	}

	public void setDictProteamService(DictProteamService dictProteamService) {
		this.dictProteamService = dictProteamService;
	}

	public RolePrivsService getRolePrivsService() {
		return rolePrivsService;
	}

	public void setRolePrivsService(RolePrivsService rolePrivsService) {
		this.rolePrivsService = rolePrivsService;
	}

	public UsersPrivsService getUsersPrivsService() {
		return usersPrivsService;
	}

	public void setUsersPrivsService(UsersPrivsService usersPrivsService) {
		this.usersPrivsService = usersPrivsService;
	}

	public UsersPrivs getModel() {
		return this.usersPrivs;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public UsersRolePrivsService getUsersRolePrivsService() {
		return usersRolePrivsService;
	}

	public void setUsersRolePrivsService(UsersRolePrivsService usersRolePrivsService) {
		this.usersRolePrivsService = usersRolePrivsService;
	}

}
