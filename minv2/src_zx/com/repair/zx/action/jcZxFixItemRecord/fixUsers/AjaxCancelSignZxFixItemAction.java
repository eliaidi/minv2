package com.repair.zx.action.jcZxFixItemRecord.fixUsers;

import com.repair.constant.Constants;
import com.repair.constant.MessageConstants;
import com.repair.entity.JcZxFixItemRecord;
import com.repair.util.action.BaseAction;
import com.repair.zx.service.IJcZxFixItemRecordService;

/**
 * 
 * @see Ajax取消签认检修项目
 * @author 周云韬
 * @date 2016-1-6
 * @version 1.0
 */
public class AjaxCancelSignZxFixItemAction extends BaseAction{
	
	//检修项目ID
	private Long id;
	
	private IJcZxFixItemRecordService jcZxFixItemRecordService;
	
	@Override
	public String execute() throws Exception {
		if(getLoginUsers() == null){
			writeJson(MessageConstants.ERRCODE_NOT_LOGIN, MessageConstants.MSG_NOT_LOGIN);
			return null;
		}
		try{
			if(id == null){
				writeJson(MessageConstants.ERRCODE_NOT_ERROR, "检修项目ID为空");
				return null;
			}
			
			JcZxFixItemRecord record=jcZxFixItemRecordService.findById(id);
			if(record == null){
				writeJson(MessageConstants.ERRCODE_NOT_ERROR, "不存在此检修项目ID");
				return null;
			}
			record.setFixCondition(null);
			record.setFixUsers(null);
			record.setFixUsersCheckTime(null);
			record.setRecordStatus(Constants.JC_ZX_F_I_R_RECORD_STATUS_FIXEMP_STAY_SIGN);
			jcZxFixItemRecordService.update(record);
			writeJson(MessageConstants.ERRCODE_NOT_ERROR, MessageConstants.MSG_OPERATOR_SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			writeJson(MessageConstants.ERRCODE_EXCEPTION, MessageConstants.MSG_OPERATOR_ERROR);
		}
		return null;
	}

	

	public void setId(Long id) {
		this.id = id;
	}



	public void setJcZxFixItemRecordService(
			IJcZxFixItemRecordService jcZxFixItemRecordService) {
		this.jcZxFixItemRecordService = jcZxFixItemRecordService;
	}
	
	
}
