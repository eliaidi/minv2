package com.repair.users.action.dictProteam;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.constant.Constants;
import com.repair.entity.DictProteam;
import com.repair.users.service.DictProteamService;
import com.repair.util.action.BaseAction;

/**
* @ClassName: FindByIdAction
* @Description: TODO(根据部门id，查找返回类型：DictProteam[班组])
* @author 唐鹏
* @version V1.0  
* @date 2015-8-5 上午08:35:27
*/
public class FindDictProteamByIdAction extends BaseAction implements ModelDriven<DictProteam>{
	
    private DictProteamService dictProteamService;
    
    private DictProteam dictProteam=new DictProteam();
    
    //标识本次请求功能是什么
    private String flag;
    
	public String execute() throws Exception {
    	 DictProteam proteam= dictProteamService.findById(dictProteam.getId());
    	 
    	 //如果是查询此班组用户个数
    	 if(Constants.find_Users_Count.equals(flag)){
    		 int count=proteam.getUsersPrivses().size();
    		 pw.write(String.valueOf(count));
    		 return null;
    	 }else{
	    	request.setAttribute("proteam", proteam);
			 return Action.SUCCESS;
    	 }
    }
	
	public void setDictProteamService(DictProteamService dictProteamService) {
		this.dictProteamService = dictProteamService;
	}

	public DictProteam getModel() {
		return this.dictProteam;
	}
	
	public void setFlag(String flag) {
		this.flag = flag;
	}

}  
