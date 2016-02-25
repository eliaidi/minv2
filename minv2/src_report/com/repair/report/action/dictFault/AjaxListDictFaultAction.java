package com.repair.report.action.dictFault;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.repair.entity.DictFault;
import com.repair.report.service.IDictFaultService;
import com.repair.util.action.BaseAction;

/**
 * @see 查询故障词典，返回json数据，可根据部件类型和父级ID进行查询
 * @author 周云韬
 * @date 2015-12-24
 * @version 1.0
 */
public class AjaxListDictFaultAction extends BaseAction{
	private IDictFaultService dictFaultService;
	private Long parentId;
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		List<DictFault> faultList=dictFaultService.listByConditions(parentId);
		List<Map> jsonList=new ArrayList<Map>();
		for (DictFault fault : faultList) {
			Map map=new HashMap();
			map.put("id", fault.getId());
			map.put("unitType", fault.getUnitType());
			map.put("parentId", fault.getParent() == null ? "" : fault.getParent().getId());
			map.put("unitName", fault.getUnitName());
			map.put("faultContent", fault.getFaultContent());
			map.put("fixContent", fault.getFixContent());
			jsonList.add(map);
		}
		writeJson(0, new Gson().toJson(jsonList));
		return null;
	}

	public void setDictFaultService(IDictFaultService dictFaultService) {
		this.dictFaultService = dictFaultService;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
}
