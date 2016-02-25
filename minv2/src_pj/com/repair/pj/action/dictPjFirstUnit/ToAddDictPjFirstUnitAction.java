package com.repair.pj.action.dictPjFirstUnit;

import java.util.List;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.entity.DictJcType;
import com.repair.entity.DictPjFirstUnit;
import com.repair.pj.service.DictJcTypeService;
import com.repair.pj.service.DictPjFirstUnitService;
import com.repair.util.action.BaseAction;

/**
 * @ClassName: ToFindAddDictPjFirstUnitAction
 * @Description: TODO(添加数据（专业（大部件））之前先对数据进行查询)
 * @author 唐鹏
 * @version V1.0
 * @date 2015-8-28 下午09:14:12
 */
public class ToAddDictPjFirstUnitAction extends BaseAction implements
		ModelDriven<DictPjFirstUnit> {

	private DictPjFirstUnit dictPjFirstUnit = new DictPjFirstUnit();
	private DictPjFirstUnitService dictPjFirstUnitService;
	private DictJcTypeService dictJcTypeService;
	
	@Override
	public String execute() throws Exception {
		//查询大部件数据
//		DictPjFirstUnit firstUnit=dictPjFirstUnitService.findDictPjFirstUnitById(dictPjFirstUnit.getId());
//		ServletActionContext.getRequest().getSession().setAttribute("firstUnit", firstUnit);
		
		//查询车型
		List<DictJcType > list=dictJcTypeService.listAll();
		request.setAttribute("dictJcType", list);
		
		return Action.SUCCESS;
	}

	public DictPjFirstUnit getModel() {
		return this.dictPjFirstUnit;
	}

	public DictPjFirstUnitService getDictPjFirstUnitService() {
		return dictPjFirstUnitService;
	}

	public void setDictPjFirstUnitService(
			DictPjFirstUnitService dictPjFirstUnitService) {
		this.dictPjFirstUnitService = dictPjFirstUnitService;
	}

	public DictJcTypeService getDictJcTypeService() {
		return dictJcTypeService;
	}

	public void setDictJcTypeService(DictJcTypeService dictJcTypeService) {
		this.dictJcTypeService = dictJcTypeService;
	}
}
