package com.repair.plan.action.jcMainPlanRecorder;

import com.repair.constant.Constants;
import com.repair.entity.JcMainPlanRecorder;
import com.repair.plan.service.IJcMainPlanRecorderService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @see 删除机车计划详情
 * @author 周云韬
 * @date 2015-11-16
 * @version 1.0
 */
public class AjaxDelJcMainPlanRecorderAction extends BaseAction{

	private IJcMainPlanRecorderService jcMainPlanRecorderService;
		
	
	private Long planRecorderId;
	
	
	@Override
	public String execute() throws Exception {
		if(planRecorderId == null){
			writeJson("1", "计划详情ID为空");
			return null;
		}
		
		try{
			JcMainPlanRecorder recorder=jcMainPlanRecorderService.findById(planRecorderId);
			
			jcMainPlanRecorderService.delete(recorder);
			
			writeJson("0", Constants.COMMON_MESSAGE_DELETE_SUC);
			
		}catch(Exception e){
			writeJson("1", Constants.COMMON_MESSAGE_DELETE_ERROR);
			e.printStackTrace();
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


}
