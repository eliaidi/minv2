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
import com.repair.pj.service.DictStorePositionService;
import com.repair.util.action.BaseAction;

/**
* @ClassName: ToUpdateDictPjFirstUnitAction
* @Description: TODO(通过大部件(专业)表id查询数据,修改数据)
* @author 唐鹏
* @version V1.0  
* @date 2015-9-6 下午06:57:05
 */
public class ToUpdateDictPjFirstUnitAction extends BaseAction implements ModelDriven<DictPjFirstUnit> {
	
    private DictPjFirstUnitService dictPjFirstUnitService;
    private DictJcTypeService dictJcTypeService;
    private DictStorePositionService dictStorePositionService;
    
	private DictPjFirstUnit dictPjFirstUnit = new DictPjFirstUnit();
	
    private Integer[] jcTypeId;
    
	@Override
	public String execute() throws Exception {
	
		DictPjFirstUnit firstUnit=dictPjFirstUnitService.findById(dictPjFirstUnit.getId());
		session.setAttribute("PjFirstUnit", firstUnit);
		
		//查询车型
		List<DictJcType > list=dictJcTypeService.listAll();
		session.setAttribute("dictJcType", list);
		return Action.SUCCESS;
	}
	
	public DictPjFirstUnit getModel() {
		return this.dictPjFirstUnit;
	}



	public void setDictPjFirstUnitService(
			DictPjFirstUnitService dictPjFirstUnitService) {
		this.dictPjFirstUnitService = dictPjFirstUnitService;
	}


	public void setDictJcTypeService(DictJcTypeService dictJcTypeService) {
		this.dictJcTypeService = dictJcTypeService;
	}

	

	public void setJcTypeId(Integer[] jcTypeId) {
		this.jcTypeId = jcTypeId;
	}

	

	public void setDictStorePositionService(
			DictStorePositionService dictStorePositionService) {
		this.dictStorePositionService = dictStorePositionService;
	}
		
}
