package com.repair.pj.action.dictPjFirstUnit;

import java.util.List;
import com.opensymphony.xwork2.Action;
import com.repair.entity.DictPjFirstUnit;
import com.repair.pj.service.DictPjFirstUnitService;
import com.repair.pojoUtil.PjSDInfoUtil;
import com.repair.util.action.BaseAction;

/**
* @ClassName: ToFirstUnitManageIframeAction
* @Description: TODO(到专业（大部件）管理页面，实现专业管理的数据查询)
* @author 唐鹏
* @version V1.0  
* @date 2015-9-6 下午03:28:30
 */
public class ToFirstUnitManageIframeAction extends BaseAction {

	private DictPjFirstUnitService dictPjFirstUnitService;

	@Override
	public String execute() throws Exception {
		List<DictPjFirstUnit> list = dictPjFirstUnitService.listAll();
		session.setAttribute("pjFirstUnitList", list);
		session.setAttribute("pjFirstUnitMap",PjSDInfoUtil.getDynamicCountByDictPjFirstUnitList(list));
		return Action.SUCCESS;
	}

	public DictPjFirstUnitService getDictPjFirstUnitService() {
		return dictPjFirstUnitService;
	}

	public void setDictPjFirstUnitService(
			DictPjFirstUnitService dictPjFirstUnitService) {
		this.dictPjFirstUnitService = dictPjFirstUnitService;
	}
}
