package com.repair.oil.action.oilAssayMainItemRec;

import com.repair.entity.OilAssayMainItemRec;
import com.repair.oil.service.IOilAssayMainItemRecService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @see 跳至修改油水化验主记录页面
 * @author 周云韬
 * @date 2015-12-23
 * @version 1.0
 */
public class ToUpdateOilAMIRecAction extends BaseAction{

	private Long mainRecId;
	
	
	private IOilAssayMainItemRecService oilAssayMainItemRecService;
	
	
	@Override
	public String execute() throws Exception {
		OilAssayMainItemRec rec=oilAssayMainItemRecService.findById(mainRecId);
		request.setAttribute("rec", rec);
		return SUCCESS;
	}


	public Long getMainRecId() {
		return mainRecId;
	}


	public void setMainRecId(Long mainRecId) {
		this.mainRecId = mainRecId;
	}


	public void setOilAssayMainItemRecService(
			IOilAssayMainItemRecService oilAssayMainItemRecService) {
		this.oilAssayMainItemRecService = oilAssayMainItemRecService;
	}
	
	
}
