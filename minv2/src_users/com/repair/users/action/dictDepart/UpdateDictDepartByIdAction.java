package com.repair.users.action.dictDepart;

import com.opensymphony.xwork2.Action;
import com.repair.entity.DictDepart;
import com.repair.users.service.DictDepartService;
import com.repair.util.action.BaseAction;

/**
* @ClassName: UpdateByIdAction
* @Description: TODO( 根据部门id，修改)
* @author 唐鹏
* @version V1.0  
* @date 2015-8-5 上午08:32:18
*/
public class UpdateDictDepartByIdAction extends BaseAction{
	
    private DictDepartService dictDepartService;
	
	private DictDepart dictDepart = new DictDepart();

	public String execute() throws Exception {
		dictDepartService.update(dictDepart);
		return Action.SUCCESS;
	}
	
	public void setDictDepartService(DictDepartService dictDepartService) {
		this.dictDepartService = dictDepartService;
	}

	public DictDepart getDictDepart() {
		return dictDepart;
	}
	
}
