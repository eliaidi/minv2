package com.repair.users.action.dictProteam;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.entity.DictProteam;
import com.repair.users.service.DictProteamService;
import com.repair.util.action.BaseAction;

/** 
* @ClassName: DelByIdAction
* @Description: TODO(根据id，删除班组)
* @author 唐鹏
* @version V1.0  
* @date 2015-8-5 上午08:33:32
*/
public class DelDictProteamByIdAction extends BaseAction implements ModelDriven<DictProteam>{
	
    private DictProteamService dictProteamService;
    
    private DictProteam dictProteam=new DictProteam();
    
    public String execute() throws Exception {
    	DictProteam proteam=dictProteamService.findById(dictProteam.getId());
    	if(proteam != null){
    		dictProteamService.delete(proteam);
    	}
		return Action.SUCCESS;
    }
	
	public void setDictProteamService(DictProteamService dictProteamService) {
		this.dictProteamService = dictProteamService;
	}

	public DictProteam getModel() {
		return this.dictProteam;
	}
		
}
