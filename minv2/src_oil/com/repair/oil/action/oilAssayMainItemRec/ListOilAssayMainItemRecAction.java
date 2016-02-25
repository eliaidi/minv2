package com.repair.oil.action.oilAssayMainItemRec;

import java.util.List;
import com.opensymphony.xwork2.Action;
import com.repair.entity.OilAssayMainItemRec;
import com.repair.oil.service.IOilAssayMainItemRecService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @see 查出所有油水化验主记录
 * @author 唐鹏
 * @date 2015年12月23日
 * @version 1.0
 */
public class ListOilAssayMainItemRecAction extends BaseAction{

	private IOilAssayMainItemRecService oilAssayMainItemRecService;
	
	@Override
	public String execute() throws Exception {
		List<OilAssayMainItemRec> OACIList=oilAssayMainItemRecService.listAll();
		request.setAttribute("oilAssayMainItemRecList", OACIList);
		return Action.SUCCESS;
	}

	public void setOilAssayMainItemRecService(
			IOilAssayMainItemRecService oilAssayMainItemRecService) {
		this.oilAssayMainItemRecService = oilAssayMainItemRecService;
	}
	
	
}
