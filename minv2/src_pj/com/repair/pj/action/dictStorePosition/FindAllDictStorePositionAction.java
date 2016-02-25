package com.repair.pj.action.dictStorePosition;

import java.util.List;
import com.repair.entity.DictStorePosition;
import com.repair.pj.service.DictStorePositionService;
import com.repair.util.action.BaseAction;

/**
 * @ClassName: FindAllDictStorePositionAction
 * @Description: TODO(查找所有的配件所在位置/仓库)
 * @author lxb
 * @version V1.0
 * @date 2015-8-31 上午11:34:42
 */
public class FindAllDictStorePositionAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private DictStorePositionService dictStorePositionService;

	@Override
	public String execute() throws Exception {
		List<DictStorePosition> list = dictStorePositionService.listAll();
		request.setAttribute("dictStorePositionList", list);
		return SUCCESS;
	}

	public DictStorePositionService getDictStorePositionService() {
		return dictStorePositionService;
	}

	public void setDictStorePositionService(
			DictStorePositionService dictStorePositionService) {
		this.dictStorePositionService = dictStorePositionService;
	}

}
