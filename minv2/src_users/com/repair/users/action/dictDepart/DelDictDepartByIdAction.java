package com.repair.users.action.dictDepart;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.repair.entity.DictDepart;
import com.repair.users.service.DictDepartService;
import com.repair.util.action.BaseAction;

/** 
* @ClassName: DelByIdAction
* @Description: TODO(根据部门id，删除)
* @author 唐鹏
* @version V1.0  
* @date 2015-8-5 上午08:30:27
 */
public class DelDictDepartByIdAction extends BaseAction{
   
    private DictDepartService dictDepartService;
	
	private DictDepart dictDepart = new DictDepart();
	
	public String execute() throws Exception {
		DictDepart depart=dictDepartService.findById(dictDepart.getId());
		if(depart != null){
			dictDepartService.delete(depart);
		}
		
		
		return Action.SUCCESS;
	}
	
	public void setDictDepartService(DictDepartService dictDepartService) {
		this.dictDepartService = dictDepartService;
	}

	public DictDepart getDictDepart() {
		return dictDepart;
	}

	public void setDictDepart(DictDepart dictDepart) {
		this.dictDepart = dictDepart;
	}

}
