package com.repair.zx.action.jcPlanDate;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.entity.JcPlanDate;
import com.repair.util.action.BaseAction;
import com.repair.zx.service.IJcPlanDateService;

/**
 * 删除日计划扣车信息
 * @author 唐鹏
 *
 */
public class DeleteJcPlanDateAction extends BaseAction{

	private IJcPlanDateService jcPlanDateService;
	private Long id;
	@Override
	public String execute() throws Exception {

		JcPlanDate pd=jcPlanDateService.findById(id);
		if(pd != null){
			jcPlanDateService.delete(pd);
		}
		
		return Action.SUCCESS;
	}
	
	public void setJcPlanDateService(IJcPlanDateService jcPlanDateService) {
		this.jcPlanDateService = jcPlanDateService;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
