package com.repair.users.action.dictDepart;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.repair.entity.DictDepart;
import com.repair.users.service.DictDepartService;
import com.repair.util.action.BaseAction;

/**
* @ClassName: DelByDepartNameAction
* @Description: TODO(通过部门Name,删除数据)
* @author 唐鹏
* @version V1.0  
* @date 2015-8-5 上午08:29:39
 */
public class DelDictDepartByNameAction extends BaseAction{
     
    private DictDepartService dictDepartService;
	
	private DictDepart dictDepart;
	
	public String execute() throws Exception {
		    DictDepart depat=dictDepartService.findDictDepartByName(dictDepart.getDepartName());
		    dictDepartService.delByDictDepartame(depat.getDepartName());
			return Action.SUCCESS;
	}
	
	public void setDictDepartService(DictDepartService dictDepartService) {
		this.dictDepartService = dictDepartService;
	}

	public void setDictDepart(DictDepart dictDepart) {
		this.dictDepart = dictDepart;
	}
	
}
