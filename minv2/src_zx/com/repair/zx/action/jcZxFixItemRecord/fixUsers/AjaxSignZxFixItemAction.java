package com.repair.zx.action.jcZxFixItemRecord.fixUsers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.repair.constant.Constants;
import com.repair.constant.MessageConstants;
import com.repair.entity.JcZxFixItemRecord;
import com.repair.util.action.BaseAction;
import com.repair.zx.service.IJcZxFixItemRecordService;


/**
 * 
 * @see ajax进行工人签认中修项目
 * @author 周云韬
 * @date 2016-1-6
 * @version 1.0
 */
public class AjaxSignZxFixItemAction extends BaseAction{

	//检修项目ID字符串，以逗号分隔，如1,2,3
	private String ids;
	
	//检修内容
	private String fixCondition;
	
	// 项目类型
	private int itemType;
	
	private IJcZxFixItemRecordService jcZxFixItemRecordService;
	
	@Override
	public String execute() throws Exception {
		if(getLoginUsers() == null){
			writeJson(MessageConstants.ERRCODE_NOT_LOGIN, MessageConstants.MSG_NOT_LOGIN);
			return null;
		}
		try{
			List<JcZxFixItemRecord> list=new ArrayList<JcZxFixItemRecord>();
			
			if(ids == null || ids.split(",").length == 0){
				writeJson(MessageConstants.ERRCODE_NOT_ERROR, "无权限或没有可签项目");
				return null;
			}
			String[] idArr=ids.split(",");
			for (String string : idArr) {
				JcZxFixItemRecord record=jcZxFixItemRecordService.findById(Long.parseLong(string));
				list.add(record);
			}
			
			for (JcZxFixItemRecord record : list) {
				String fixUsers=record.getFixUsers() == null ? "" : record.getFixUsers();
				record.setFixUsers(fixUsers+getLoginUsers().getUserName()+"_"+getLoginUsers().getJobNum()+",");
				record.setFixUsersCheckTime(new Date());
				record.setFixCondition(fixCondition);
				record.setRecordStatus(Constants.JC_ZX_F_I_R_RECORD_STATUS_LEAD_STAY_SIGN);
				jcZxFixItemRecordService.update(record);
			}
			
			writeJson(MessageConstants.ERRCODE_EXCEPTION, MessageConstants.MSG_OPERATOR_SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			writeJson(MessageConstants.ERRCODE_EXCEPTION, MessageConstants.MSG_OPERATOR_ERROR);
		}
		
		
		return null;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public void setFixCondition(String fixCondition) {
		this.fixCondition = fixCondition;
	}

	public void setJcZxFixItemRecordService(
			IJcZxFixItemRecordService jcZxFixItemRecordService) {
		this.jcZxFixItemRecordService = jcZxFixItemRecordService;
	}
	
	
}
