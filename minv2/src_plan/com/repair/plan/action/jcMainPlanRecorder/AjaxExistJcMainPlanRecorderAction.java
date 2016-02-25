package com.repair.plan.action.jcMainPlanRecorder;

import java.util.Date;
import java.util.List;
import com.repair.entity.JcMainPlanRecorder;
import com.repair.plan.service.IJcMainPlanRecorderService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @see ajax通过时间段查询是否存在机车检修主计划，返回json   
 * 示例：{"errCode":"0","retMsg":"exist"}
 * @author 周云韬
 * @date 2015-11-13
 * @version 1.0
 */
public class AjaxExistJcMainPlanRecorderAction extends BaseAction{

	private IJcMainPlanRecorderService jcMainPlanRecorderService;
	
	private Date startTime;
	
	private Date endTime;
	
	@Override
	public String execute() throws Exception {
		if(getLoginUsers() == null){
			writeJson("-1", "请先登录！");
			return null;
		}
		
		List<JcMainPlanRecorder> list=jcMainPlanRecorderService.listByTimePeriod(startTime, endTime);
		
		
		if(list.size() == 0){
			writeJson("0", "not exist");
		}else{
			writeJson("0", "exist");
		}
		
		return null;
	}
	

	public void setJcMainPlanRecorderService(
			IJcMainPlanRecorderService jcMainPlanRecorderService) {
		this.jcMainPlanRecorderService = jcMainPlanRecorderService;
	}


	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}


	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}


	

	
	
	
}
