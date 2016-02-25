package com.repair.users.action.dictArea;

import java.util.List;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.repair.constant.Constants;
import com.repair.entity.DictArea;
import com.repair.entity.DictDepart;
import com.repair.entity.DictProteam;
import com.repair.entity.RolePrivs;
import com.repair.entity.UsersPrivs;
import com.repair.users.service.DictAreaService;
import com.repair.users.service.DictDepartService;
import com.repair.users.service.DictProteamService;
import com.repair.users.service.RolePrivsService;
import com.repair.users.service.UsersPrivsService;
import com.repair.util.action.BaseAction;

/**
 * ClassName: AddAction
 * 
 * @Package com.repair.users.action.dictArea
 * @Description: TODO(地区表(dictArea),查询所有数据)
 * @author lxb
 * @datetime 2015-8-4 下午2:15
 */
public class FindDictAreaAllAction extends BaseAction {
	private DictArea dictArea;
	private long usersId;
	// 判断是否进入修改页面
	private String updateTitle;
	private UsersPrivsService usersPrivsService;
	private DictAreaService dictAreaService;
	private DictProteamService dictProteamService;
	private RolePrivsService rolePrivsService;
	private DictDepartService dictDepartService;

	public void findDictAreaAll() {
		// TODO Auto-generated method stub
		System.out.println("查询所有dictArea进行中....");
		// 获取地区数据
		List<DictArea> dictAreaList = dictAreaService.listAll();
		request.setAttribute("dictAreaList", dictAreaList);
		// 获取班组数据
		List<DictProteam> dictProteamList = dictProteamService.listAll();
		request.setAttribute("dictProteamList", dictProteamList);
		// 获取部门数据
		List<DictDepart> dictDepartList = dictDepartService.listAll();
		request.setAttribute("dictDepartList", dictDepartList);
		// 获取角色数据
		List<RolePrivs> rolePrivsList = rolePrivsService.findRolePrivsAllService();
		request.setAttribute("rolePrivsList", rolePrivsList);

		request.setAttribute("updateTitle", this.updateTitle);

		// 通过ID查询用户
		UsersPrivs usersPrivs = usersPrivsService.findUsersById(this.usersId);
		request.setAttribute("usersPrivs", usersPrivs);
	}

	public String executeDepart() throws Exception {
		findDictAreaAll();
		return Constants.DEPART_ADD_USERS_DIALOG;
	}

	public String executeProteam() throws Exception {
		findDictAreaAll();
		return Constants.PROTEAM_ADD_USERS_DIALOG;
	}

	public String executeDepartProteam() throws Exception {
		findDictAreaAll();
		return SUCCESS;
	}

	public DictArea getDictArea() {
		return dictArea;
	}

	public void setDictArea(DictArea dictArea) {
		this.dictArea = dictArea;
	}

	public DictAreaService getDictAreaService() {
		return dictAreaService;
	}

	public void setDictAreaService(DictAreaService dictAreaService) {
		this.dictAreaService = dictAreaService;
	}

	public DictProteamService getDictProteamService() {
		return dictProteamService;
	}

	public UsersPrivsService getUsersPrivsService() {
		return usersPrivsService;
	}

	public void setUsersPrivsService(UsersPrivsService usersPrivsService) {
		this.usersPrivsService = usersPrivsService;
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

	public DictDepartService getDictDepartService() {
		return dictDepartService;
	}

	public void setDictDepartService(DictDepartService dictDepartService) {
		this.dictDepartService = dictDepartService;
	}

	public long getUsersId() {
		return usersId;
	}

	public void setUsersId(long usersId) {
		this.usersId = usersId;
	}

	public String getUpdateTitle() {
		return updateTitle;
	}

	public void setUpdateTitle(String updateTitle) {
		this.updateTitle = updateTitle;
	}

}
