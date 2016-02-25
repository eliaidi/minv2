package com.repair.pj.action.dictStorePosition;

import java.util.List;
import com.repair.entity.DictStorePosition;
import com.repair.pj.service.DictStorePositionService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @ClassName: FindDictStorePositionByTypeAction
 * @Description: TODO(通过type进行查询)
 * @author lxb
 * @version V1.0
 * @date 2015-8-28 下午5:25:18
 */
public class FindDictStorePositionByTypeAction extends BaseAction {

	/** @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) */

	private static final long serialVersionUID = 1L;
	private DictStorePosition dictStorePosition;
	private DictStorePositionService dictStorePositionService;
	private int storePositionType;

	@Override
	public String execute() throws Exception {
		List<DictStorePosition> list = dictStorePositionService.findDictStorePositionByType(storePositionType);
		if (list.size() > 0) {
			request.setAttribute("dictStorePositionByType", list);
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

	public int getStorePositionType() {
		return storePositionType;
	}

	public void setStorePositionType(int storePositionType) {
		this.storePositionType = storePositionType;
	}

}
