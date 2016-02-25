package com.repair.users.action.dictProteam;

import com.opensymphony.xwork2.Action;
import com.repair.entity.DictProteam;
import com.repair.users.service.DictProteamService;
import com.repair.util.action.BaseAction;

/** 
* @ClassName: DelByProteamNameAction
* @Description: TODO(根据班组名，删除)
* @author 唐鹏
* @version V1.0  
* @date 2015-8-5 上午08:33:58
*/
public class DelByProteamNameAction extends BaseAction{
	
    private DictProteamService dictProteamService;
    private DictProteam dictProteam;
    
    public String execute() throws Exception {
    	DictProteam proteam=dictProteamService.findDictProteamByName(dictProteam.getProteamName());
		dictProteamService.delDictProteamByName(proteam.getProteamName());
		return Action.SUCCESS;
    }
	
	public void setDictProteamService(DictProteamService dictProteamService) {
		this.dictProteamService = dictProteamService;
	}

	public void setDictProteam(DictProteam dictProteam) {
		this.dictProteam = dictProteam;
	}
	
}
