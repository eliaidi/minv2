package com.repair.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.opensymphony.xwork2.Action;
import com.repair.entity.JcPlanDate;
import com.repair.service.TestService;
import com.repair.util.action.BaseAction;

public class FindAllJcNameAction extends BaseAction {

	private TestService testService;
	@Override
	public String execute() throws Exception {
		List<JcPlanDate> planList=testService.findAllJcName();
		List<Map<String,Object>> pdJsonList=new ArrayList<Map<String,Object>>();
		for (JcPlanDate pd : planList) {
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("id", pd.getId());
			map.put("jcType", pd.getJcTypeValue());
			pdJsonList.add(map);
		}
		writeJson(0, new Gson().toJson(pdJsonList));
		return null;
	}
	public void setTestService(TestService testService) {
		this.testService = testService;
	}
	
	
}
