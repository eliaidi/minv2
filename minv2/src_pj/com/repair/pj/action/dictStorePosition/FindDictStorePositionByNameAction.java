package com.repair.pj.action.dictStorePosition;

import java.util.List;
import com.repair.entity.DictStorePosition;
import com.repair.pj.service.DictStorePositionService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @ClassName: FindDictStorePositionByNameAction
 * @Description: TODO(通过name进行查询)
 * @author lxb
 * @version V1.0
 * @date 2015-8-28 下午5:25:48
 */
public class FindDictStorePositionByNameAction extends BaseAction {


	private static final long serialVersionUID = 1L;
	private DictStorePosition dictStorePosition;
	private DictStorePositionService dictStorePositionService;
	private String storePositionName;

	@Override
	public String execute() throws Exception {
		List<DictStorePosition> list = dictStorePositionService.findDictStorePositionByName(storePositionName);
		if (list.size() > 0) {
			request.setAttribute("dictStorePositionByName", list);
		}
		return SUCCESS;
	}

	public DictStorePosition getDictStorePosition() {
		return dictStorePosition;
	}

	public void setDictStorePosition(DictStorePosition dictStorePosition) {
		this.dictStorePosition = dictStorePosition;
	}

	public DictStorePositionService getDictStorePositionService() {
		return dictStorePositionService;
	}

	public void setDictStorePositionService(
			DictStorePositionService dictStorePositionService) {
		this.dictStorePositionService = dictStorePositionService;
	}

	public String getStorePositionName() {
		return storePositionName;
	}

	public void setStorePositionName(String storePositionName) {
		this.storePositionName = storePositionName;
	}

}
