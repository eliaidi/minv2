package com.repair.pj.action.assemble.jcPlanDate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.repair.constant.Constants;
import com.repair.constant.MessageConstants;
import com.repair.entity.JcPlanDate;
import com.repair.pj.service.JcPlanDateService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @see Ajax列出尚未交车的机车日计划。可通过 机车检修类型来判断
 * @author 周云韬
 * @date 2016-1-11
 * @version 1.0
 */
public class AjaxListUnDealJcPlanDateAction extends BaseAction{

	private JcPlanDateService jcPlanDateService;
	//
	//机车检修类型。为空则查询所有尚未交车机车
	private Integer projectType;
	
	@Override
	public String execute() throws Exception {
		
		List<JcPlanDate> list=jcPlanDateService.listUnDeal(projectType);

		List<Map<Object, Object>> jsonList=new ArrayList<Map<Object,Object>>();
		for (JcPlanDate planDate : list) {
			Map<Object, Object> map=new HashMap<Object, Object>();
			map.put("id", planDate.getId());
			map.put("jcTypeValue", planDate.getJcTypeValue());
			map.put("jcNumber", planDate.getJcNumber());
			jsonList.add(map);
		}
		
		writeJson(MessageConstants.ERRCODE_NOT_ERROR, new Gson().toJson(jsonList));
		return null;
	}

	
	
	

	public void setProjectType(Integer projectType) {
		this.projectType = projectType;
	}





	public void setJcPlanDateService(JcPlanDateService jcPlanDateService) {
		this.jcPlanDateService = jcPlanDateService;
	}
	
	
	
}
