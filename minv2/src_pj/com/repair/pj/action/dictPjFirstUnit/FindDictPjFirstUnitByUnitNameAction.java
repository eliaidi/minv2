package com.repair.pj.action.dictPjFirstUnit;

import java.util.List;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.entity.DictPjFirstUnit;
import com.repair.pj.service.DictPjFirstUnitService;
import com.repair.util.action.BaseAction;

/**
 * @ClassName: FindDictPjFirstUnitByUnitNameAction
 * @Description: TODO(通过UnitName查询专业（大部件）数据)
 * @author 唐鹏
 * @version V1.0
 * @date 2015-8-28 下午09:16:03
 */
public class FindDictPjFirstUnitByUnitNameAction extends BaseAction implements ModelDriven<DictPjFirstUnit> {

	private DictPjFirstUnit dictPjFirstUnit = new DictPjFirstUnit();
	private DictPjFirstUnitService dictPjFirstUnitService;

	@Override
	public String execute() throws Exception {
		
		List<DictPjFirstUnit> list = dictPjFirstUnitService.findDictPjFirstUnitByUnitName(dictPjFirstUnit.getFirstUnitName());

//		for (DictPjFirstUnit dictPjFirstUnit : list) {
//			System.out.println("大部件专业表名称:" + dictPjFirstUnit.getFirstUnitName()
//					+ "-------" + "大部件专业表id:" + dictPjFirstUnit.getId());
//		}

		return Action.SUCCESS;
	}

	public DictPjFirstUnit getModel() {
		return this.dictPjFirstUnit;
	}

	public void setDictPjFirstUnitService(
			DictPjFirstUnitService dictPjFirstUnitService) {
		this.dictPjFirstUnitService = dictPjFirstUnitService;
	}

}
