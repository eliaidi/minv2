package com.repair.zx.action.jcZxFixItemRecord.lead;

import java.util.Date;
import java.util.List;
import com.repair.constant.Constants;
import com.repair.constant.MessageConstants;
import com.repair.entity.JcZxFixItemRecord;
import com.repair.entity.UsersPrivs;
import com.repair.pojoUtil.JcZxFixItemRecordUtil;
import com.repair.util.action.BaseAction;
import com.repair.zx.service.IJcZxFixItemRecordService;


/**
 * 
 * @see ajax进行工长卡控全签中修项目
 * @author 周云韬
 * @date 2016-1-6
 * @version 1.0
 */
public class AjaxSignAllZxFixItemAction extends BaseAction{
	//机车日计划ID
	private long planDateId;
	
	
	private IJcZxFixItemRecordService jcZxFixItemRecordService;
	
	@Override
	public String execute() throws Exception {
		UsersPrivs loginUsers=getLoginUsers();
		if(loginUsers == null){
			writeJson(MessageConstants.ERRCODE_NOT_LOGIN, MessageConstants.MSG_NOT_LOGIN);
			return null;
		}
		try{
			List<JcZxFixItemRecord> list=jcZxFixItemRecordService.listByConditions(planDateId, null, null, Constants.ROLE_TYPE_LEAD);
		
			
			for (JcZxFixItemRecord record : list) {
				
				if(isNeedSign(record)){
					record.setLeadUsers(loginUsers);
					record.setLeadUsersCheckTime(new Date());
					record.setRecordStatus(Constants.JC_ZX_F_I_R_RECORD_STATUS_COMMIT_LEAD_STAY_SIGN);
					
				}
				if(JcZxFixItemRecordUtil.isFixFinish(record)){
					record.setRecordStatus(Constants.JC_ZX_F_I_R_RECORD_STATUS_FINISH);
				}
				jcZxFixItemRecordService.update(record);
			}
			
			writeJson(MessageConstants.ERRCODE_EXCEPTION, MessageConstants.MSG_OPERATOR_SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			writeJson(MessageConstants.ERRCODE_EXCEPTION, MessageConstants.MSG_OPERATOR_ERROR);
		}
		
		
		return null;
	}
	
	/**
	 * 检修项目是否需要签认
	 * @param record
	 * @return
	 */
	public boolean isNeedSign(JcZxFixItemRecord record){
		if(record == null){
			return false;
		}
		
		if(record.getFixUsers() == null){
			return false;
		}
		
		if(Constants.CHECK_STATUS_NOT_CHECK.equals(record.getLeadCheck()) || record.getLeadCheck() == null){
			return false;
		}
		return true;
	}
	


	public void setJcZxFixItemRecordService(
			IJcZxFixItemRecordService jcZxFixItemRecordService) {
		this.jcZxFixItemRecordService = jcZxFixItemRecordService;
	}

	public void setPlanDateId(long planDateId) {
		this.planDateId = planDateId;
	}
	
	
}
