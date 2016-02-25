package com.repair.pj.action.dictPjFirstUnit;

import java.util.List;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.entity.DictJcType;
import com.repair.entity.DictPjFirstUnit;
import com.repair.entity.JcTypePjFirstUnit;
import com.repair.pj.service.DictJcTypeService;
import com.repair.pj.service.DictPjFirstUnitService;
import com.repair.pj.service.JcTypePjFirstUnitService;
import com.repair.util.action.BaseAction;

/**
 * @ClassName: FindDictPjFirstUnitByIdAction
 * @Description: TODO(通过Id查询专业（大部件）数据)
 * @author 唐鹏
 * @version V1.0
 * @date 2015-8-31 下午02:45:17
 */
public class FindDictPjFirstUnitByIdAction extends BaseAction implements ModelDriven<DictPjFirstUnit> {

	private DictPjFirstUnit dictPjFirstUnit = new DictPjFirstUnit();
	private DictPjFirstUnitService dictPjFirstUnitService;
	private JcTypePjFirstUnitService jcTypePjFirstUnitService;
    private DictJcTypeService dictJcTypeService;
    
	@Override
	public String execute() throws Exception {
		DictPjFirstUnit dpfu = dictPjFirstUnitService.findById(dictPjFirstUnit.getId());
		session.setAttribute("pjFirstUnit", dpfu);
		//中间表
		List<JcTypePjFirstUnit> list=jcTypePjFirstUnitService.listAll();
		session.setAttribute("jcTypePjFirstUnitList", list);
		//车型
		List<DictJcType > dictJcType=dictJcTypeService.listAll();
		session.setAttribute("dictJcType", dictJcType);
		return Action.SUCCESS;
	}

	public DictPjFirstUnit getModel() {
		return this.dictPjFirstUnit;
	}

	public void setDictPjFirstUnitService(
			DictPjFirstUnitService dictPjFirstUnitService) {
		this.dictPjFirstUnitService = dictPjFirstUnitService;
	}

	public void setJcTypePjFirstUnitService(
			JcTypePjFirstUnitService jcTypePjFirstUnitService) {
		this.jcTypePjFirstUnitService = jcTypePjFirstUnitService;
	}

	
	public void setDictJcTypeService(DictJcTypeService dictJcTypeService) {
		this.dictJcTypeService = dictJcTypeService;
	}
	
	
	
}
