package com.repair.users.action.dictDepart;

import java.util.List;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.repair.constant.Constants;
import com.repair.entity.DictDepart;
import com.repair.users.service.DictDepartService;
import com.repair.users.service.UsersPrivsService;
import com.repair.util.action.BaseAction;

/**
* @ClassName: FindAllAction
* @Description: TODO(查询部门表数据)
* @author 唐鹏
* @version V1.0  
* @date 2015-8-5 上午08:30:52
 */
public class FindAllDictDepartAction extends BaseAction {
	
    private DictDepartService dictDepartService;
    private UsersPrivsService usersPrivsService;
	
    private int[] usersId;
	public String execute() throws Exception {
		//所有用户的个数
		int totalUsersCount=usersPrivsService.findUsersByDepartOrProteamStatus(Constants.DEPART_STATU).getCount();
		request.setAttribute("totalUsersCount", totalUsersCount);
		// 获取所有部门
		List<DictDepart> departList=dictDepartService.listAll();
		request.setAttribute("departList", departList);
		
		return Action.SUCCESS;
	}
	public void setDictDepartService(DictDepartService dictDepartService) {
		this.dictDepartService = dictDepartService;
	}

	public void setUsersPrivsService(UsersPrivsService usersPrivsService) {
		this.usersPrivsService = usersPrivsService;
	}
	public int[] getUsersId() {
		return usersId;
	}
	public void setUsersId(int[] usersId) {
		this.usersId = usersId;
	}
		
}
