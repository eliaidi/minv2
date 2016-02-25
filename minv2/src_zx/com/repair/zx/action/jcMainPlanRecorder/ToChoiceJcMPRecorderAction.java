package com.repair.zx.action.jcMainPlanRecorder;

import java.util.List;
import com.opensymphony.xwork2.Action;
import com.repair.constant.Constants;
import com.repair.entity.JcMainPlanRecorder;
import com.repair.util.action.BaseAction;
import com.repair.zx.service.IJcMainPlanRecorderService;

/**
 * 
 * @see 跳至选择计划页面
 * @author 周云韬
 * @date 2015-12-14
 * @version 1.0
 */
public class ToChoiceJcMPRecorderAction extends BaseAction{
	
	private IJcMainPlanRecorderService jcMainPlanRecorderService;

	
	
	@Override
	public String execute() throws Exception {
		/** 查询未兑现的主计划详情  */
		List<JcMainPlanRecorder> list=jcMainPlanRecorderService.listByCash(Constants.JC_MP_RECORDER_CASH_NO);
		
		request.setAttribute("recList", list);
		
		return Action.SUCCESS;
	}
	
	
	
	public void setJcMainPlanRecorderService(
			IJcMainPlanRecorderService jcMainPlanRecorderService) {
		this.jcMainPlanRecorderService = jcMainPlanRecorderService;
	}
	
	
	
	
	
	
	
}
