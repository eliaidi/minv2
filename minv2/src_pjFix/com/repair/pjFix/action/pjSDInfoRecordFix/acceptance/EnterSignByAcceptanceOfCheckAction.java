package com.repair.pjFix.action.pjSDInfoRecordFix.acceptance;

import java.util.List;
import java.util.Set;
import com.opensymphony.xwork2.Action;
import com.repair.constant.Constants;
import com.repair.entity.PjSDInfoRecord;
import com.repair.entity.PjSDInfoRecordFix;
import com.repair.entity.PjStoreDynamicInfo;
import com.repair.entity.UsersPrivs;
import com.repair.pjFix.service.PjStoreDynamicInfoService;
import com.repair.pojoUtil.PjSDInfoRecordUtil;
import com.repair.util.action.BaseAction;

/** 
* @Description: TODO(验收员对检查项目进行签认)
* @author 唐鹏
* @version V1.0  
* @date 2015-10-9 上午10:41:12
 */
public class EnterSignByAcceptanceOfCheckAction extends BaseAction{
	 
	private PjStoreDynamicInfoService pjSDInfoForPjFixService;
	
	/**定义动态配件编号Id**/
	private long id;
	
	@Override
	public String execute() throws Exception {
		
		//如果用户未登录
		UsersPrivs loginUsers=(UsersPrivs) request.getSession().getAttribute(Constants.LOGIN_USER);
		
		if(loginUsers == null){
			return Action.SUCCESS;
		}
		
		PjStoreDynamicInfo psdi=pjSDInfoForPjFixService.findPjStoreDynamicInfoById(id);
		request.setAttribute("psdi",psdi );
		
		//第一步      动过动态配件Id 得到检修主记录
		List<PjSDInfoRecord> list=PjSDInfoRecordUtil.listPjSDInfoFixMainRecord(psdi,1);
		
		if(list.size() == 0){
			return Action.SUCCESS;
		}
		//获得配件检修记录
		Set<PjSDInfoRecordFix> fixRecordSet=list.get(0).getPjSDInfoRecordFixs();
		request.setAttribute("fixRecordSet", fixRecordSet);
		
		return Action.SUCCESS;
	}
	
	public void setPjSDInfoForPjFixService(
			PjStoreDynamicInfoService pjSDInfoForPjFixService) {
		this.pjSDInfoForPjFixService = pjSDInfoForPjFixService;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
}
