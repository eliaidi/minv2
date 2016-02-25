package com.repair.pjFix.action.pjSDInfoRecordFix.lead;

import com.repair.constant.Constants;
import com.repair.entity.PjSDIRecordFixCheck;
import com.repair.entity.PjSDInfoRecord;
import com.repair.entity.PjSDInfoRecordFix;
import com.repair.entity.UsersPrivs;
import com.repair.pjFix.service.PjSDInfoRecordFixService;
import com.repair.pjFix.service.PjStoreDynamicInfoService;
import com.repair.pojoUtil.PjSDInfoRecordUtil;
import com.repair.util.action.BaseAction;

/**
 * 
* @ClassName: SignFixItemByLeadAction
* @Description: TODO 工长配件检查、检测项目签认
* @author 周云韬
* @version V1.0  
* @date 2015-9-29 上午10:26:57
 */
public class SignFixItemByLeadAction extends BaseAction{
	
	private PjSDInfoRecordFixService pjSDInfoRecordFixForPjFixService;
	private PjStoreDynamicInfoService pjSDInfoForPjFixService;
	
	//用于接收检查项目的ID
	private String ids;
	
	//检修情况
	private String fixCondition;
	
	@Override
	public String execute() throws Exception {
		response.setCharacterEncoding(Constants.RESPONSE_DEFAULT_ENCODING);
		
		if(ids == null || ids.split(",").length == 0){
			response.getWriter().write(Constants.COMMON_MESSAGE_OPERATE_ERROR);
			return null;
		}
		String[] idArr=ids.split(",");
		
		//如果用户没有登录，不进行下一步操作
		UsersPrivs loginUsers=(UsersPrivs) request.getSession().getAttribute(Constants.LOGIN_USER);
		if(loginUsers == null){
			response.getWriter().write(Constants.COMMON_MESSAGE_OPERATE_ERROR);
			return null;
		}
		
		try{
			PjSDInfoRecord record=null;
			for (String tempId : idArr) {
				
				Long id=Long.parseLong(tempId);
				if(id == null){
					continue;
				}
				
				PjSDInfoRecordFix fix=pjSDInfoRecordFixForPjFixService.findPjSDInfoRecordFixById(id);
				if(fix == null){
					continue;
				}
				record=fix.getPjSDInfoRecord();
				
				PjSDIRecordFixCheck fixCheck=fix.getPjSDIRecordFixCheck();
				//以工人身份签认
				fix.setFixUsersIds(fix.getFixUsersIds()+","+loginUsers.getId());
				
				//修改检修项目节点
				fix.setFixCheckNode(Constants.PJ_SDI_RECORD_FIX_FIX_CHECK_NODE_SECOND);
				//修改检修情况
				fix.setFixCondition(fixCondition);
				
				pjSDInfoRecordFixForPjFixService.updatePjSDInfoRecordFix(fix);
			}
			if(PjSDInfoRecordUtil.isFixFinish(record)){
				record.getPjStoreDynamicInfo().setPjdStatus(Constants.PJ_STORE_DYNAMIC_INFO_PJD_STATUS_ONE);
				pjSDInfoForPjFixService.updatePjStoreDynamicInfo(record.getPjStoreDynamicInfo());
			}
		}catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write(Constants.COMMON_MESSAGE_OPERATE_ERROR);
			return null;
		}
		
		response.getWriter().write(Constants.COMMON_MESSAGE_OPERATE_SUC);
		
		return null;
	}

	public void setPjSDInfoForPjFixService(
			PjStoreDynamicInfoService pjSDInfoForPjFixService) {
		this.pjSDInfoForPjFixService = pjSDInfoForPjFixService;
	}

	public void setPjSDInfoRecordFixForPjFixService(
			PjSDInfoRecordFixService pjSDInfoRecordFixForPjFixService) {
		this.pjSDInfoRecordFixForPjFixService = pjSDInfoRecordFixForPjFixService;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public void setFixCondition(String fixCondition) {
		this.fixCondition = fixCondition;
	}
	
}
