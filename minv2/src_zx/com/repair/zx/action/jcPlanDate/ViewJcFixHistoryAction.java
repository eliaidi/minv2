package com.repair.zx.action.jcPlanDate;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.repair.constant.Constants;
import com.repair.entity.JcPlanDate;
import com.repair.util.action.BaseAction;
import com.repair.zx.service.IJcPlanDateService;

/**
 * 
 * @see 机车检修历史记录
 * @author 周云韬
 * @date 2015-12-18
 * @version 1.0
 */
public class ViewJcFixHistoryAction extends BaseAction{
	
	private IJcPlanDateService jcPlanDateService;
	
	private Long planDateId;
	
	@Override
	public String execute() throws Exception {
		JcPlanDate pd=jcPlanDateService.findById(planDateId);
		
		List<JcPlanDate> pdList=jcPlanDateService.listByConditions(pd.getJcTypeValue(), pd.getJcNumber());
		
		request.setAttribute("historyList", pdList);
		request.setAttribute("pd", pd);
		request.setAttribute("planStatusMap", Constants.JC_PLAN_STATUS);
		return Action.SUCCESS;
	}

	public void setJcPlanDateService(IJcPlanDateService jcPlanDateService) {
		this.jcPlanDateService = jcPlanDateService;
	}

	public void setPlanDateId(Long planDateId) {
		this.planDateId = planDateId;
	}
	
	
	
}
