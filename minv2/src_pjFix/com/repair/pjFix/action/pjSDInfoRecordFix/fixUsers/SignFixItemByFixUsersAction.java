package com.repair.pjFix.action.pjSDInfoRecordFix.fixUsers;

import com.repair.constant.Constants;
import com.repair.entity.PjSDInfoRecord;
import com.repair.entity.PjSDInfoRecordFix;
import com.repair.entity.UsersPrivs;
import com.repair.pjFix.service.PjSDInfoRecordFixService;
import com.repair.pjFix.service.PjStoreDynamicInfoService;
import com.repair.pojoUtil.PjSDInfoRecordUtil;
import com.repair.util.action.BaseAction;

/**
* @ClassName: SignFixItemByFixUsersAction
* @Description: TODO 工人检查、检测项目、探伤项目签认
* @author 周云韬
* @version V1.0  
* @date 2015-9-29 上午10:26:57
 */
public class SignFixItemByFixUsersAction extends BaseAction{
	
	private PjSDInfoRecordFixService pjSDInfoRecordFixForPjFixService;
	private PjStoreDynamicInfoService pjSDInfoForPjFixService;
	
	private String returnURL;
	//用于接收检查项目的ID,例如：  1,2,3,4
	private String ids;
	//检修情况
	private String fixCondition;
	
	@Override
	public String execute() throws Exception {	
		response.setContentType(Constants.RESPONSE_HEADER_CONTENT_TYPE_TEXT);
		
		if(ids == null || ids.split(",").length == 0){
			response.getWriter().write(Constants.COMMON_MESSAGE_OPERATE_ERROR);
			return null;
		}
		
		String[] idArr=ids.split(",");
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
				
				//修改检修时间和检修人
				fix.setFixTime(Constants.TIME_STAMP_SYSTEM_DATE);
				fix.setFixUsersIds((fix.getFixUsersIds() == null ? "" :fix.getFixUsersIds())+","+loginUsers.getId());
				//修改检修项目节点
				fix.setFixCheckNode(Constants.PJ_SDI_RECORD_FIX_FIX_CHECK_NODE_SECOND);
				//修改检修情况
				fix.setFixCondition(fixCondition);
				//修改动态配件状态为检修中
				fix.getPjSDInfoRecord().getPjStoreDynamicInfo().setPjdStatus(Constants.PJ_STORE_DYNAMIC_INFO_PJD_STATUS_FOUR);
			
				pjSDInfoRecordFixForPjFixService.updatePjSDInfoRecordFix(fix);
			}
			
			//是否检修完毕
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

	public void setPjSDInfoRecordFixForPjFixService(PjSDInfoRecordFixService pjSDInfoRecordFixForPjFixService) {
		this.pjSDInfoRecordFixForPjFixService = pjSDInfoRecordFixForPjFixService;
	}

	public void setPjSDInfoForPjFixService(PjStoreDynamicInfoService pjSDInfoForPjFixService) {
		this.pjSDInfoForPjFixService = pjSDInfoForPjFixService;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public void setFixCondition(String fixCondition) {
		this.fixCondition = fixCondition;
	}

	public String getReturnURL() {
		return returnURL;
	}

	public void setReturnURL(String returnURL) {
		this.returnURL = returnURL;
	}

}
