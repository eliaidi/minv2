package com.repair.users.action.dictDepart;

import java.util.List;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.repair.entity.DictDepart;
import com.repair.users.service.DictDepartService;
import com.repair.util.action.BaseAction;

/** 
* @ClassName: ToUpdateUsersDepartDialog
* @Description: TODO  跳至转移用户部门页面，并获得所有部门信息
* @author 周云韬
* @version V1.0  
* @date 2015-9-1 上午9:16:46
*/
public class ToUpdateUsersDepartDialog extends BaseAction{
	
	private DictDepartService dictDepartService;
	
	@Override
	public String execute() throws Exception {
		List<DictDepart> departList = dictDepartService.listAll();
		request.setAttribute("departList", departList);
		return Action.SUCCESS;
	}

	public void setDictDepartService(DictDepartService dictDepartService) {
		this.dictDepartService = dictDepartService;
	}
	
}
