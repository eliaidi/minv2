package com.repair.oil.action.oilAssayChildItemRec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.opensymphony.xwork2.Action;
import com.repair.entity.OilAssayChildItemRec;
import com.repair.entity.OilAssayMainItem;
import com.repair.entity.OilAssayMainItemRec;
import com.repair.oil.service.IOilAssayChildItemRecService;
import com.repair.oil.service.IOilAssayMainItemRecService;
import com.repair.util.action.BaseAction;

/**
 * 通过油化实验记录主表Id,查询对应的油化实验记录数据
 * @see 
 * @author 唐鹏
 * @date 2015年12月23日
 * @version 1.0
 */
public class ListOilAssayChildItemRecByIdAction extends BaseAction{

	private IOilAssayMainItemRecService oilAssayMainItemRecService;
	private IOilAssayChildItemRecService oilAssayChildItemRecService;
	private Long planDateId;
	
	@Override
	public String execute() throws Exception {
		/**通过日计划Id查询油化实验记录主表**/
		OilAssayMainItemRec  oamItemRec=oilAssayMainItemRecService.findOilAssayMainItemRecByPlanDateId(planDateId);
		if(oamItemRec!=null)
		{
			/**通过油化实验记录主表Id,查询对应的油化实验记录IAO数据**/
			List<OilAssayChildItemRec> recList=oilAssayChildItemRecService.listOilAssayChildItemRecByMainItemId(oamItemRec.getId());
			Map<OilAssayMainItem, List<OilAssayChildItemRec>> map=new HashMap<OilAssayMainItem, List<OilAssayChildItemRec>>();
			for (OilAssayChildItemRec rec : recList) {
				List<OilAssayChildItemRec> tempList=map.get(rec.getChildItem().getItem());
				if(tempList==null)
				{
					tempList=new ArrayList<OilAssayChildItemRec>();
				}
				tempList.add(rec);
				map.put(rec.getChildItem().getItem(), tempList);
			}
			request.setAttribute("map", map);
		}
		request.setAttribute("oamItemRec", oamItemRec);
		return Action.SUCCESS;
	}

	public void setOilAssayMainItemRecService(
			IOilAssayMainItemRecService oilAssayMainItemRecService) {
		this.oilAssayMainItemRecService = oilAssayMainItemRecService;
	}

	

	public void setOilAssayChildItemRecService(
			IOilAssayChildItemRecService oilAssayChildItemRecService) {
		this.oilAssayChildItemRecService = oilAssayChildItemRecService;
	}

	public void setPlanDateId(Long planDateId) {
		this.planDateId = planDateId;
	}
	
	
}
