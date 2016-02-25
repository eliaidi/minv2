package com.repair.pj.action.dictStorePosition;

import com.opensymphony.xwork2.ModelDriven;
import com.repair.constant.Constants;
import com.repair.entity.DictArea;
import com.repair.entity.DictStorePosition;
import com.repair.pj.service.DictStorePositionService;
import com.repair.users.service.DictAreaService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @ClassName: UpdateDictStorePositionAction
 * @Description: TODO(修改配件所在位置/仓库)
 * @author lxb
 * @version V1.0
 * @date 2015-8-31 上午11:36:16
 */
public class UpdateDictStorePositionAction extends BaseAction implements ModelDriven<DictStorePosition> {

	/** @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) */
	private static final long serialVersionUID = 1L;
	private DictStorePositionService dictStorePositionService;
	private DictStorePosition dictStorePosition = new DictStorePosition();
	private DictAreaService dictAreaService;
	private String returnUrl;
	@Override
	public String execute() throws Exception {
		DictArea dictArea = dictAreaService.findById(dictStorePosition.getDictArea().getId());
		dictStorePosition.setDictArea(dictArea);
		dictStorePositionService.update(dictStorePosition);
		session.setAttribute("message",Constants.COMMON_MESSAGE_UPDATE_SUC);
		return SUCCESS;
	}


	public void setDictStorePositionService(
			DictStorePositionService dictStorePositionService) {
		this.dictStorePositionService = dictStorePositionService;
	}

	public DictStorePosition getModel() {
		return this.dictStorePosition;
	}


	public void setDictAreaService(DictAreaService dictAreaService) {
		this.dictAreaService = dictAreaService;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	
	
}
