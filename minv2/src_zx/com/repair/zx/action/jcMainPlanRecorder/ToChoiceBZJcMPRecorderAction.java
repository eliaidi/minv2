package com.repair.zx.action.jcMainPlanRecorder;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.repair.constant.Constants;
import com.repair.entity.JcMainPlanRecorder;
import com.repair.util.action.BaseAction;
import com.repair.zx.service.IJcMainPlanRecorderService;
/**
 * @see 跳至显示本周待修机车的页面
 * @author 方岳岳
 * @date 2015-12-17
 * @version 1.0
 */
public class ToChoiceBZJcMPRecorderAction extends BaseAction {
	private IJcMainPlanRecorderService jcMainPlanRecorderService;

	@Override
	public String execute() throws Exception {
		List<JcMainPlanRecorder> list = jcMainPlanRecorderService.listThisWeek(Constants.JC_MP_RECORDER_CASH_NO);
		this.request.setAttribute("listByCash", list);
		return Action.SUCCESS;
	}

	public void setJcMainPlanRecorderService(
			IJcMainPlanRecorderService jcMainPlanRecorderService) {
		this.jcMainPlanRecorderService = jcMainPlanRecorderService;
	}

}
