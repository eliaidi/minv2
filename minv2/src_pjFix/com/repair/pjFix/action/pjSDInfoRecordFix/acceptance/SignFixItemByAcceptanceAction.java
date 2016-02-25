package com.repair.pjFix.action.pjSDInfoRecordFix.acceptance;

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
* @ClassName: SignFixItemByAcceptanceAction
* @Description: TODO  验收员签认检修项目
* @author 周云韬
* @version V1.0  
* @date 2015-9-30 上午9:41:00
 */
public class SignFixItemByAcceptanceAction extends BaseAction{
	
	private PjSDInfoRecordFixService pjSDInfoRecordFixForPjFixService;
	private PjStoreDynamicInfoService pjSDInfoForPjFixService;
	
	//用于接收检查项目的ID
	private String ids;
	
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

				PjSDIRecordFixCheck fixCheck=fix.getPjSDIRecordFixCheck();
				//如果不能签认
				if(!isCanSign(fix)){
					continue;
				}
				record=fix.getPjSDInfoRecord();
				//修改检修项目节点
				fix.setFixCheckNode(Constants.PJ_SDI_RECORD_FIX_FIX_CHECK_NODE_SEVEN);
				
				//修改卡控时间
				fixCheck.setAcceptanceCheckTime(Constants.TIME_STAMP_SYSTEM_DATE);
				fixCheck.setAcceptanceUsers(loginUsers);
				
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

	/**
	 * 判断检修项目是否需要卡控
	 * @return boolean    	返回true代表可以签认，返回false不能签认
	 */
	public boolean isCanSign(PjSDInfoRecordFix fix){
		if(fix == null){
			return false;
		}
		PjSDIRecordFixCheck fixCheck=fix.getPjSDIRecordFixCheck();
		//如果工人还没签认，返回false，不能签认
		if(fix.getFixUsersIds() == null || fix.getFixTime() == null){
			return false;
		}
		//如果工长需要卡控且还未签认
		if(fixCheck.getLeadCheck() == Constants.PJ_SDIRF_CHECK_CHECK_STATU_ONE && fixCheck.getLeadCheckTime() == null){
			return false;
		}
		//如果交车工长需要卡控且还未签认
		if(fixCheck.getCommitLeadCheck() == Constants.PJ_SDIRF_CHECK_CHECK_STATU_ONE && fixCheck.getCommitLeadCheckTime() == null){
			return false;
		}
		//如果技术员需要卡控且还未签认
		if(fixCheck.getTechnicianCheck() == Constants.PJ_SDIRF_CHECK_CHECK_STATU_ONE && fixCheck.getCommitLeadCheckTime() == null){
			return false;
		}
		//如果技术员需要卡控且还未签认
		if(fixCheck.getQcCheck() == Constants.PJ_SDIRF_CHECK_CHECK_STATU_ONE && fixCheck.getQcCheckTime() == null){
			return false;
		}
		
		//如果验收员不需要卡控
		if(fixCheck.getAcceptanceCheck() == Constants.JC_INFORMATION_JC_STATUS_ZERO){
			return false;
		}
		return true;
	}
	
	public void setPjSDInfoRecordFixForPjFixService(
			PjSDInfoRecordFixService pjSDInfoRecordFixForPjFixService) {
		this.pjSDInfoRecordFixForPjFixService = pjSDInfoRecordFixForPjFixService;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public void setPjSDInfoForPjFixService(
			PjStoreDynamicInfoService pjSDInfoForPjFixService) {
		this.pjSDInfoForPjFixService = pjSDInfoForPjFixService;
	}
	
}
