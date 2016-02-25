package com.repair.plan.action.jcMainPlan;

import java.util.Date;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.entity.JcMainPlan;
import com.repair.plan.service.IJcMainPlanService;
import com.repair.util.action.BaseAction;
import com.repair.util.splitPage.SearchDto;
import com.repair.util.splitPage.SplitPageModel;

/**
 * @see 计划查询
 * @author 周云韬
 * @date 2015-11-13
 * @version 1.0
 */
public class QueryJcMainPlanAction extends BaseAction implements ModelDriven<SearchDto>{
	
	private IJcMainPlanService jcMainPlanService;
	
	private Date startTime;
	private Date endTime;
	
	private SearchDto dto=new SearchDto();
	
	@Override
	public String execute() throws Exception {
		
		SplitPageModel<JcMainPlan> spm=jcMainPlanService.listPageByTimePeriod(startTime, endTime,dto.getPageNo(),dto.getPageSize());
		request.setAttribute("spm", spm);
		
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

	public Date getEndTime() {
		return endTime;
	}

	public void setJcMainPlanService(IJcMainPlanService jcMainPlanService) {
		this.jcMainPlanService = jcMainPlanService;
	}

	public SearchDto getModel() {
		return this.dto;
	}
	
}
