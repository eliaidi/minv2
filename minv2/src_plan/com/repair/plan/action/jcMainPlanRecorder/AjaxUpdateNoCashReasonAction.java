package com.repair.plan.action.jcMainPlanRecorder;

import com.repair.constant.Constants;
import com.repair.entity.JcMainPlanRecorder;
import com.repair.plan.service.IJcMainPlanRecorderService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @see ajax修改 计划详情未兑现原因
 * @author 周云韬
 * @date 2015-11-15
 * @version 1.0
 */
public class AjaxUpdateNoCashReasonAction extends BaseAction{
	
	private IJcMainPlanRecorderService jcMainPlanRecorderService;
	
	private Long planRecorderId;
	
	private String noCashReason;
	
	@Override
	public String execute() throws Exception {
		if(planRecorderId == null){
			writeJson("0", "计划详情ID为空");
			return null;
		}
		
		try {
			JcMainPlanRecorder recorder=jcMainPlanRecorderService.findById(planRecorderId);
			
			if(recorder == null){
				writeJson("0", Constants.COMMON_MESSAGE_UPDATE_ERROR);
			}else{
				recorder.setNoCashReason(noCashReason);
				
				jcMainPlanRecorderService.update(recorder);
				
				writeJson("0", Constants.COMMON_MESSAGE_UPDATE_SUC);
			}
			
			
		} catch (Exception e) {
			writeJson("1", Constants.COMMON_MESSAGE_UPDATE_ERROR);
		}
		
		
		return null;
	}

	public void setJcMainPlanRecorderService(
			IJcMainPlanRecorderService jcMainPlanRecorderService) {
		this.jcMainPlanRecorderService = jcMainPlanRecorderService;
	}

	public void setPlanRecorderId(Long planRecorderId) {
		this.planRecorderId = planRecorderId;
	}

	public void setNoCashReason(String noCashReason) {
		this.noCashReason = noCashReason;
	}

	
	
	
}
