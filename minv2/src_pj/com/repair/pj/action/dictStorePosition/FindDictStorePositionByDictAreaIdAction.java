package com.repair.pj.action.dictStorePosition;

import java.util.List;
import com.repair.entity.DictStorePosition;
import com.repair.pj.service.DictStorePositionService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @ClassName: FindDictStorePositionByDictAreaIdAction
 * @Description: TODO(通过areaId进行查询)
 * @author lxb
 * @version V1.0
 * @date 2015-8-28 下午5:26:13
 */
public class FindDictStorePositionByDictAreaIdAction extends BaseAction {

	/** @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) */

	private static final long serialVersionUID = 1L;
	private DictStorePositionService dictStorePositionService;
	private String dictAreaId;

	@Override
	public String execute() throws Exception {
		List<DictStorePosition> list = dictStorePositionService.findDictStorePositionByDictAreaId(dictAreaId);
		if (list.size() > 0) {
			request.setAttribute("dictStorePositionByDictAreaId", list);
		}
		return SUCCESS;
	}

	

	public void setDictStorePositionService(
			DictStorePositionService dictStorePositionService) {
		this.dictStorePositionService = dictStorePositionService;
	}

	public String getDictAreaId() {
		return dictAreaId;
	}

	public void setDictAreaId(String dictAreaId) {
		this.dictAreaId = dictAreaId;
	}

}
