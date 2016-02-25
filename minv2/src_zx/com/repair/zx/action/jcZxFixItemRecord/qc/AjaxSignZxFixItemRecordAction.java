package com.repair.zx.action.jcZxFixItemRecord.qc;

import java.util.ArrayList;
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
 * @see ajax质检员卡控、一键卡控
 * @author 周云韬
 * @date 2016-1-8
 * @version 1.0
 */
public class AjaxSignZxFixItemRecordAction extends BaseAction{
	
	//检修项目ID字符串，以逗号分隔，如1,2,3
	private String ids;
	
	//日计划ID
	private long planDateId;
	
	
	//是否卡控全签
	private boolean signAll;
	
	
	private IJcZxFixItemRecordService jcZxFixItemRecordService;
	
	@Override
	public String execute() throws Exception {
		UsersPrivs loginUsers=getLoginUsers();
		if(getLoginUsers() == null){
			writeJson(MessageConstants.ERRCODE_NOT_LOGIN, MessageConstants.MSG_NOT_LOGIN);
			return null;
		}
		
		try{
			List<JcZxFixItemRecord> list=new ArrayList<JcZxFixItemRecord>();
			//卡控全签当前机车日计划所有检修项目
			if(signAll){
				list=jcZxFixItemRecordService.listByConditions(planDateId,null , null, Constants.ROLE_TYPE_QC);
			}else{
				if(ids == null || ids.split(",").length == 0){
					writeJson(MessageConstants.ERRCODE_NOT_ERROR, "无权限或没有可签项目");
					return null;
				}
				String[] idArr=ids.split(",");
				for (String string : idArr) {
					JcZxFixItemRecord record=jcZxFixItemRecordService.findById(Long.parseLong(string));
					list.add(record);
				}
			}
			
			for (JcZxFixItemRecord record : list) {
				if(isNeedSign(record)){
					record.setQcUsers(loginUsers);
					record.setQcCheckTime(new Date());
					
					if(record.getTechnicianCheck() == Constants.CHECK_STATUS_NEED_CHECK && record.getTechnicianUsers() == null){
						record.setRecordStatus(Constants.JC_ZX_F_I_R_RECORD_STATUS_TECH_STAY_SIGN);
					}else{
						record.setRecordStatus(Constants.JC_ZX_F_I_R_RECORD_STATUS_ACCEPTANCE_STAY_SIGN);
					}
					
					if(JcZxFixItemRecordUtil.isFixFinish(record)){
						record.setRecordStatus(Constants.JC_ZX_F_I_R_RECORD_STATUS_FINISH);
					}
					jcZxFixItemRecordService.update(record);
				}
				
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
		
		if(Constants.CHECK_STATUS_NEED_CHECK.equals(record.getLeadCheck()) && record.getLeadUsers() == null){
			return false;
		}
		
		if(Constants.CHECK_STATUS_NEED_CHECK.equals(record.getCommitLeadCheck())  && record.getCommitLeadCheck() == null ){
			return false;
		}
		if(Constants.CHECK_STATUS_NOT_CHECK.equals(record.getQcCheck()) || record.getQcUsers() != null){
			return false;
		}
		return true;
	}
	
	
	public void setIds(String ids) {
		this.ids = ids;
	}

	


	public void setSignAll(boolean signAll) {
		this.signAll = signAll;
	}



	public void setJcZxFixItemRecordService(
			IJcZxFixItemRecordService jcZxFixItemRecordService) {
		this.jcZxFixItemRecordService = jcZxFixItemRecordService;
	}


	public long getPlanDateId() {
		return planDateId;
	}


	public void setPlanDateId(long planDateId) {
		this.planDateId = planDateId;
	}

	
}
