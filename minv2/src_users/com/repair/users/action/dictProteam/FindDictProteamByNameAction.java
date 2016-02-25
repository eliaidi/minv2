package com.repair.users.action.dictProteam;

import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.entity.DictProteam;
import com.repair.users.service.DictProteamService;
import com.repair.util.action.BaseAction;

/**
 * 
* @ClassName: FindByNameAction
* @Description: TODO(根据班组名，查询返回类型：DictProteam[班组类型])
* @author 唐鹏
* @version V1.0  
* @date 2015-8-5 上午08:36:06
 */
public class FindDictProteamByNameAction extends BaseAction implements ModelDriven<DictProteam>{
	
    private DictProteamService dictProteamService;
    private DictProteam dictProteam=new DictProteam();
    
	public String execute() throws Exception {
		
    	DictProteam proteam=dictProteamService.findDictProteamByName(dictProteam.getProteamName());
    	
    	if(proteam != null){
			pw.write("exist");
		}else{
			pw.write("not exist");
		}
		return null;
    }
	
	public void setDictProteamService(DictProteamService dictProteamService) {
		this.dictProteamService = dictProteamService;
	}
	
	public DictProteam getModel() {
		return this.dictProteam;
	}
	
	public DictProteam getDictProteam() {
		return dictProteam;
	}
	
}
