package com.repair.plan.action.jcMainPlan;

import java.util.Date;
import java.util.List;
import com.opensymphony.xwork2.Action;
import com.repair.entity.JcMainPlan;
import com.repair.plan.service.IJcMainPlanService;
import com.repair.util.action.BaseAction;

/**
 * @see 查询存在的机车检修主计划
 * @author 周云韬
 * @date 2015-11-13
 * @version 1.0
 */
public class QueryExistJcMainPlanAction extends BaseAction{
	
	private IJcMainPlanService jcMainPlanService;
	
	private Date startTime;
	private Date endTime;
	
	@Override
	public String execute() throws Exception {
		
		List<JcMainPlan> planList=jcMainPlanService.listByTimePeriod(startTime, endTime);
		request.setAttribute("planList", planList);
		
		return Action.SUCCESS;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public void setJcMainPlanService(IJcMainPlanService jcMainPlanService) {
		this.jcMainPlanService = jcMainPlanService;
	}
	
}
