package com.repair.plan.action.jcMainPlan;

import com.opensymphony.xwork2.Action;
import com.repair.entity.JcMainPlan;
import com.repair.plan.service.IJcMainPlanService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @see 通过主计划ID查询主计划兑换详情
 * @author 周云韬
 * @date 2015-11-15
 * @version 1.0
 */
public class FindCashMPRecorderByMainPlanIdAction extends BaseAction{
	
	private IJcMainPlanService jcMainPlanService; 
	
	private Long mainPlanId;
	
	@Override
	public String execute() throws Exception {
		if(mainPlanId == null){
			return Action.SUCCESS;
		}
		
		JcMainPlan mainPlan=jcMainPlanService.findById(mainPlanId);
		
		request.setAttribute("mainPlan", mainPlan);
		
		return Action.SUCCESS;
	}

	public void setJcMainPlanService(IJcMainPlanService jcMainPlanService) {
		this.jcMainPlanService = jcMainPlanService;
	}

	public void setMainPlanId(Long mainPlanId) {
		this.mainPlanId = mainPlanId;
	}
	
	
	
	
}
