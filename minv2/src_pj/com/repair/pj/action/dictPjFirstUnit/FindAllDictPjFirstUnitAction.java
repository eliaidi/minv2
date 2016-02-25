package com.repair.pj.action.dictPjFirstUnit;

import java.util.List;
import com.opensymphony.xwork2.Action;
import com.repair.entity.DictPjFirstUnit;
import com.repair.pj.service.DictPjFirstUnitService;
import com.repair.pojoUtil.PjSDInfoUtil;
import com.repair.util.action.BaseAction;

/** 
 * @ClassName: FindAllDictPjFirstUnitAction
 * @Description: TODO(查询大部件(专业)表所有数据)
 * @author 唐鹏
 * @version V1.0
 * @date 2015-8-28 下午09:15:01
 */
public class FindAllDictPjFirstUnitAction extends BaseAction{

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
