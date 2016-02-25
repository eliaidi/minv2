package com.repair.oil.action.oilAssayMainItemRec;

import com.opensymphony.xwork2.Action;
import com.repair.entity.OilAssayMainItemRec;
import com.repair.oil.service.IOilAssayMainItemRecService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @see 根据Id查出所有油水化验主记录
 * @author 方岳
 * @date 2015年12月23日
 * @version 1.0
 */

public class LoadOilAssayMainItemRecAction extends BaseAction{
	
	private Long recId;
	private IOilAssayMainItemRecService oilAssayMainItemRecService;
	@Override
	public String execute() throws Exception {
		//String id=this.request.getParameter("recId");
		OilAssayMainItemRec rec = oilAssayMainItemRecService.findById(recId);
		this.request.setAttribute("rec", rec);
		return Action.SUCCESS;
	}
	public void setOilAssayMainItemRecService(
			IOilAssayMainItemRecService oilAssayMainItemRecService) {
		this.oilAssayMainItemRecService = oilAssayMainItemRecService;
	}
	public void setRecId(Long recId) {
		this.recId = recId;
	}
	
	
}
