package com.repair.pj.action.dictPjFirstUnit;

import java.util.HashSet;
import java.util.Set;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.entity.DictPjFirstUnit;
import com.repair.entity.JcTypePjFirstUnit;
import com.repair.pj.service.DictJcTypeService;
import com.repair.pj.service.DictPjFirstUnitService;
import com.repair.pj.service.JcTypePjFirstUnitService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @ClassName: AddDictPjFirstUnitAction
 * @Description: TODO(添加专业（大部件）)
 * @author 唐鹏
 * @version V1.0
 * @date 2015-8-28 下午09:14:12
 */
public class AddDictPjFirstUnitAction extends BaseAction implements
		ModelDriven<DictPjFirstUnit> {

	private DictPjFirstUnit dictPjFirstUnit = new DictPjFirstUnit();
	private DictPjFirstUnitService dictPjFirstUnitService;
	private JcTypePjFirstUnitService   jcTypePjFirstUnitService;
	private DictJcTypeService   dictJcTypeService;
	private Integer [] jcTypeId;
	
	@Override
	public String execute() throws Exception {
		//大部件（专业）表
		Set<JcTypePjFirstUnit> set=new HashSet<JcTypePjFirstUnit>();
		if(jcTypeId != null){
			for (Integer jtid : jcTypeId) {
				JcTypePjFirstUnit jtfu=new JcTypePjFirstUnit();
				jtfu.setDictJcType(dictJcTypeService.findById(jtid));
				jtfu.setDictPjFirstUnit(dictPjFirstUnit);
				set.add(jtfu);
			}
		}
		dictPjFirstUnit.setJcTypePjFirstUnits(set);
		dictPjFirstUnitService.save(dictPjFirstUnit);
		session.setAttribute("message", "数据添加成功");
		
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

	public Integer[] getJcTypeId() {
		return jcTypeId;
	}

	public void setJcTypeId(Integer[] jcTypeId) {
		this.jcTypeId = jcTypeId;
	}

	public JcTypePjFirstUnitService getJcTypePjFirstUnitService() {
		return jcTypePjFirstUnitService;
	}

	public void setJcTypePjFirstUnitService(
			JcTypePjFirstUnitService jcTypePjFirstUnitService) {
		this.jcTypePjFirstUnitService = jcTypePjFirstUnitService;
	}

	public void setDictJcTypeService(DictJcTypeService dictJcTypeService) {
		this.dictJcTypeService = dictJcTypeService;
	}
	
}
