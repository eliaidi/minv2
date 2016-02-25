package com.repair.report.action.jcPlanDate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.repair.entity.JcPlanDate;
import com.repair.report.service.IJcPlanDateService;
import com.repair.util.action.BaseAction;
/**
 * 查询出所有 未交车的 机车检修日计划的信息
 * author 周云韬
 * @date 2015-12-24
 * @version 1.0
 */
public class AjaxListUnDealJcPlanDateAction extends BaseAction{
	private IJcPlanDateService jcPlanDateService;
	
	@Override
	public String execute() throws Exception {
		List<JcPlanDate> list = jcPlanDateService.listUnDeal();
		List<Map<String,Object>> pdJsonList=new ArrayList<Map<String,Object>>();
		for (JcPlanDate pd : list) {
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("id", pd.getId());
			map.put("jcType", pd.getJcTypeValue());
			map.put("jcNumber", pd.getJcNumber());
			map.put("fixMileage", pd.getDictJcFixMileage().getFixMileageValue());
			if(pd.getExtraFixMileage() != null){
				map.put("extraFixMileage", pd.getExtraFixMileage().getFixMileageValue());
			}else{
				map.put("extraFixMileage", "");
			}
			pdJsonList.add(map);
		}
		writeJson(0, new Gson().toJson(pdJsonList));
		return null;
	}
	
	public void setJcPlanDateService(IJcPlanDateService jcPlanDateService) {
		this.jcPlanDateService = jcPlanDateService;
	}
}
