package com.repair.zx.action.jcFixFlowRecorder;


import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.entity.JcPlanDate;
import com.repair.util.action.BaseAction;
import com.repair.zx.service.IJcPlanDateService;

/**
 * 机车股道转移
 * @author 唐鹏
 *
 */
public class StationRacksTransferAction extends BaseAction implements ModelDriven<JcPlanDate>{
  
	private IJcPlanDateService jcPlanDateService;
	private JcPlanDate jcPlanDate=new JcPlanDate();
	
	@Override
	public String execute() throws Exception {
		JcPlanDate pd=jcPlanDateService.findById(jcPlanDate.getId());
		if(pd!=null)
		{
			pd.setStationNmber(jcPlanDate.getStationNmber());
			pd.setStationRacksNumber(jcPlanDate.getStationRacksNumber());
			jcPlanDateService.update(pd);
		}
		return Action.SUCCESS;
	}

	public void setJcPlanDateService(IJcPlanDateService jcPlanDateService) {
		this.jcPlanDateService = jcPlanDateService;
	}

	public JcPlanDate getModel() {
		return this.jcPlanDate;
	}

	
	
}
