package com.repair.zx.action.jcPlanDate;

import com.opensymphony.xwork2.Action;
import com.repair.entity.JcPlanDate;
import com.repair.util.action.BaseAction;
import com.repair.zx.service.IJcPlanDateService;

/**
 * 通过日计划Id 查询对应的日计划扣车信息
 * @author think
 *
 */
public class FindJcPlanDateById extends BaseAction{

	private IJcPlanDateService jcPlanDateService;
	private Long id;
	
	@Override
	public String execute() throws Exception {
		JcPlanDate pd= jcPlanDateService.findById(id);
		request.setAttribute("planDate", pd);
		return Action.SUCCESS;
	}

	public void setJcPlanDateService(IJcPlanDateService jcPlanDateService) {
		this.jcPlanDateService = jcPlanDateService;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
