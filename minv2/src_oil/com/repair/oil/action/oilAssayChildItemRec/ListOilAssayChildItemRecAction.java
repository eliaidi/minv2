package com.repair.oil.action.oilAssayChildItemRec;

import java.util.Iterator;
import java.util.List;
import com.opensymphony.xwork2.Action;
import com.repair.constant.Constants;
import com.repair.entity.OilAssayChildItem;
import com.repair.entity.OilAssayChildItemRec;
import com.repair.entity.OilAssayMainItem;
import com.repair.oil.service.IOilAssayChildItemRecService;
import com.repair.oil.service.IOilAssayMainItemService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @see 通过日计划Id 化验主项目Id 查询，油水化验主项目显示对应的主记录的子记录
 * @author 唐鹏
 * @date 2015年12月23日
 * @version 1.0
 */
public class ListOilAssayChildItemRecAction extends BaseAction{

	private IOilAssayChildItemRecService oilAssayChildItemRecService;
	private IOilAssayMainItemService oilAssayMainItemService;
	private Long planDateId;
	private Long mainItemId;
	@Override
	public String execute() throws Exception {
		List<OilAssayChildItemRec> oilAssayChildItemRecList= oilAssayChildItemRecService.listByConditions(planDateId, mainItemId);
		
		//如果没有油水化验记录，进行添加
		if(oilAssayChildItemRecList.size() == 0){
			OilAssayMainItem mainItem=oilAssayMainItemService.findById(mainItemId);
			Iterator<OilAssayChildItem> it=mainItem.getChildItemSet().iterator();
			while (it.hasNext()) {
				OilAssayChildItem childItem=it.next();
				if(childItem.getStatus() == Constants.OIL_AMI_REC_ASSAY_STATUS_STAY_ASSAY);
				OilAssayChildItemRec rec=new OilAssayChildItemRec();
				rec.setChildItem(childItem);
				//rec.setMainItemRec(mainItemRec)
				rec.setStatus(childItem.getStatus());
				rec.setUnitMeasure(childItem.getUnitMeasure());
				oilAssayChildItemRecService.save(rec);
			}
		}
		
		
		request.setAttribute("oilAssayChildItemRecList", oilAssayChildItemRecList);
		
		
		return Action.SUCCESS;
	}

	public void setOilAssayChildItemRecService(
			IOilAssayChildItemRecService oilAssayChildItemRecService) {
		this.oilAssayChildItemRecService = oilAssayChildItemRecService;
	}

	public void setPlanDateId(Long planDateId) {
		this.planDateId = planDateId;
	}

	public void setMainItemId(Long mainItemId) {
		this.mainItemId = mainItemId;
	}
	
	
}
