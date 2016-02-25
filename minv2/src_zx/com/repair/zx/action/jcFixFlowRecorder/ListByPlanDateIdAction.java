package com.repair.zx.action.jcFixFlowRecorder;


import java.util.List;

import com.opensymphony.xwork2.Action;
import com.repair.constant.Constants;
import com.repair.entity.JcFixFlowRecorder;
import com.repair.entity.JcPlanDate;
import com.repair.util.action.BaseAction;
import com.repair.zx.service.IJcFixFlowRecorderService;
import com.repair.zx.service.IJcPlanDateService;

/**
 * 通过日计划id，查询对应的机车信息和班组信息(机车信息)
 * @author 唐鹏
 *
 */
public class ListByPlanDateIdAction extends BaseAction{

	 private IJcFixFlowRecorderService jcFixFlowRecorderService;
	 private IJcPlanDateService jcPlanDateService;
	 private Long id;
	 
	 @Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		 
		 List<JcFixFlowRecorder> jcFixFlowRecorderList=jcFixFlowRecorderService.listByPlanDateId(id);
		 JcPlanDate jcPlanDate= jcPlanDateService.findById(id);
		 request.setAttribute("fixFlowRecorderList",jcFixFlowRecorderList);
		 request.setAttribute("jcPlanDate",jcPlanDate);
		 request.setAttribute("status",Constants.JC_FF_RECORDER_STATUS);
		 request.setAttribute("planStatus", Constants.JC_PLAN_STATUS);
		 
		 return Action.SUCCESS;
	}
	 
	public void setJcFixFlowRecorderService(
			IJcFixFlowRecorderService jcFixFlowRecorderService) {
		this.jcFixFlowRecorderService = jcFixFlowRecorderService;
	}
	
	public void setJcPlanDateService(IJcPlanDateService jcPlanDateService) {
		this.jcPlanDateService = jcPlanDateService;
	}

	public void setId(Long id) {
		this.id = id;
	}
	 
	 
}
