package com.repair.zx.action.jcPlanDate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.repair.constant.Constants;
import com.repair.entity.JcPlanDate;
import com.repair.util.action.BaseAction;
import com.repair.zx.service.IJcPlanDateService;

/**
 * 
 * 实现ListByUnOutAction中的listByUnOut方法，查出未交车的机车信息
 *
 */
public class ListUnOutJcPlanDateAction extends BaseAction {

	private IJcPlanDateService jcPlanDateService;
	
	private String type;
	
	public String execute() throws Exception {
		List<JcPlanDate> planList=jcPlanDateService.listByUnOut();
		
		request.setAttribute("planStatus", Constants.JC_PLAN_STATUS);
		//request.setAttribute("planList", planList);
		
		//将小辅修和中修分开显示
		Map<Integer, List<JcPlanDate>> map=new HashMap<Integer, List<JcPlanDate>>();
		for (JcPlanDate pd : planList) {
			List<JcPlanDate> tempList=map.get(pd.getProjectType());
			if(tempList == null){
				tempList=new ArrayList<JcPlanDate>();
			}
			tempList.add(pd);
			map.put(pd.getProjectType(), tempList);
		}
		request.setAttribute("planMap", map);
		
		request.setAttribute("projectTypeMap", Constants.JC_PLAN_DATE_PROJECT_TYPE);
		//类型-->中修 
		request.setAttribute("zhongFix", Constants.JC_PLAN_DATE_PROJECT_TYPE_ZHONG_FIX);
		//类型-->小辅修 
		request.setAttribute("xiaofuFix", Constants.JC_PLAN_DATE_PROJECT_TYPE_XIAOFU_FIX);
		
		if("JCGZ".equals(type)){
			return "JCGZ";
		}
		return Action.SUCCESS;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public void setJcPlanDateService(IJcPlanDateService jcPlanDateService) {
		this.jcPlanDateService = jcPlanDateService;
	}

	
	


	

}
