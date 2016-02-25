package com.repair.users.action.dictProteam;

import java.util.List;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.repair.entity.DictProteam;
import com.repair.users.service.DictProteamService;
import com.repair.util.action.BaseAction;

/**
* @ClassName: ToUpdateUsersProteamDialogAction
* @Description: TODO 跳至转移班组页面，查询所有班组信息
* @author 周云韬
* @version V1.0  
* @date 2015-9-1 上午9:03:37
 */
public class ToUpdateUsersProteamDialogAction extends BaseAction{
	 private DictProteamService dictProteamService;
	 //获取用户ID
	 private int[] usersId;
	 
	 public String execute(){
 		List<DictProteam> proteamList = dictProteamService.listAll();
 		session.setAttribute("proteamList", proteamList);
 		return Action.SUCCESS;
     }

	public void setDictProteamService(DictProteamService dictProteamService) {
		this.dictProteamService = dictProteamService;
	}

	public int[] getUsersId() {
		return usersId;
	}

	public void setUsersId(int[] usersId) {
		this.usersId = usersId;
	}
	 	 
}
