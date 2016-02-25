package com.repair.report.action.dictProteam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.repair.entity.DictProteam;
import com.repair.report.service.IDictProteamService;
import com.repair.util.action.BaseAction;

/**
 * @see 列出所有班组信息
 * @author 周云韬
 * @date 2015-12-24
 * @version 1.0
 */
public class AjaxListDictProteamAction extends BaseAction{
	private IDictProteamService dictProteamService;
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		List<DictProteam> proteamList=dictProteamService.listAll();
		List<Map> jsonList=new ArrayList<Map>();
		for (DictProteam proteam : proteamList) {
			Map map=new HashMap();
			map.put("id", proteam.getId());
			map.put("proteamName", proteam.getProteamName());
			map.put("workFlag", proteam.getWorkFlag());
			jsonList.add(map);
		}
		writeJson(0, new Gson().toJson(jsonList));
		return null;
	}

	public void setDictProteamService(IDictProteamService dictProteamService) {
		this.dictProteamService = dictProteamService;
	}
}
