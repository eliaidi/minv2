package com.repair.pjFix.action.pjSDInfoRecordFix.fixUsers;

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
* @ClassName: SignTwoInspectionFixItemByFixUsersAction
* @Description: TODO 复探签认探伤项目
* @author 周云韬
* @version V1.0  
* @date 2015-9-29 上午10:26:57
 */
public class SignTwoInspectionFixItemByFixUsersAction extends BaseAction{
	
	private PjSDInfoRecordFixService pjSDInfoRecordFixForPjFixService;
	private PjStoreDynamicInfoService pjSDInfoForPjFixService;
	
	//用于接收探伤项目的ID
	private Long[] ids;
	
	@Override
	public String execute() throws Exception {
		
		response.setCharacterEncoding(Constants.RESPONSE_DEFAULT_ENCODING);
		
		if(ids == null || ids.length == 0){
			response.getWriter().write(Constants.COMMON_MESSAGE_OPERATE_ERROR);
			return null;
		}
		
		UsersPrivs loginUsers=(UsersPrivs) request.getSession().getAttribute(Constants.LOGIN_USER);
		if(loginUsers == null){
			response.getWriter().write(Constants.COMMON_MESSAGE_OPERATE_ERROR);
			return null;
		}
		try{
			PjSDInfoRecord record=null;
			for (Long id : ids) {
				if(id == null){
					continue;
				}
				
				PjSDInfoRecordFix fix=pjSDInfoRecordFixForPjFixService.findPjSDInfoRecordFixById(id);
				if(fix == null){
					continue;
				}
				record=fix.getPjSDInfoRecord();
				PjSDIRecordFixCheck fixCheck=fix.getPjSDIRecordFixCheck();
				
				//复探需要卡控
				if(fixCheck.getTwoInspectionCheck() == Constants.PJ_SDIRF_CHECK_CHECK_STATU_ONE){
					fixCheck.setTwoInspectionCheckTime(Constants.TIME_STAMP_SYSTEM_DATE);
					fixCheck.setTwoInspectionUsers(loginUsers);
				}
				
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

	public void setPjSDInfoRecordFixForPjFixService(PjSDInfoRecordFixService pjSDInfoRecordFixForPjFixService) {
		this.pjSDInfoRecordFixForPjFixService = pjSDInfoRecordFixForPjFixService;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}

	public void setPjSDInfoForPjFixService(
			PjStoreDynamicInfoService pjSDInfoForPjFixService) {
		this.pjSDInfoForPjFixService = pjSDInfoForPjFixService;
	}	
	
}
