package com.repair.plan.action.jcMainPlan;

import com.repair.constant.Constants;
import com.repair.entity.JcMainPlan;
import com.repair.plan.service.IJcMainPlanService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @see 删除机车检修主计划
 * @author 周云韬
 * @date 2015-11-13
 * @version 1.0
 */
public class AjaxDelJcMainPlanAction extends BaseAction{

	private IJcMainPlanService jcMainPlanService;
	
	private Long mainPlanId;
	
	
	@Override
	public String execute() throws Exception {
		if(mainPlanId == null){
			writeJson("1", "主计划ID为空");
			return null;
		}
		
		try{
			JcMainPlan plan=jcMainPlanService.findById(mainPlanId);
			
			jcMainPlanService.delete(plan);
			
			writeJson("0", Constants.COMMON_MESSAGE_DELETE_SUC);
			
		}catch(Exception e){
			writeJson("1", Constants.COMMON_MESSAGE_DELETE_ERROR);
			e.printStackTrace();
		}
		return null;
	}


	public void setJcMainPlanService(IJcMainPlanService jcMainPlanService) {
		this.jcMainPlanService = jcMainPlanService;
	}


	public void setMainPlanId(Long mainPlanId) {
		this.mainPlanId = mainPlanId;
	}
	
}
