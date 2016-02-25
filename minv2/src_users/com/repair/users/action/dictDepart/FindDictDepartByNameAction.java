package com.repair.users.action.dictDepart;

import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.repair.entity.DictDepart;
import com.repair.users.service.DictDepartService;
import com.repair.util.action.BaseAction;

/** 
* @ClassName: FindByNameAction
* @Description: TODO( 根据部门name，查找)
* @author 唐鹏
* @version V1.0  
* @date 2015-8-5 上午08:31:54
*/
public class FindDictDepartByNameAction extends BaseAction{
	
    private DictDepartService dictDepartService;
	 
	private DictDepart dictDepart = new DictDepart();
	
	public String execute() throws Exception {
		DictDepart depart=dictDepartService.findDictDepartByName(dictDepart.getDepartName());
		
    	
    	if(depart != null){
			pw.write("exist");
		}else{
			pw.write("not exist");
		}
    	return null;
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
