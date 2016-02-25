package com.repair.oil.action.oilAssayMainItem;

import java.util.List;
import com.opensymphony.xwork2.Action;
import com.repair.entity.OilAssayMainItem;
import com.repair.oil.service.IOilAssayMainItemService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @see 油样化验超链接功能的实现：通过机车型号查询对应的油水化验主项目
 * @author 唐鹏
 * @date 2015年12月23日
 * @version 1.0
 */
public class ListOilAMIByJcTypeAction extends BaseAction{

	private IOilAssayMainItemService oilAssayMainItemService;
	private String jcType;
	@Override
	public String execute() throws Exception {
		List<OilAssayMainItem> oilAssayMainItemList=oilAssayMainItemService.listUseByJcType(jcType);
		request.setAttribute("oilAssayMainItemList", oilAssayMainItemList);
		return Action.SUCCESS;
	}

	public void setOilAssayMainItemService(
			IOilAssayMainItemService oilAssayMainItemService) {
		this.oilAssayMainItemService = oilAssayMainItemService;
	}

	public void setJcType(String jcType) {
		this.jcType = jcType;
	}

	
	
}
