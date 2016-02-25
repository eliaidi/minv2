package com.repair.pj.action.dictPjFirstUnit;

import java.util.List;
import com.opensymphony.xwork2.Action;
import com.repair.entity.DictPjFirstUnit;
import com.repair.pj.service.DictPjFirstUnitService;
import com.repair.pojoUtil.PjSDInfoUtil;
import com.repair.util.action.BaseAction;

/**
* @ClassName: ToUnitManageIframeAction
* @Description: TODO（到配件动态信息管理-车型分类ࣨpj/iframePage/storeDynamicInfo/unitManageIframe.jsp页面）
* @author 唐鹏
* @version V1.0  
* @date 2015-9-6 11:59:02
 */
public class ToUnitManageIframeAction extends BaseAction  {
	private DictPjFirstUnitService dictPjFirstUnitService;
	
	@Override
	public String execute() throws Exception {
		List<DictPjFirstUnit> list = dictPjFirstUnitService.listAll();
		session.setAttribute("pjFirstUnitList", list);
		session.setAttribute("pjFirstUnitMap", PjSDInfoUtil.getDynamicCountByDictPjFirstUnitList(list));
		return Action.SUCCESS;
	}
	public void setDictPjFirstUnitService(
			DictPjFirstUnitService dictPjFirstUnitService) {
		this.dictPjFirstUnitService = dictPjFirstUnitService;
	}
}
