package com.repair.pj.action.dictPjFirstUnit;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.entity.DictPjFirstUnit;
import com.repair.entity.JcTypePjFirstUnit;
import com.repair.pj.service.DictJcTypeService;
import com.repair.pj.service.DictPjFirstUnitService;
import com.repair.pj.service.DictStorePositionService;
import com.repair.pj.service.JcTypePjFirstUnitService;
import com.repair.util.action.BaseAction;

/** 
 * @ClassName: UpdateDictPjFirstUnitAction
 * @Description: TODO(修改专业（大部件）数据)
 * @author 唐鹏
 * @version V1.0
 * @date 2015-9-6 下午06:57:05
 */
public class UpdateDictPjFirstUnitAction extends BaseAction implements
		ModelDriven<DictPjFirstUnit> {

	private DictPjFirstUnitService dictPjFirstUnitService;
	private DictJcTypeService dictJcTypeService;
	private JcTypePjFirstUnitService jcTypePjFirstUnitService;
	private DictStorePositionService dictStorePositionService;
	private Integer[] jcTypeId;
	private DictPjFirstUnit dictPjFirstUnit = new DictPjFirstUnit();

	@Override
	public String execute() throws Exception {
		DictPjFirstUnit dictPjFirstUnit = dictPjFirstUnitService.findById(this.dictPjFirstUnit.getId());
		Set<JcTypePjFirstUnit> set = dictPjFirstUnit.getJcTypePjFirstUnits();

		dictPjFirstUnit.setJcTypePjFirstUnits(null);

		if (set != null) {
			Iterator<JcTypePjFirstUnit> it = set.iterator();
			while (it.hasNext()) {
				JcTypePjFirstUnit jtpfu = it.next();
				jtpfu.setDictPjFirstUnit(null);
				jcTypePjFirstUnitService.delete(jtpfu);
			}
		}

		Set<JcTypePjFirstUnit> JcTypePjFirstUnitSet = new HashSet<JcTypePjFirstUnit>();
		for (long jtid : jcTypeId) {
			JcTypePjFirstUnit jcTypePjFirstUnit = new JcTypePjFirstUnit();
			jcTypePjFirstUnit.setDictPjFirstUnit(dictPjFirstUnit);
			jcTypePjFirstUnit.setDictJcType(dictJcTypeService.findById(jtid));
			JcTypePjFirstUnitSet.add(jcTypePjFirstUnit);
		}

		dictPjFirstUnit.setJcTypePjFirstUnits(JcTypePjFirstUnitSet);

		dictPjFirstUnit.setFirstUnitName(this.dictPjFirstUnit.getFirstUnitName());
		dictPjFirstUnit.setPy(this.dictPjFirstUnit.getPy());

		dictPjFirstUnitService.update(dictPjFirstUnit);
		session.setAttribute("message", "数据修改成功");
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

	public Integer[] getJcTypeId() {
		return jcTypeId;
	}

	public void setJcTypeId(Integer[] jcTypeId) {
		this.jcTypeId = jcTypeId;
	}

	public void setJcTypePjFirstUnitService(
			JcTypePjFirstUnitService jcTypePjFirstUnitService) {
		this.jcTypePjFirstUnitService = jcTypePjFirstUnitService;
	}

	public void setDictStorePositionService(
			DictStorePositionService dictStorePositionService) {
		this.dictStorePositionService = dictStorePositionService;
	}

	public void setDictPjFirstUnit(DictPjFirstUnit dictPjFirstUnit) {
		this.dictPjFirstUnit = dictPjFirstUnit;
	}

}
