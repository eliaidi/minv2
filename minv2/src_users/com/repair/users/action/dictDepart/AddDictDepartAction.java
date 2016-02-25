package com.repair.users.action.dictDepart;

import java.io.Serializable;

import com.opensymphony.xwork2.ActionSupport;
import com.repair.entity.DictDepart;
import com.repair.users.service.DictDepartService;
import com.repair.util.action.BaseAction;

/**
 * 
* @ClassName: AddAction
* @Description: TODO(添加数据)
* @author 唐鹏
* @version V1.0  
* @date 2015-8-5 上午08:28:46
 */
public class AddDictDepartAction extends BaseAction{
    
	private DictDepartService dictDepartService;
	private DictDepart dictDepart = new DictDepart();
	
	
	@Override
	public String execute() throws Exception {
		long id=(Long)dictDepartService.save(dictDepart);
		if(id != 0)
			return SUCCESS;
		else
			return ERROR;
	}
	public void setDictDepartService(DictDepartService dictDepartService) {
		this.dictDepartService = dictDepartService;
	}
	public DictDepart getDictDepart() {
		return dictDepart;
	}
	
}
