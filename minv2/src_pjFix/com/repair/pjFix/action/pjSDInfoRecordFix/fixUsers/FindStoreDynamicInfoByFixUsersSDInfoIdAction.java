package com.repair.pjFix.action.pjSDInfoRecordFix.fixUsers;

import com.opensymphony.xwork2.Action;
import com.repair.entity.PjStoreDynamicInfo;
import com.repair.pjFix.service.PjStoreDynamicInfoService;
import com.repair.util.action.BaseAction;

/**
 * 
* @Description: TODO(通过动态配件Id查询数据)
* @author 唐鹏
* @version V1.0  
* @date 2015-10-9 上午10:41:05
 */
public class FindStoreDynamicInfoByFixUsersSDInfoIdAction extends BaseAction{
	
	private PjStoreDynamicInfoService pjSDInfoForPjFixService;
	
	/**定义动态配件编号Id**/
	private long id;
	
	 @Override
	public String execute() throws Exception {
	    PjStoreDynamicInfo SDList=pjSDInfoForPjFixService.findPjStoreDynamicInfoById(id);
	    request.setAttribute("sdList",SDList);
	    
		return Action.SUCCESS;
	}
	 
	public void setPjSDInfoForPjFixService(PjStoreDynamicInfoService pjSDInfoForPjFixService) {
		this.pjSDInfoForPjFixService = pjSDInfoForPjFixService;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	 
}
