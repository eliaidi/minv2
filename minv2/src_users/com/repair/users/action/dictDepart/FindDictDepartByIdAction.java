package com.repair.users.action.dictDepart;

import com.repair.entity.DictDepart;
import com.repair.users.service.DictDepartService;
import com.repair.util.action.BaseAction;

/**
* @ClassName: FindByIdAction
* @Description: TODO(根据部门id，查找)
* @author 唐鹏
* @version V1.0  
* @date 2015-8-5 上午08:31:25
*/
public class FindDictDepartByIdAction extends BaseAction{
    
    private DictDepartService dictDepartService;
	
	private DictDepart dictDepart = new DictDepart();
	
	public String execute() throws Exception {
		this.dictDepart = dictDepartService.findById(dictDepart.getId());
		return SUCCESS;
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
