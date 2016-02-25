package com.repair.zx.action.jcZxFixItemRecord;

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
 * @see 禁用中修项目
 * @author 周云韬
 * @date 2016-1-6
 * @version 1.0
 */
public class AjaxDisabledZxFixItemRecordAction extends BaseAction{
	
	//检修项目ID字符串，以逗号分隔，如1,2,3
	private String ids;
	
	//日计划ID
	private long planDateId;
	
	//检修项目类型。检查/检测项目，一键禁用时才需要用到
	private Integer itemType;
	
	//是否禁用所有（一键禁用）
	private boolean disableAll;
	
	
	private IJcZxFixItemRecordService jcZxFixItemRecordService;
	
	@Override
	public String execute() throws Exception {
		System.out.println(itemType);
		if(getLoginUsers() == null){
			writeJson(MessageConstants.ERRCODE_NOT_LOGIN, MessageConstants.MSG_NOT_LOGIN);
			return null;
		}
		
		try{
			List<JcZxFixItemRecord> list=new ArrayList<JcZxFixItemRecord>();
			//禁用当前用户所在班组所有项目
			if(disableAll){
				long proteamId=getLoginUsers().getDictProteam().getId();
				list=jcZxFixItemRecordService.listByConditions(planDateId,proteamId , itemType, Constants.ROLE_TYPE_FIX_USERS);
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
				if(record.getFixUsers() != null){
					continue;
				}
				String fixUsers=record.getFixUsers() == null ? "" : record.getFixUsers();
				record.setFixUsers(fixUsers+getLoginUsers().getUserName()+"_"+getLoginUsers().getJobNum()+",");
				record.setFixUsersCheckTime(new Date());
				record.setFixCondition("已处理");
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

	public void setDisableAll(boolean disableAll) {
		this.disableAll = disableAll;
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


	public void setItemType(Integer itemType) {
		this.itemType = itemType;
	}
	
	
	
}
