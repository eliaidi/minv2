package com.repair.oil.action.oilAssayMainItemRec;


import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.constant.Constants;
import com.repair.entity.JcPlanDate;
import com.repair.entity.OilAssayChildItem;
import com.repair.entity.OilAssayChildItemRec;
import com.repair.entity.OilAssayMainItem;
import com.repair.entity.OilAssayMainItemRec;
import com.repair.oil.service.IJcPlanDateService;
import com.repair.oil.service.IOilAssayMainItemRecService;
import com.repair.oil.service.IOilAssayMainItemService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @see 添加油水化验机车
 * @author 周云韬
 * @date 2015-12-23
 * @version 1.0
 */
public class AjaxAddOilAMItemRecAction extends BaseAction implements ModelDriven<OilAssayMainItemRec>{
	
	private IOilAssayMainItemRecService oilAssayMainItemRecService;
	private IJcPlanDateService jcPlanDateService;
	private IOilAssayMainItemService oilAssayMainItemService;
	
	private OilAssayMainItemRec mainRec=new OilAssayMainItemRec();
	
	private Long planDateId;
	
	@Override
	public String execute() throws Exception {
		
		
		if(planDateId == null){
			writeJson(1, "日计划ID为空");
			return null;
		}
		
		JcPlanDate pd=jcPlanDateService.findById(planDateId);
		mainRec.setPlanDate(pd);
		
		//保存子记录
		List<OilAssayMainItem> mainItemList=oilAssayMainItemService.listUseByJcType(pd.getJcTypeValue());
		Set<OilAssayChildItemRec> recSet=new HashSet<OilAssayChildItemRec>();
		for (OilAssayMainItem mainItem : mainItemList) {
			//禁用状态
			if(mainItem.getStatus() == Constants.OIL_AM_ITEM_STATUS_DISABLE){
				continue;
			}
			Iterator<OilAssayChildItem> childItemIt=mainItem.getChildItemSet().iterator();
			while (childItemIt.hasNext()) {
				OilAssayChildItem childItem=childItemIt.next();
				OilAssayChildItemRec rec=new OilAssayChildItemRec();
				rec.setChildItem(childItem);
				rec.setStatus(childItem.getStatus());
				rec.setMainItemRec(mainRec);
				rec.setUnitMeasure(childItem.getUnitMeasure());
				recSet.add(rec);
			}
		}
		mainRec.setChildItemRec(recSet);
		mainRec.setReceiveUsers(getLoginUsers());
		Long mainItemId=(Long) oilAssayMainItemRecService.save(mainRec);
		
		if(mainItemId == null || mainItemId == 0){
			writeJson(1, Constants.COMMON_MESSAGE_OPERATE_ERROR);
			return null;
		}
		
		
		
		writeJson(0, Constants.COMMON_MESSAGE_OPERATE_SUC);
		return null;
	}

	public void setOilAssayMainItemRecService(
			IOilAssayMainItemRecService oilAssayMainItemRecService) {
		this.oilAssayMainItemRecService = oilAssayMainItemRecService;
	}

	public OilAssayMainItemRec getModel() {
		return this.mainRec;
	}

	public void setPlanDateId(Long planDateId) {
		this.planDateId = planDateId;
	}

	public void setJcPlanDateService(IJcPlanDateService jcPlanDateService) {
		this.jcPlanDateService = jcPlanDateService;
	}

	public void setOilAssayMainItemService(
			IOilAssayMainItemService oilAssayMainItemService) {
		this.oilAssayMainItemService = oilAssayMainItemService;
	}
	
	
}