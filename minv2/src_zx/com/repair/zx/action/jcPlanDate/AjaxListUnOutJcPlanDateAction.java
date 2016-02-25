package com.repair.zx.action.jcPlanDate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.repair.entity.JcPlanDate;
import com.repair.util.action.BaseAction;
import com.repair.zx.service.IJcPlanDateService;

/**
 * @see 跳到显示股道图页面
 * @author 周云韬
 * @date 2015-12-14
 * @version 1.0
 */
public class AjaxListUnOutJcPlanDateAction extends BaseAction{
	
	private IJcPlanDateService jcPlanDateService;
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		
		List<JcPlanDate> list=jcPlanDateService.listByUnOut();

		List jsonList=new ArrayList();
		
		for (JcPlanDate p : list) {
			Map tempMap=new HashMap();
			
			tempMap.put("id", p.getId());
			tempMap.put("jcNumber", p.getJcNumber());
			tempMap.put("stationRacksNumber", p.getStationRacksNumber());
			tempMap.put("stationNmber", p.getStationNmber());
			tempMap.put("jcPlanStatus", p.getJcPlanStatus());
			tempMap.put("jcTypeValue", p.getJcTypeValue());
			tempMap.put("fixMileageValue", p.getDictJcFixMileage().getFixMileageValue());
			
			jsonList.add(tempMap);
		}
		
		writeJson("0", new Gson().toJson(jsonList));
		
		return null;
	}

	public void setJcPlanDateService(IJcPlanDateService jcPlanDateService) {
		this.jcPlanDateService = jcPlanDateService;
	}
	
	
	
}
