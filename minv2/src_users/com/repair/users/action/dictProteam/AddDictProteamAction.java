package com.repair.users.action.dictProteam;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.constant.Constants;
import com.repair.entity.DictProteam;
import com.repair.users.service.DictProteamService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @ClassName: AddAction
 * @Description: TODO(添加班组信息)
 * @author 唐鹏
 * @version V1.0
 * @date 2015-8-5 08:33:07
 */
public class AddDictProteamAction extends BaseAction implements ModelDriven<DictProteam>{

	private DictProteamService dictProteamService;
	
	private DictProteam dictProteam=new DictProteam();

	public String execute() throws Exception {
		long id=(Long) dictProteamService.save(dictProteam);
		
		if(id != 0){
			session.setAttribute("message", Constants.COMMON_MESSAGE_ADD_SUC);
		}else{
			session.setAttribute("message", Constants.COMMON_MESSAGE_ADD_SUC);
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
